package com.teama.applidarcalculator.Controller;

import com.teama.applidarcalculator.Entity.CalculatorLidar;
import com.teama.applidarcalculator.View;
import com.teama.applidarcalculator.ViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CalLidarController {

    public TextField heightOfTheAirplaneAboveTheSeaSurface;
    public TextField depthOfTheWaterLayerBeingImaged;
    public TextField thicknessOfTheWaterLayerBeingImaged;
    public TextField powerTransmittedByTheLaser;
    public TextField transmittanceByTheAir;
    public TextField transmittanceByTheWaterSurface;
    public TextField solidAngleOfTheReceiverApertureAsSeenFromDepthZ;
    public TextField waterVSFFor180DegBackscatter;
    public TextField waterBeamSpreadFunction;
    public TextField depthAveragedAttenuationCoefficientForUpwellingIrradianceE;
    public Label resultCalLidar;

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
    protected void onTaskAndLitButton(){
        ViewSwitcher.switchTo(View.TASKANDLIT);
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

    //Кнопка расчитывает лидарное уравнеи и выводит его в
    @FXML
    protected void onCalButton(){

        try {
            double height = Double.parseDouble(heightOfTheAirplaneAboveTheSeaSurface.getText());
            double depth = Double.parseDouble(depthOfTheWaterLayerBeingImaged.getText());
            double thickness = Double.parseDouble(thicknessOfTheWaterLayerBeingImaged.getText());
            double powerTrans = Double.parseDouble(powerTransmittedByTheLaser.getText());
            double transmitAir = Double.parseDouble(transmittanceByTheAir.getText());
            double transmitSerf = Double.parseDouble(transmittanceByTheWaterSurface.getText());
            double solidAnge = Double.parseDouble(solidAngleOfTheReceiverApertureAsSeenFromDepthZ.getText());
            double water180 = Double.parseDouble(waterVSFFor180DegBackscatter.getText());
            double waterBeam = Double.parseDouble(waterBeamSpreadFunction.getText());
            double depthE = Double.parseDouble(depthAveragedAttenuationCoefficientForUpwellingIrradianceE.getText());

            CalculatorLidar calculatorLidar = new CalculatorLidar(height, depth, thickness, powerTrans,
                    transmitAir, transmitSerf, solidAnge, water180, waterBeam, depthE);

            resultCalLidar.setText(String.valueOf(calculatorLidar.lad()));
        } catch (NumberFormatException e){
            waterBeamSpreadFunction.setStyle("-fx-background-color: red");
            System.out.println(e);
        } catch (Exception e){
            System.out.println(e);
        }
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

    private boolean valid(String value){
        try {
            double b =Double.parseDouble(value);
            return  true;
        } catch (NumberFormatException e){
            return true;
        }
    }
}
