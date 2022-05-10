package com.example.view;

import com.example.model.NewtonCotes;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class HelloController {

    @FXML private WebView functionIView;
    @FXML private WebView functionIIView;
    @FXML private WebView functionIIIView;
    @FXML private WebView functionIVView;
    @FXML private WebView functionVView;
    @FXML private RadioButton function1Button;
    @FXML private RadioButton function2Button;
    @FXML private RadioButton function3Button;
    @FXML private RadioButton function4Button;
    @FXML private RadioButton function5Button;
    @FXML private RadioButton NewtonCotesButton;
    @FXML private RadioButton GaussButton;
    @FXML private Button calculateButton;
    @FXML private TextField iterationNumberField;
    @FXML private TextField beginField;
    @FXML private TextField endField;
    @FXML private TextField epsField;



    String resultString;

    NewtonCotes newtonCotes = new NewtonCotes();


    @FXML private void initialize() {
        functionIView.getEngine().loadContent("<math display=\\\"block\\\"><mi>y</mi><mo>=</mo><mi>2x+1</mi></math>");
        functionIIView.getEngine().loadContent("<math display=\\\"block\\\"><mi>y</mi><mo>=</mo><mi>|x|</mi></math>");
        functionIIIView.getEngine().loadContent("<math display=\\\"block\\\"><mi>y</mi><mo>=</mo><msup><mi>x</mi><mn>5</mn></msup><mi>+</mi><msup><mi>x</mi><mn>4</mn></msup><mi>-2</mi><msup><mi>x</mi><mn>3</mn></msup><mi>-3</mi></math>");
        functionIVView.getEngine().loadContent("<math display=\\\"block\\\"><mi>y</mi><mo>=</mo><mi>cos(x)</mi></math>");
        functionVView.getEngine().loadContent("<math display=\\\"block\\\"><mi>y</mi><mo>=</mo><mi>|cos(x)+1|+</mi><msup><mi>x</mi><mn>3</mn></msup><mi>+1</mi></math>");

    }


    private String chooseFunctionVariant() {
        if(function1Button.isSelected()){
            return "functionI";
        } else if (function2Button.isSelected()) {
            return "functionII";
        } else if (function3Button.isSelected()) {
            return "functionIII";
        } else if (function4Button.isSelected()) {
            return "functionIV";
        } else if (function5Button.isSelected()) {
            return "functionV";
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


    @FXML
    protected void onGraphButtonPressed() {
        double firstPoint = 0;
        double lastPoint = 0;
        if (beginField.getText().matches("^[+-]?(([1-9]\\d*)|0)(\\.\\d+)?")) {
            firstPoint = Double.parseDouble(beginField.getText());
        } else {
            openWarningDialog("Zły format podczas wprowadzania poczatku przedziału");
        }
        if (endField.getText().matches("^[+-]?(([1-9]\\d*)|0)(\\.\\d+)?")) {
            lastPoint = Double.parseDouble(endField.getText());
        } else {
            openWarningDialog("Zły format podczas wprowadzania końca przedziału");
        }
        if(firstPoint > lastPoint) {
            double temp = firstPoint;
            firstPoint = lastPoint;
            lastPoint = temp;
        }
        String function = chooseFunctionVariant();
        LineChart<Number, Number> lineChart = new LineChart<>(new NumberAxis(), new NumberAxis());

        lineChart.setAnimated(false);
        lineChart.setCreateSymbols(true);
        //lineChart.getData().addAll(nodesSeries, originalSeries, interpolationSeries);

        Scene scene = new Scene(lineChart, 500, 400);
        scene.getStylesheets().add(getClass().getResource("chart.css").toExternalForm());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


    @FXML private int onCalculateButtonPressed() {
        if(!function1Button.isSelected() && !function2Button.isSelected() && !function3Button.isSelected()) {
            openWarningDialog("Nie wybrano funkcji");
            return -1;
        }/*
        intervalBeginValue = formatDoubleInputField(beginField);
        intervalEndValue = formatDoubleInputField(endField);
        epsValue= formatDoubleInputField(epsField);
        if(NewtonCotesButton.isSelected()){
            iterationNumberValue = formatIntInputField(iterationNumberField);
            result = newtonCotes.calculateNewtonCotes(intervalBeginValue, intervalEndValue, chooseFunctionVariant(), iterationNumberValue, epsValue);
            //nie wiem co zrobic z tym eps tutaj
            resultString = "Wynik obliczeń:    " + result;
            openWarningDialog(resultString);
        }*/
        return 0;
    }

}