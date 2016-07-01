package com.github.mcac0006.ravelin.base;

import static java.lang.String.format;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Locations are time-series data: every time you attach a location to a customer, Ravelin will
 * record it separately, instead of overwriting the previous location.
 * 
 * You can send Ravelin data with street addresses, and it will derive the geocode to obtain the
 * latitude and longitude, or vice versa. Specifying both address and gelocation is even more
 * preferable.
 * 
 * @author <a href="matthew.cachia@gmail.com">matthew.cachia</a>
 *
 */
public class Location {

    private transient Pattern ISO_3166_PATTERN = Pattern.compile("^[A-Z]{2,3}$");

    /**
     * First line of the street address.
     */
    private String street1;

    /**
     * Second line of the street address.
     */
    private String street2;

    /**
     * The neighbourhood of the location.
     */
    private String neighbourhood;

    /**
     * The zone of the location.
     */
    private String zone;

    /**
     * The city/village/town of the location.
     */
    private String city;

    /**
     * The state/county of the location
     */
    private String region;

    /**
     * The ISO 3166 country code (2- or 3-letter).
     */
    private String country;

    /**
     * The PO box number, if applicable.
     */
    private String poBoxNumber;

    /**
     * The postal or zip code, if applicable.
     */
    private String postalCode;

    /**
     * The latitude of the location.
     */
    private Double latitude;

    /**
     * The longitude of the location.
     */
    private Double longitude;

    /**
     * The geohash of the location, if applicable.
     */
    private String geohash;

    private Map<String, Object> custom;


    public Location(String street1,
                    String street2,
                    String neighbourhood,
                    String zone,
                    String city,
                    String region,
                    String country,
                    String poBoxNumber,
                    String postalCode,
                    Double latitude,
                    Double longitude,
                    String geohash) {
        super();
        setStreet1(street1);
        setStreet2(street2);
        setNeighbourhood(neighbourhood);
        setZone(zone);
        setCity(city);
        setRegion(region);
        setCountry(country);
        setPoBoxNumber(poBoxNumber);
        setPostalCode(postalCode);
        setLatitude(latitude);
        setLongitude(longitude);
        setGeohash(geohash);
        this.custom = new HashMap<String, Object>();
    }


    public String getStreet1() {

        return street1;
    }


    public void setStreet1(String street1) {

        this.street1 = street1;
    }


    public String getStreet2() {

        return street2;
    }


    public void setStreet2(String street2) {

        this.street2 = street2;
    }


    public String getNeighbourhood() {

        return neighbourhood;
    }


    public void setNeighbourhood(String neighbourhood) {

        this.neighbourhood = neighbourhood;
    }


    public String getZone() {

        return zone;
    }


    public void setZone(String zone) {

        this.zone = zone;
    }


    public String getCity() {

        return city;
    }


    public void setCity(String city) {

        this.city = city;
    }


    public String getRegion() {

        return region;
    }


    public void setRegion(String region) {

        this.region = region;
    }


    public String getCountry() {

        return country;
    }


    public void setCountry(String country) {

        if (!ISO_3166_PATTERN.matcher(country).matches())
            throw new IllegalArgumentException(format("Country [%s] is not in the expected ISO-3166 format.", country));

        this.country = country;
    }


    public String getPoBoxNumber() {

        return poBoxNumber;
    }


    public void setPoBoxNumber(String poBoxNumber) {

        this.poBoxNumber = poBoxNumber;
    }


    public String getPostalCode() {

        return postalCode;
    }


    public void setPostalCode(String postalCode) {

        this.postalCode = postalCode;
    }


    public Double getLatitude() {

        return latitude;
    }


    public void setLatitude(Double latitude) {

        this.latitude = latitude;
    }


    public Double getLongitude() {

        return longitude;
    }


    public void setLongitude(Double longitude) {

        this.longitude = longitude;
    }


    public String getGeohash() {

        return geohash;
    }


    public void setGeohash(String geohash) {

        this.geohash = geohash;
    }


    public Map<String, Object> getCustom() {

        return custom;
    }


    public void setCustom(Map<String, Object> custom) {

        this.custom = custom;
    }


}
