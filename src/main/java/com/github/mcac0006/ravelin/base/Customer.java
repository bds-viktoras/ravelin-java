/**
 * 
 */
package com.github.mcac0006.ravelin.base;

import static java.lang.String.format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Customers are your users, the central entity that all Ravelin fraud detection revolves around.
 * 
 * @author <a href="matthew.cachia@gmail.com">matthew.cachia</a>
 *
 */
public class Customer {

    /**
     * The unique identifier of this customer in your system.
     */
    private String customerId;

    /**
     * When the customer registered, in unix time (seconds).
     */
    private Integer registrationTime;

    /**
     * The full name of the customer.
     */
    private String name;

    /**
     * The given name of the customer - often the first name of a customer.
     */
    private String givenName;

    /**
     * The family name of the customer - often the last name of a customer.
     */
    private String familyName;

    /**
     * The date of birth in ISO-8601 format
     */
    private String dateOfBirth;

    /**
     * The gender of the customer.
     */
    private String gender;

    /**
     * The primary email of the customer.
     */
    private String email;

    /**
     * The unix timestamp when the customer�s email was verified.
     */
    private Integer emailVerifiedTime;

    /**
     * The username of the customer.
     */
    private String username;

    /**
     * The telephone number of the customer, including international code.
     */
    private String telephone;

    /**
     * The unix timestamp when the customer�s telephone was verified.
     */
    private Integer telephoneVerifiedTime;

    /**
     * The country this phone number is registered in.
     */
    private String telephoneCountry;

    /**
     * Where this customer was last seen.
     */
    private Location location;

    /**
     * The home country of this customer; ISO 3166 (2- or 3-letter).
     */
    private String country;

    /**
     * The logical place in which this customer exists. You can use this field to filter and segment
     * customers in the Ravelin dashboard.
     * 
     * The default market is the empty string. Must be lowercase and alphanumeric (i.e. must match
     * ^[a-z0-9]*$).
     */
    private String market;

    private Map<String, Object> custom;

    public Customer(String customerId,
                    Integer registrationTime,
                    String name,
                    String givenName,
                    String familyName,
                    String dateOfBirth,
                    String gender,
                    String email,
                    Integer emailVerifiedTime,
                    String username,
                    String telephone,
                    Integer telephoneVerifiedTime,
                    String telephoneCountry,
                    Location location,
                    String country,
                    String market) {
        super();
        setCustomerId(customerId);
        setRegistrationTime(registrationTime);
        setName(name);
        setGivenName(givenName);
        setFamilyName(familyName);
        setDateOfBirth(dateOfBirth);
        setGender(gender);
        setEmail(email);
        setEmailVerifiedTime(emailVerifiedTime);
        setUsername(username);
        setTelephone(telephone);
        setTelephoneVerifiedTime(telephoneVerifiedTime);
        setTelephoneCountry(telephoneCountry);
        setLocation(location);
        setCountry(country);
        setMarket(market);
        this.custom = null;
    }


    public String getCustomerId() {

        return customerId;
    }


    public void setCustomerId(String customerId) {

        this.customerId = customerId;
    }


    public Integer getRegistrationTime() {

        return registrationTime;
    }


    public void setRegistrationTime(Integer registrationTime) {

        this.registrationTime = registrationTime;
    }


    public String getName() {

        return name;
    }


    public void setName(String name) {

        this.name = name;
    }


    public String getGivenName() {

        return givenName;
    }


    public void setGivenName(String givenName) {

        this.givenName = givenName;
    }


    public String getFamilyName() {

        return familyName;
    }


    public void setFamilyName(String familyName) {

        this.familyName = familyName;
    }


    public String getDateOfBirth() {

        return dateOfBirth;
    }


    public void setDateOfBirth(String dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }


    public String getGender() {

        return gender;
    }


    public void setGender(String gender) {

        this.gender = gender;
    }


    public String getEmail() {

        return email;
    }


    public void setEmail(String email) {

        this.email = email;
    }


    public Integer getEmailVerifiedTime() {

        return emailVerifiedTime;
    }


    public void setEmailVerifiedTime(Integer emailVerifiedTime) {

        this.emailVerifiedTime = emailVerifiedTime;
    }


    public String getUsername() {

        return username;
    }


    public void setUsername(String username) {

        this.username = username;
    }


    public String getTelephone() {

        return telephone;
    }


    public void setTelephone(String telephone) {

        this.telephone = telephone;
    }


    public Integer getTelephoneVerifiedTime() {

        return telephoneVerifiedTime;
    }


    public void setTelephoneVerifiedTime(Integer telephoneVerifiedTime) {

        this.telephoneVerifiedTime = telephoneVerifiedTime;
    }


    public String getTelephoneCountry() {

        return telephoneCountry;
    }


    public void setTelephoneCountry(String telephoneCountry) {

        this.telephoneCountry = telephoneCountry;
    }


    public Location getLocation() {

        return location;
    }


    public void setLocation(Location location) {

        this.location = location;
    }


    public String getCountry() {

        return country;
    }


    public void setCountry(String country) {

        this.country = country;
    }


    public String getMarket() {

        return market;
    }


    public void setMarket(String market) {

        this.market = market;
    }


    public Map<String, Object> getCustom() {

        return custom;
    }


    public void addCustom(String key, Object val) {

        if (getCustom() == null)
            this.custom = new HashMap<String, Object>();

        getCustom().put(key, val);
    }

    @Override public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Customer customer = (Customer) o;

        if (getCustomerId() != null ? !getCustomerId().equals(customer.getCustomerId()) : customer.getCustomerId() != null)
            return false;
        if (getRegistrationTime() != null ? !getRegistrationTime().equals(customer.getRegistrationTime()) : customer.getRegistrationTime() != null)
            return false;
        if (getName() != null ? !getName().equals(customer.getName()) : customer.getName() != null)
            return false;
        if (getGivenName() != null ? !getGivenName().equals(customer.getGivenName()) : customer.getGivenName() != null)
            return false;
        if (getFamilyName() != null ? !getFamilyName().equals(customer.getFamilyName()) : customer.getFamilyName() != null)
            return false;
        if (getDateOfBirth() != null ? !getDateOfBirth().equals(customer.getDateOfBirth()) : customer.getDateOfBirth() != null)
            return false;
        if (getGender() != null ? !getGender().equals(customer.getGender()) : customer.getGender() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(customer.getEmail()) : customer.getEmail() != null)
            return false;
        if (getEmailVerifiedTime() != null ? !getEmailVerifiedTime().equals(customer.getEmailVerifiedTime()) : customer.getEmailVerifiedTime() != null)
            return false;
        if (getUsername() != null ? !getUsername().equals(customer.getUsername()) : customer.getUsername() != null)
            return false;
        if (getTelephone() != null ? !getTelephone().equals(customer.getTelephone()) : customer.getTelephone() != null)
            return false;
        if (getTelephoneVerifiedTime() != null ? !getTelephoneVerifiedTime().equals(customer.getTelephoneVerifiedTime()) : customer.getTelephoneVerifiedTime() != null)
            return false;
        if (getTelephoneCountry() != null ? !getTelephoneCountry().equals(customer.getTelephoneCountry()) : customer.getTelephoneCountry() != null)
            return false;
        if (getLocation() != null ? !getLocation().equals(customer.getLocation()) : customer.getLocation() != null)
            return false;
        if (getCountry() != null ? !getCountry().equals(customer.getCountry()) : customer.getCountry() != null)
            return false;
        if (getMarket() != null ? !getMarket().equals(customer.getMarket()) : customer.getMarket() != null)
            return false;
        return getCustom() != null ? getCustom().equals(customer.getCustom()) : customer.getCustom() == null;

    }

    @Override public int hashCode() {

        int result = getCustomerId() != null ? getCustomerId().hashCode() : 0;
        result = 31 * result + (getRegistrationTime() != null ? getRegistrationTime().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getGivenName() != null ? getGivenName().hashCode() : 0);
        result = 31 * result + (getFamilyName() != null ? getFamilyName().hashCode() : 0);
        result = 31 * result + (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getEmailVerifiedTime() != null ? getEmailVerifiedTime().hashCode() : 0);
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getTelephone() != null ? getTelephone().hashCode() : 0);
        result = 31 * result + (getTelephoneVerifiedTime() != null ? getTelephoneVerifiedTime().hashCode() : 0);
        result = 31 * result + (getTelephoneCountry() != null ? getTelephoneCountry().hashCode() : 0);
        result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getMarket() != null ? getMarket().hashCode() : 0);
        result = 31 * result + (getCustom() != null ? getCustom().hashCode() : 0);
        return result;
    }

    @Override public String toString() {

        return "Customer{" +
               "customerId='" + customerId + '\'' +
               ", registrationTime=" + registrationTime +
               ", name='" + name + '\'' +
               ", givenName='" + givenName + '\'' +
               ", familyName='" + familyName + '\'' +
               ", dateOfBirth='" + dateOfBirth + '\'' +
               ", gender='" + gender + '\'' +
               ", email='" + email + '\'' +
               ", emailVerifiedTime=" + emailVerifiedTime +
               ", username='" + username + '\'' +
               ", telephone='" + telephone + '\'' +
               ", telephoneVerifiedTime=" + telephoneVerifiedTime +
               ", telephoneCountry='" + telephoneCountry + '\'' +
               ", location=" + location +
               ", country='" + country + '\'' +
               ", market='" + market + '\'' +
               ", custom=" + custom +
               '}';
    }
}
