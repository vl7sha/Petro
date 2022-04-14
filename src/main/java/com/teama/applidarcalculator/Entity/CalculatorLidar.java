package com.teama.applidarcalculator.Entity;

public class CalculatorLidar {

    private double heightOfTheAirplaneAboveTheSeaSurface; //Высота самолета над поверхностью моря
    private double depthOfTheWaterLayerBeingImaged; //Глубина изображаемого слоя воды
    private double thicknessOfTheWaterLayerBeingImaged; //Толщина изображаемого слоя воды
    private double powerTransmittedByTheLaser; //Мощность, передаваемая лазером
    private double transmittanceByTheAir; //Коэффициент пропускания воздуха
    private double transmittanceByTheWaterSurface; //Коэффициент пропускания поверхностью воды
    private double solidAngleOfTheReceiverApertureAsSeenFromDepthZ; //Телесный угол апертуры приемника, видимый с глубины z
    //Угловой коэффициент вязкости воды для обратного рассеяния на 180 градусов
    private double waterVSFFor180DegBackscatter;
    private double waterBeamSpreadFunction; //Функция распространения луча воды
    //Усредненный по глубине (от 0 до z) коэффициент затухания восходящего излучения
    private double depthAveragedAttenuationCoefficientForUpwellingIrradianceE;

    //конструктор для передачи переменным значения
    public CalculatorLidar(double heightOfTheAirplaneAboveTheSeaSurface, double depthOfTheWaterLayerBeingImaged,
                           double thicknessOfTheWaterLayerBeingImaged, double powerTransmittedByTheLaser,
                           double transmittanceByTheAir, double transmittanceByTheWaterSurface,
                           double solidAngleOfTheReceiverApertureAsSeenFromDepthZ, double waterVSFFor180DegBackscatter,
                           double waterBeamSpreadFunction,
                           double depthAveragedAttenuationCoefficientForUpwellingIrradianceE) {
        this.heightOfTheAirplaneAboveTheSeaSurface = heightOfTheAirplaneAboveTheSeaSurface;
        this.depthOfTheWaterLayerBeingImaged = depthOfTheWaterLayerBeingImaged;
        this.thicknessOfTheWaterLayerBeingImaged = thicknessOfTheWaterLayerBeingImaged;
        this.powerTransmittedByTheLaser = powerTransmittedByTheLaser;
        this.transmittanceByTheAir = transmittanceByTheAir;
        this.transmittanceByTheWaterSurface = transmittanceByTheWaterSurface;
        this.solidAngleOfTheReceiverApertureAsSeenFromDepthZ = solidAngleOfTheReceiverApertureAsSeenFromDepthZ;
        this.waterVSFFor180DegBackscatter = waterVSFFor180DegBackscatter;
        this.waterBeamSpreadFunction = waterBeamSpreadFunction;
        this.depthAveragedAttenuationCoefficientForUpwellingIrradianceE =
                depthAveragedAttenuationCoefficientForUpwellingIrradianceE;
    }

    // Вычисляем поле зрения приемника, телесный угол
    public double receiverFieldOfViewSolidAngle(){
        return 1 /
                heightOfTheAirplaneAboveTheSeaSurface *
                depthOfTheWaterLayerBeingImaged;
    }

    // Вычисляем площадь апературы приемника
    private double receiverApertureArea(){
        return solidAngleOfTheReceiverApertureAsSeenFromDepthZ *
                (heightOfTheAirplaneAboveTheSeaSurface + depthOfTheWaterLayerBeingImaged);
    }

    // Вычисляем лядар
    public double lad(){
        return  powerTransmittedByTheLaser *
                Math.pow(transmittanceByTheAir,2) *
                Math.pow(transmittanceByTheWaterSurface,2) *
                receiverApertureArea() *
                receiverFieldOfViewSolidAngle() *
                Math.exp(waterBeamSpreadFunction * depthOfTheWaterLayerBeingImaged) *
                waterVSFFor180DegBackscatter *
                Math.exp(depthAveragedAttenuationCoefficientForUpwellingIrradianceE *
                        depthOfTheWaterLayerBeingImaged) *
                thicknessOfTheWaterLayerBeingImaged;
    }
}
