package com.teama.applidarcalculator.Controller;

import com.teama.applidarcalculator.View;
import com.teama.applidarcalculator.ViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LiterController {

    @FXML
    protected AnchorPane anchorPane;

    Stage stage;

    //Кнопка переходит на сцену с титульным листом
    @FXML
    protected void onTitleButton(){
        ViewSwitcher.switchTo(View.TITLE);
    }

    //Кнопки переходит на сцену с задачей и литературой
    @FXML
    protected void onTaskAndTeorButton(){
        ViewSwitcher.switchTo(View.TASKANDTEOR);
    }

    //Кнопка переходит на сцену с описаниями параментра
    @FXML
    protected void onParameterButton(){
        ViewSwitcher.switchTo(View.PARAMETER);
    }

    //Кнопка переходит на сцену с вычитаванием лидарного уравнения
    @FXML
    protected void onCalLidarButton(){
        ViewSwitcher.switchTo(View.CALLIDAR);
    }

    @FXML
    protected void onLiterButton(){
        ViewSwitcher.switchTo(View.LITER);
    }

    //Кнопка закрытия приложения, где есть подверждения об закрытие
    @FXML
    public void onCloseButton(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Выход");
        alert.setHeaderText("Вы выходите!!");
        alert.setContentText("Вы запомнили число?");

        if (alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) anchorPane.getScene().getWindow();
            System.out.println("Закрытие прошло успешно");
            stage.close();
        }
    }
}
