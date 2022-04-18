package com.teama.applidarcalculator;

public enum View {
    TITLE("title.fxml"),
    TASKANDTEOR("task-and-teor.fxml"),
    PARAMETER("parameter.fxml"),
    CALLIDAR("cal-lidar.fxml"),
    LITER("liter.fxml");

    private String fileName;

    View(String fileName){
        this.fileName = fileName;
    }

    public String getFileName(){
        return fileName;
    }
}
