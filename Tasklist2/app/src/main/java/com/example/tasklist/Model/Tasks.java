package com.example.tasklist.Model;

public class Tasks {

    int id;
    String notes;
    String date;
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public Tasks(int id, String notes,String date)
    {
        this.id=id;
        this.notes = notes;
        this.date=date;
    }

    public Tasks(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
