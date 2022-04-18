package com.teama.applidarcalculator.Controller;

import com.teama.applidarcalculator.View;
import com.teama.applidarcalculator.ViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TaskAndTeorController {

    @FXML
    private ImageView imageTeor;


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

    @FXML
    protected void onPrevPage(){
        ViewSwitcher.switchTo(View.PARAMETER);
    }


    public void onImageTeor1() {
        imageTeor.setImage(new Image("com/teama/applidarcalculator/Image/ImageTeor1.png"));
    }

    public void onImageTeor2() {
        imageTeor.setImage(new Image("com/teama/applidarcalculator/Image/ImageTeor2.png"));
    }

    public void onImageTeor3() {
        imageTeor.setImage(new Image("com/teama/applidarcalculator/Image/ImageTeor3.png"));
    }
}
