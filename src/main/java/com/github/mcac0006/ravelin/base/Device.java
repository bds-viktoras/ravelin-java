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

    /**
     * Used for validation purposes only.
     */
    private transient static Pattern SCREEN_RESOLUTION_PATTERN = Pattern.compile("^[0-9]+x[0-9]+$");

    /**
     * Used for validation purposes only.
     */
    private transient static Pattern IP_PATTERN = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\"
                                                        + ".([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\"
                                                        + ".([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\"
                                                        + ".([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

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

        if (!IP_PATTERN.matcher(ipAddress).matches())
            throw new IllegalArgumentException(format("IP Address [%s] is not in the expected format.", ipAddress));

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

        if (!SCREEN_RESOLUTION_PATTERN.matcher(screenResolution).matches())
            throw new IllegalArgumentException(format("Screen resolution [%s] is not in the expected format.", screenResolution));

        this.screenResolution = screenResolution;
    }


}
