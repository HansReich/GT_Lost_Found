package com.lostandfound;

import java.util.Date;

/**
 * represents an item that has been lost
 * 
 * @author Hans Reichenbach
 *
 */
public class LostItem {
    private String description, foundLocation;
    private Date whenFound;
    private ItemType name;
    private Location pickupLocation;
    
    public String getFoundLocation() {
        return foundLocation;
    }
    public void setFoundLocation(String foundAt) {
        this.foundLocation = foundAt;
    }
    
    public Location getPickupLocation() {
        return pickupLocation;
    }
    public void setPickupLocation(Location whereAt) {
        this.pickupLocation = whereAt;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Date getWhenFound() {
        return whenFound;
    }
    public void setWhenFound(Date whenFound) {
        this.whenFound = whenFound;
    }
    
    public ItemType getName() {
        return name;
    }
    public void setName(ItemType name) {
        this.name = name;
    }
}
