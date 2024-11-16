package com.example.quotes;
public class Quote {
    private String title;
    private int imageResId;
    private String text;
    private boolean isExpanded;


    public Quote(String title, int imageResId) {
        this.title = title;
        this.imageResId = imageResId;
        this.text = "";
        this.isExpanded = false;
    }


    public Quote(String title, int imageResId, String text) {
        this.title = title;
        this.imageResId = imageResId;
        this.text = text;
        this.isExpanded = false;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getText() {
        return text;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
