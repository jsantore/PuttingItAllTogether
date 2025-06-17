package bsu.comp152.puttingitalltogether;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage)  {
        Scene windowPane = null;
        FXMLLoader uiLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        try {
            windowPane = new Scene(uiLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        stage.setTitle("University Data");
        stage.setScene(windowPane);
        stage.show();
    }
}
