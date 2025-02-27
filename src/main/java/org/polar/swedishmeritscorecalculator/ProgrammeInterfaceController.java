package org.polar.swedishmeritscorecalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProgrammeInterfaceController {
    @FXML
    private void switchToProgramme() {
        SceneManager.changeScene("Programme_Interface.fxml");
        System.out.println("Programme_Interface.fxml");
    }

    private HighSchoolSystem main;

    public void setMainApp(HighSchoolSystem mainApp) {
        this.main = mainApp;
    }
}
