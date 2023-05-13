package com.railway.ionrail2;

public class DataClass {
    private String dataName;
    private String dataPhoneNumber;
    private String dataComplaint;

    public DataClass(String dataName, String dataPhoneNumber, String dataComplaint) {
        this.dataName = dataName;
        this.dataPhoneNumber = dataPhoneNumber;
        this.dataComplaint = dataComplaint;
    }

    public String getDataName() {
        return dataName;
    }

    public String getDataPhoneNumber() {
        return dataPhoneNumber;
    }

    public String getDataComplaint() {
        return dataComplaint;
    }
    public DataClass(){

    }
}
