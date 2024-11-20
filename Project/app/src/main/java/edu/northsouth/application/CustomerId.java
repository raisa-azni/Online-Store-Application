package edu.northsouth.application;

/**
 * Customer type class
 * @author tushar
 * @version 1.0
 */
public class CustomerId
{
    private String name;
    private String email;
    private String gender;
    private String location;
    private String phn_no;

    /**
     * Constractor of the class
     * takes no parameter
     */
    public CustomerId() {

    }


    /**
     * get name of the user
     * @return name string type
     */
    public String getName() {
        return name;
    }

    /**
     * set the name of the user
     * @param name String type
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get email of the user
     * @return email string type
     */
    public String getEmail() {
        return email;
    }

    /**
     * set the email of the user
     * @param email String type
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get gender of the user
     * @return gender string type
     */
    public String getGender() {
        return gender;
    }

    /**
     * set the gender of the user
     * @param gender String type
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * get locatio of the user
     * @return locatio string type
     */
    public String getLocation() {
        return location;
    }

    /**
     * set the location of the user
     * @param location String type
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * get phone number of the user
     * @return phnNo string type
     */
    public String getPhn_no() {
        return phn_no;
    }

    /**
     * set the phone number of the user
     * @param phn_no String type
     */
    public void setPhn_no(String phn_no) {
        this.phn_no = phn_no;
    }
}
