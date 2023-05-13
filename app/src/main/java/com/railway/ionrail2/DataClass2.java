package com.railway.ionrail2;

public class DataClass2 {
    private String dataDate;
    private String dataTime;
    private String dataInstruction;

    public DataClass2(String dataDate, String dataTime, String dataInstruction) {
        this.dataDate = dataDate;
        this.dataTime = dataTime;
        this.dataInstruction = dataInstruction;
    }

    public String getDataDate() {
        return dataDate;
    }

    public String getDataTime() {
        return dataTime;
    }

    public String getDataInstruction() {
        return dataInstruction;
    }
    public DataClass2(){

    }
}
