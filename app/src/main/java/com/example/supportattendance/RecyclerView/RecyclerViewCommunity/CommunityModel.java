package com.example.supportattendance.RecyclerView.RecyclerViewCommunity;

public class CommunityModel {
    private int NumOfSession, image;
    private String name;

    public CommunityModel(String name, int numOfSession, int image) {
        NumOfSession = numOfSession;
        this.image = image;
        this.name = name;
    }


    public int getNumOfSession() {
        return NumOfSession;
    }

    public void setNumOfSession(int numOfSession) {
        NumOfSession = numOfSession;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }
}
