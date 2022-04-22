package com.example.view;

import javafx.fxml.FXML;
import javafx.scene.web.WebView;

public class HelloController {

    @FXML private WebView functionI;
    @FXML private WebView functionII;
    @FXML private WebView functionIII;


    @FXML
    private void initialize() {
        functionI.getEngine().loadContent("<math display=\\\"block\\\"><mi>y</mi><mo>=</mo><msup><mi>x</mi><mn>5</mn></msup><msup><mi>+x</mi><mn>4</mn></msup><msup><mi>-2x</mi><mn>3</mn></msup><mi>-3</mi></math>");
        functionII.getEngine().loadContent("<math display=\\\"block\\\"><mi>y</mi><mo>=</mo><mi>cos(x)</mi><mi>+</mi><mi>(x+1)sin(x)</mi></math>");
        functionIII.getEngine().loadContent("<math display=\\\"block\\\"><mi>y</mi><mo>=</mo><mi>|</mi><msup><mi>cos(x)</mi><mn>2</mn></msup><mi>+1</mi><mi>|</mi></math>");
    }

}