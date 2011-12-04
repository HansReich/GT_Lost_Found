package com.lostandfound;

/**
 * describes a place where a found item is
 * being kept for the owner
 * 
 * @author Hans Reichenbach
 *
 */
public class Location {
	public static String TAG = "Location";
	
	
	private int buildNum;
	private double xCoord, yCoord;
	private String name, phoneNum, email;
	
	//static arrays to use as a database of sorts
	private static String[] buildNames = null;
	private static Location[] buildings = null;
	
	/** constructor for a location*/
	public Location(String name, String phone, String email, double xCoord, double yCoord, int buildingNumber) {
		this.name = name;
		phoneNum = phone;
		this.email = email;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.buildNum = buildingNumber;
	}
   
	/**builds an array of locations if it doesn't already exist*/
	public static void buildLocations() {
		if(buildings == null) {
			Log.d(TAG, "buildings was null so building it now");
		   
			buildings = new Location[6];
		   
			//add in a few basic locations, eventually this would pull from a database
			buildings[0] = new Location("College of Computing", "555-5555", 
					"LostAndFound@cc.gatech.edu", -84.3974, 33.7774, 50);
			buildings[1] = new Location("Klaus Advanced Computing Building", "555-5555", 
					"KlausLostAndFound@cc.gatech.edu", -84.39806, 33.784284, 1);
			buildings[2] = new Location("Campus Recreation Center", "555-5555", 
					"CRCLostAndFound@gatech.edu", -84.4032, 33.7755, 122);
			buildings[3] = new Location("GTRI", "555-5555", 
					"LostAndFound@gtri.gatech.edu", -84.4027, 33.771, 136);
			buildings[4] = new Location("Technology Square Research Building", "555-5555", 
					"LostAndFound@tsrb.gatech.edu", -84.3901, 33.7773, 175);
			buildings[5] = new Location("Library and Information Center", "555-5555", 
					"LibraryLostAndFound@gatech.edu", -84.3958, 33.7744, 77);
		}
		
		//build the names array for spinners
		buildNames = new String[buildings.length];
		for(int i = 0; i < buildings.length; i++) {
			buildNames[i] = buildings[i].getName();
		}
		
		Log.d(TAG, "built the names array");
	}
	
	public Location[] getBuildings() {
		return buildings;
	}
	
	public String[] getBuildingNames() {
		return buildNames;
	}
       
    public double getxCoord() {
        return xCoord;
    }
    public void setxCoord(double xCoord) {
        this.xCoord = xCoord;
    }
    
    public double getyCoord() {
        return yCoord;
    }
    public void setyCoord(double yCoord) {
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
