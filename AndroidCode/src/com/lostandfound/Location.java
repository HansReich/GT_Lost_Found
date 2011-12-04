package com.lostandfound;

/**
 * describes a place where a found item is
 * being kept for the owner
 * 
 * @author Hans Reichenbach
 *
 */
public class Location {
   private int xCoord, yCoord, buildNum;
   private String name, phoneNum, email;
       
    public int getxCoord() {
        return xCoord;
    }
    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }
    
    public int getyCoord() {
        return yCoord;
    }
    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }
    
    public int getBuildNum() {
        return buildNum;
    }
    public void setBuildNum(int buildNum) {
        this.buildNum = buildNum;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
