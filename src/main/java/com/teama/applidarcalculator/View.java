package com.teama.applidarcalculator;

public enum View {
    TITLE("title.fxml"),
    TASKANDLIT("task-and-lit.fxml"),
    PARAMETER("parameter.fxml"),
    CALLIDAR("cal-lidar.fxml");

    private String fileName;

    View(String fileName){
        this.fileName = fileName;
    }

    public String getFileName(){
        return fileName;
    }
}
