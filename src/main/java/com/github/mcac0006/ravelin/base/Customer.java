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
     * Used for validation purposes only. DO NOT SET TO STATIC otherwise thread safety would be
     * jeopardized!
     */
    private transient SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Used for validation purposes only.
     */
    private transient Pattern ISO_3166_PATTERN = Pattern.compile("^[A-Z]{2,3}$");

    /**
     * Used for validation purposes only.
     */
    private transient Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    /**
     * Used for validation purposes only.
     */
    private transient Pattern MARKET_PATTERN = Pattern.compile("^[a-z0-9]*$");

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
        setTelephone(telephoneCountry);
        setTelephoneVerifiedTime(telephoneVerifiedTime);
        setTelephoneCountry(telephoneCountry);
        setLocation(location);
        setCountry(country);
        setMarket(market);
        setCustom(new HashMap<String, Object>());
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

        try {
            dateformat.parse(dateOfBirth);
        } catch (ParseException e) {
            throw new IllegalArgumentException(format("Date of birth [%s] is not in the expected yyyy-MM-dd format.", dateOfBirth));
        }
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

        if (!EMAIL_PATTERN.matcher(email).matches())
            throw new IllegalArgumentException(format("Email [%s] is not a valid email.", email));

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

        if (!ISO_3166_PATTERN.matcher(telephoneCountry).matches())
            throw new IllegalArgumentException(format("Telephone Country [%s] is not in the expected ISO-3166 format.", telephoneCountry));

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

        if (!ISO_3166_PATTERN.matcher(country).matches())
            throw new IllegalArgumentException(format("Country [%s] is not in the expected ISO-3166 format.", country));

        this.country = country;
    }


    public String getMarket() {

        return market;
    }


    public void setMarket(String market) {

        if (!MARKET_PATTERN.matcher(market).matches())
            throw new IllegalArgumentException(format("Market [%s] is not in the expected format.", market));

        this.market = market;
    }


    public Map<String, Object> getCustom() {

        return custom;
    }


    public void setCustom(Map<String, Object> custom) {

        this.custom = custom;
    }


}
