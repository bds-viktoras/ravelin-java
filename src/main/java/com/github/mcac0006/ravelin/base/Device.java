/**
 * 
 */
package com.github.mcac0006.ravelin.base;

import static java.lang.String.format;
import java.util.regex.Pattern;

/**
 * A device is a physical object that a customer uses to interact with your application. Examples
 * include a mobile phone, tablet or laptop.
 * 
 * @author <a href="matthew.cachia@gmail.com">matthew.cachia</a>
 *
 */
public class Device {

    private String deviceId;

    private String type;

    private String manufacturer;

    private String model;

    private String os;

    private String ipAddress;

    private String browser;

    private String userAgent;

    private Boolean javascriptEnabled;

    private Boolean cookiesEnabled;

    private String screenResolution;

    public Device(String deviceId,
                  String type,
                  String manufacturer,
                  String model,
                  String os,
                  String ipAddress,
                  String browser,
                  String userAgent,
                  Boolean javascriptEnabled,
                  Boolean cookiesEnabled,
                  String screenResolution) {
        super();
        setDeviceId(deviceId);
        setType(type);
        setManufacturer(manufacturer);
        setModel(model);
        setOs(os);
        setIpAddress(ipAddress);
        setBrowser(browser);
        setUserAgent(userAgent);
        setJavascriptEnabled(javascriptEnabled);
        setCookiesEnabled(cookiesEnabled);
        setScreenResolution(screenResolution);
    }


    public String getDeviceId() {

        return deviceId;
    }


    public void setDeviceId(String deviceId) {

        this.deviceId = deviceId;
    }


    public String getType() {

        return type;
    }


    public void setType(String type) {

        this.type = type;
    }


    public String getManufacturer() {

        return manufacturer;
    }


    public void setManufacturer(String manufacturer) {

        this.manufacturer = manufacturer;
    }


    public String getModel() {

        return model;
    }


    public void setModel(String model) {

        this.model = model;
    }


    public String getOs() {

        return os;
    }


    public void setOs(String os) {

        this.os = os;
    }


    public String getIpAddress() {

        return ipAddress;
    }


    public void setIpAddress(String ipAddress) {

        this.ipAddress = ipAddress;
    }


    public String getBrowser() {

        return browser;
    }


    public void setBrowser(String browser) {

        this.browser = browser;
    }


    public String getUserAgent() {

        return userAgent;
    }


    public void setUserAgent(String userAgent) {

        this.userAgent = userAgent;
    }


    public Boolean getJavascriptEnabled() {

        return javascriptEnabled;
    }


    public void setJavascriptEnabled(Boolean javascriptEnabled) {

        this.javascriptEnabled = javascriptEnabled;
    }


    public Boolean getCookiesEnabled() {

        return cookiesEnabled;
    }


    public void setCookiesEnabled(Boolean cookiesEnabled) {

        this.cookiesEnabled = cookiesEnabled;
    }


    public String getScreenResolution() {

        return screenResolution;
    }


    public void setScreenResolution(String screenResolution) {

        this.screenResolution = screenResolution;
    }

    @Override public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Device device = (Device) o;

        if (getDeviceId() != null ? !getDeviceId().equals(device.getDeviceId()) : device.getDeviceId() != null)
            return false;
        if (getType() != null ? !getType().equals(device.getType()) : device.getType() != null)
            return false;
        if (getManufacturer() != null ? !getManufacturer().equals(device.getManufacturer()) : device.getManufacturer() != null)
            return false;
        if (getModel() != null ? !getModel().equals(device.getModel()) : device.getModel() != null)
            return false;
        if (getOs() != null ? !getOs().equals(device.getOs()) : device.getOs() != null)
            return false;
        if (getIpAddress() != null ? !getIpAddress().equals(device.getIpAddress()) : device.getIpAddress() != null)
            return false;
        if (getBrowser() != null ? !getBrowser().equals(device.getBrowser()) : device.getBrowser() != null)
            return false;
        if (getUserAgent() != null ? !getUserAgent().equals(device.getUserAgent()) : device.getUserAgent() != null)
            return false;
        if (getJavascriptEnabled() != null ? !getJavascriptEnabled().equals(device.getJavascriptEnabled()) : device.getJavascriptEnabled() != null)
            return false;
        if (getCookiesEnabled() != null ? !getCookiesEnabled().equals(device.getCookiesEnabled()) : device.getCookiesEnabled() != null)
            return false;
        return getScreenResolution() != null ? getScreenResolution().equals(device.getScreenResolution()) : device.getScreenResolution() == null;

    }

    @Override public int hashCode() {

        int result = getDeviceId() != null ? getDeviceId().hashCode() : 0;
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getManufacturer() != null ? getManufacturer().hashCode() : 0);
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + (getOs() != null ? getOs().hashCode() : 0);
        result = 31 * result + (getIpAddress() != null ? getIpAddress().hashCode() : 0);
        result = 31 * result + (getBrowser() != null ? getBrowser().hashCode() : 0);
        result = 31 * result + (getUserAgent() != null ? getUserAgent().hashCode() : 0);
        result = 31 * result + (getJavascriptEnabled() != null ? getJavascriptEnabled().hashCode() : 0);
        result = 31 * result + (getCookiesEnabled() != null ? getCookiesEnabled().hashCode() : 0);
        result = 31 * result + (getScreenResolution() != null ? getScreenResolution().hashCode() : 0);
        return result;
    }

    @Override public String toString() {

        return "Device{" +
               "deviceId='" + deviceId + '\'' +
               ", type='" + type + '\'' +
               ", manufacturer='" + manufacturer + '\'' +
               ", model='" + model + '\'' +
               ", os='" + os + '\'' +
               ", ipAddress='" + ipAddress + '\'' +
               ", browser='" + browser + '\'' +
               ", userAgent='" + userAgent + '\'' +
               ", javascriptEnabled=" + javascriptEnabled +
               ", cookiesEnabled=" + cookiesEnabled +
               ", screenResolution='" + screenResolution + '\'' +
               '}';
    }
}
