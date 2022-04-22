package com.example.view;

import javafx.fxml.FXML;
import javafx.scene.web.WebView;
import javafx.scene.control.Label;

public class HelloController {

    @FXML private WebView functionI;
    @FXML private WebView functionII;
    @FXML private WebView functionIII;
    @FXML private WebView functionVI;

    @FXML
    private void initialize() {
        functionI.getEngine().loadContent("<math display=\\\"block\\\"><mi>y</mi><mo>=</mo><msup><mi>x</mi><mn>5</mn></msup><msup><mi>+x</mi><mn>4</mn></msup><msup><mi>-2x</mi><mn>3</mn></msup><mi>-3</mi></math>");
        //trigonometricView.getEngine().loadContent("<math display=\\\"block\\\"><mi>y</mi><mo>=</mo><mi>3sin(x)+cos(2x+1)</mi></math>");
        //mixedView.getEngine().loadContent("<math display=\\\"block\\\"><mi>y</mi><mo>=</mo><mi>8|sin(x)|</mi><mi>-2</mi><msup><mi>x</mi><mn>2</mn></msup><mi>-3x</mi></math>");
    }

}