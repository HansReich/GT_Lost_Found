package com.lostandfound;

/**
 * represents an item that has been lost
 * 
 * @author Hans Reichenbach
 *
 */
public class LostItem {
    private String item, description, foundLocation, dateFound;
    private String contactEmail, contactPhone, pickupLocation; 
    
    /**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the foundLocation
	 */
	public String getFoundLocation() {
		return foundLocation;
	}
	/**
	 * @param foundLocation the foundLocation to set
	 */
	public void setFoundLocation(String foundLocation) {
		this.foundLocation = foundLocation;
	}
	/**
	 * @return the dateFound
	 */
	public String getDateFound() {
		return dateFound;
	}
	/**
	 * @param dateFound the dateFound to set
	 */
	public void setDateFound(String dateFound) {
		this.dateFound = dateFound;
	}
	/**
	 * @return the contactEmail
	 */
	public String getContactEmail() {
		return contactEmail;
	}
	/**
	 * @param contactEmail the contactEmail to set
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	/**
	 * @return the contactPhone
	 */
	public String getContactPhone() {
		return contactPhone;
	}
	/**
	 * @param contactPhone the contactPhone to set
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	/**
	 * @return the pickupLocation
	 */
	public String getPickupLocation() {
		return pickupLocation;
	}
	/**
	 * @param pickupLocation the pickupLocation to set
	 */
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
}
