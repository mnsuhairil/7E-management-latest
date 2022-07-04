package com.example.admin.sevenmanagement;

public class dateTime {
    private String date;
    private String time;

    public dateTime() {

    }

    public dateTime(String date,String time){

        this.date=date;
        this.time=time;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

}