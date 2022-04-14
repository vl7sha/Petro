package com.teama.applidarcalculator;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        var scene = new Scene(new AnchorPane());

        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.TITLE);

        stage.setTitle("Приложение");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
            logout(stage);
        });
    }

    // метод вызывающий подверждение о закрытие
    public void logout(Stage stage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Выход");
        alert.setHeaderText("Вы выходите!!");
        alert.setContentText("Вы запомнили число");

        if (alert.showAndWait().get() == ButtonType.OK){
            System.out.println("Закрытие прошло успешно");
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}