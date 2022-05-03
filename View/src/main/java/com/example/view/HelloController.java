package com.example.view;

import com.example.model.GaussLegendre;
import com.example.model.NewtonCotes;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.WebView;

public class HelloController {

    @FXML private WebView functionIView;
    @FXML private WebView functionIIView;
    @FXML private WebView functionIIIView;
    @FXML private RadioButton function1Button;
    @FXML private RadioButton function2Button;
    @FXML private RadioButton function3Button;
    @FXML private RadioButton NewtonCotesButton;
    @FXML private RadioButton GaussButton;
    @FXML private Button calculateButton;
    @FXML private TextField iterationNumberField;
    @FXML private TextField beginField;
    @FXML private TextField endField;
    @FXML private TextField epsField;
    @FXML private ChoiceBox nodesNumberBox;

    private double intervalBeginValue;
    private double intervalEndValue;
    private double epsValue;
    private int nodesNumberValue;
    private int iterationNumberValue;
    private double result;
    private double[] nodesValues;
    private double[] quadratureFactors;
    String resultString;

    NewtonCotes newtonCotes = new NewtonCotes();
    GaussLegendre gaussLegendre = new GaussLegendre();


    @FXML private void initialize() {
        functionIView.getEngine().loadContent("<math display=\\\"block\\\"><mi>y</mi><mo>=</mo><msup><mi>x</mi><mn>5</mn></msup><msup><mi>+x</mi><mn>4</mn></msup><msup><mi>-2x</mi><mn>3</mn></msup><mi>-3</mi></math>");
        functionIIView.getEngine().loadContent("<math display=\\\"block\\\"><mi>y</mi><mo>=</mo><mi>cos(x)</mi><mi>+</mi><mi>(x+1)sin(x)</mi></math>");
        functionIIIView.getEngine().loadContent("<math display=\\\"block\\\"><mi>y</mi><mo>=</mo><mi>|</mi><msup><mi>cos(x)</mi><mn>2</mn></msup><mi>+1</mi><mi>|</mi></math>");
        nodesNumberBox.getItems().add("2");
        nodesNumberBox.getItems().add("3");
        nodesNumberBox.getItems().add("4");
        nodesNumberBox.getItems().add("5");
    }

    @FXML private void onNewtonCotesButtonPressed() {
        nodesNumberBox.setDisable(true);
        iterationNumberField.setDisable(false);
    }

    @FXML private void onGaussButtonPressed() {
        nodesNumberBox.setDisable(false);
        iterationNumberField.setDisable(true);
    }

    private String chooseFunctionVariant() {
        if(function1Button.isSelected()){
            return "functionI";
        } else if (function2Button.isSelected()) {
            return "functionII";
        } else if (function3Button.isSelected()) {
            return "functionIII";
        } return null;
    }


    private void openWarningDialog(String text) {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Komunikat");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.setContentText(text);
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();
    }

    private double formatDoubleInputField(TextField field) {
        if (field.getText().matches("^[+-]?(([1-9]\\d*)|0)(\\.\\d+)?")) {
            return Double.parseDouble(field.getText());
        }
        openWarningDialog("Zły format.");
        return -1;
    }

    private int formatIntInputField(TextField field) {
        if (field.getText().matches("^[0-9]*[1-9][0-9]*$")) {
            return Integer.parseInt(field.getText());
        }
        openWarningDialog("Zły format.");
        return -1;
    }


    @FXML private int onCalculateButtonPressed() {
        if(!function1Button.isSelected() && !function2Button.isSelected() && !function3Button.isSelected()) {
            openWarningDialog("Nie wybrano funkcji");
            return -1;
        }
        intervalBeginValue = formatDoubleInputField(beginField);
        intervalEndValue = formatDoubleInputField(endField);
        epsValue= formatDoubleInputField(epsField);
        if(NewtonCotesButton.isSelected()){
            iterationNumberValue = formatIntInputField(iterationNumberField);
            result = newtonCotes.calculateNewtonCotes(intervalBeginValue, intervalEndValue, chooseFunctionVariant(), iterationNumberValue, epsValue);
            //nie wiem co zrobic z tym eps tutaj
            resultString = "Wynik obliczeń:    " + result;
            openWarningDialog(resultString);
        } else if(GaussButton.isSelected()){
            if(nodesNumberBox.getSelectionModel().isSelected(0)) {
                nodesNumberValue = 2;
            } else if (nodesNumberBox.getSelectionModel().isSelected(1)) {
                nodesNumberValue = 3;
            } else if (nodesNumberBox.getSelectionModel().isSelected(2)) {
                nodesNumberValue = 4;
            } else if (nodesNumberBox.getSelectionModel().isSelected(3)) {
                nodesNumberValue = 5;
            }
            nodesValues = gaussLegendre.getNodesValues(nodesNumberValue);
            quadratureFactors = gaussLegendre.getQuadratureFactors(nodesNumberValue);
            result = gaussLegendre.calculateGaussLegendre(intervalBeginValue, intervalEndValue, chooseFunctionVariant(), nodesNumberValue,
                    gaussLegendre.getNodesValues(nodesNumberValue),
                    gaussLegendre.getQuadratureFactors(nodesNumberValue));
            resultString = "Wynik obliczeń:    " + result;
            openWarningDialog(resultString);

        }
        return 0;
    }

}