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
        this.custom = null;
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

        Location location = (Location) o;

        if (getStreet1() != null ? !getStreet1().equals(location.getStreet1()) : location.getStreet1() != null)
            return false;
        if (getStreet2() != null ? !getStreet2().equals(location.getStreet2()) : location.getStreet2() != null)
            return false;
        if (getNeighbourhood() != null ? !getNeighbourhood().equals(location.getNeighbourhood()) : location.getNeighbourhood() != null)
            return false;
        if (getZone() != null ? !getZone().equals(location.getZone()) : location.getZone() != null)
            return false;
        if (getCity() != null ? !getCity().equals(location.getCity()) : location.getCity() != null)
            return false;
        if (getRegion() != null ? !getRegion().equals(location.getRegion()) : location.getRegion() != null)
            return false;
        if (getCountry() != null ? !getCountry().equals(location.getCountry()) : location.getCountry() != null)
            return false;
        if (getPoBoxNumber() != null ? !getPoBoxNumber().equals(location.getPoBoxNumber()) : location.getPoBoxNumber() != null)
            return false;
        if (getPostalCode() != null ? !getPostalCode().equals(location.getPostalCode()) : location.getPostalCode() != null)
            return false;
        if (getLatitude() != null ? !getLatitude().equals(location.getLatitude()) : location.getLatitude() != null)
            return false;
        if (getLongitude() != null ? !getLongitude().equals(location.getLongitude()) : location.getLongitude() != null)
            return false;
        if (getGeohash() != null ? !getGeohash().equals(location.getGeohash()) : location.getGeohash() != null)
            return false;
        return getCustom() != null ? getCustom().equals(location.getCustom()) : location.getCustom() == null;

    }

    @Override public int hashCode() {

        int result = getStreet1() != null ? getStreet1().hashCode() : 0;
        result = 31 * result + (getStreet2() != null ? getStreet2().hashCode() : 0);
        result = 31 * result + (getNeighbourhood() != null ? getNeighbourhood().hashCode() : 0);
        result = 31 * result + (getZone() != null ? getZone().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getRegion() != null ? getRegion().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getPoBoxNumber() != null ? getPoBoxNumber().hashCode() : 0);
        result = 31 * result + (getPostalCode() != null ? getPostalCode().hashCode() : 0);
        result = 31 * result + (getLatitude() != null ? getLatitude().hashCode() : 0);
        result = 31 * result + (getLongitude() != null ? getLongitude().hashCode() : 0);
        result = 31 * result + (getGeohash() != null ? getGeohash().hashCode() : 0);
        result = 31 * result + (getCustom() != null ? getCustom().hashCode() : 0);
        return result;
    }

    @Override public String toString() {

        return "Location{" +
               "street1='" + street1 + '\'' +
               ", street2='" + street2 + '\'' +
               ", neighbourhood='" + neighbourhood + '\'' +
               ", zone='" + zone + '\'' +
               ", city='" + city + '\'' +
               ", region='" + region + '\'' +
               ", country='" + country + '\'' +
               ", poBoxNumber='" + poBoxNumber + '\'' +
               ", postalCode='" + postalCode + '\'' +
               ", latitude=" + latitude +
               ", longitude=" + longitude +
               ", geohash='" + geohash + '\'' +
               ", custom=" + custom +
               '}';
    }
}
