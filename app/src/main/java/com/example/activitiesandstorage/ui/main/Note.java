package com.example.activitiesandstorage.ui.main;

public class Note {
    public static final String BASE_NOTE_KEY = "Name";
    public static final String BASE_NOTE_CONTENT ="Content";
    String name;
    String content;

    public Note(String tempName, String tempContent) {
        if (tempName.equals(null) && tempContent.equals(null)) {
            this.name = "Example Header";
            this.content = "Example Content";
        } else {
            this.name = tempName;
            this.content = tempContent;
        }
    }

    public void setName(String name){
        this.name=name;
    }
    public void setContent(String content){
        this.content=content;
    }

    public String getNote(){
        return this.name +"\n"+this.content;
    }
}