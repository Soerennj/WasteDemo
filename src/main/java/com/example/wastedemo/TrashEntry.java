package com.example.wastedemo;

public class TrashEntry {

    String department;
    int trashCanNo;
    String time;
    double weight;


    public TrashEntry (String department, int trashCanNo, String time, double weight) {
        this.department = department;
        this.trashCanNo = trashCanNo;
        this.time = time;
        this.weight = weight;
    }
    public TrashEntry()
    {
        this.department = "Not found";
        this.trashCanNo = 0;
        this.time = "00:00.00";
        this.weight = 0.0;
    }
}