package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/views/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hausarztpraxis Dr.in med. Gia Guerra");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.getIcons().add(
                new Image(getClass().getResourceAsStream("/pictures/logo-ausgeschnitten.png"))
        );

        stage.show();
    }
}

