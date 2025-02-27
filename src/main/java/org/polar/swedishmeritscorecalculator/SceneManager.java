package org.polar.swedishmeritscorecalculator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {
    private static Stage primaryStage;
    private static final Map<String, Parent> sceneCache = new HashMap<>();
    private static HighSchoolSystem mainApp;

    public static void setStage(Stage stage) {
        primaryStage = stage;
    }

    public static void setMainApp(HighSchoolSystem main) {
        mainApp = main;
    }

    public static void changeScene(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(fxmlFile));
            Parent root = loader.load();

            //get the controller and pass mainApp if it's set
            Object controller = loader.getController();


            if (controller instanceof CreationInterfaceController) {
                ((CreationInterfaceController) controller).setMainApp(mainApp);
            } else if (controller instanceof ProgrammeInterfaceController) {
                ((ProgrammeInterfaceController) controller).setMainApp(mainApp);
            } else if (controller instanceof StudentInterfaceController) {
                ((StudentInterfaceController) controller).setMainApp(mainApp);
            }

            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
