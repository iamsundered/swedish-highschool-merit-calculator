package org.polar.swedishmeritscorecalculator;

import javafx.fxml.FXML;

public class StudentInterfaceController {




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
