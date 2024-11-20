package edu.northsouth.application;

/**
 * To create Store type object a that holds the necessary variables
 * @author Tushar
 * @version 1
 */
public class Store
{
    String name;
    String email;
    String phn_no;
    String store_locatio;
    String price;
    String capacity;
    String available_space;

    /**
     * Constractor for store type class
     */
    public Store() {
    }

    /**
     * get name of the store
     * @return storeName string type
     */
    public String getNmae() {
        return name;
    }

    /**
     * set the name
     * @param name String type
     */
    public void setNmae(String name) {
        this.name = name;
    }

    /**
     * get name of the store
     * @return email string type
     */
    public String getEmail() {
        return email;
    }

    /**
     * set the name
     * @param email String type
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get name of the store
     * @return phoneNo string type
     */
    public String getPhn_no() {
        return phn_no;
    }

    /**
     * set the name
     * @param phn_no String type
     */
    public void setPhn_no(String phn_no) {
        this.phn_no = phn_no;
    }

    /**
     * get name of the store
     * @return location string type
     */
    public String getLocation() {
        return store_locatio;
    }

    /**
     * set the name
     * @param store_locatio String type
     */
    public void setLocation(String store_locatio) {
        this.store_locatio = store_locatio;
    }

    /**
     * get name of the store
     * @return price string type
     */
    public String getPrice() {
        return price;
    }

    /**
     * set the name
     * @param price String type
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * get name of the store
     * @return capacit fo the store string type
     */
    public String getCapacity() {
        return capacity;
    }

    /**
     * set the name
     * @param capacity String type
     */
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    /**
     * get name of the store
     * @return available string type
     */
    public String getAvailable_space() {
        return available_space;
    }

    /**
     * set the name
     * @param available_space String type
     */
    public void setAvailable_space(String available_space) {
        this.available_space = available_space;
    }
}
