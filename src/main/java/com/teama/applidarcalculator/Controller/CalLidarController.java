package com.teama.applidarcalculator.Controller;

import com.teama.applidarcalculator.Entity.CalculatorLidar;
import com.teama.applidarcalculator.View;
import com.teama.applidarcalculator.ViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
            System.out.println(e);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    protected void onPrevPage(){
        ViewSwitcher.switchTo(View.LITER);
    }
}
