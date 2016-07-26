package com.github.mcac0006.ravelin.login;

import com.github.mcac0006.ravelin.base.Device;
import com.github.mcac0006.ravelin.base.Event;

/**
 * Created by matthew.cachia on 05/07/2016.
 */
public class LoginEvent extends Event {

    /**
     * customer logging in
     */
    private String customerId;

    /**
     * (optional) A session ID that was previously sent with anonymous events belonging to this user.
     *
     * If previous events for this customer were sent as anonymous events (with a tempCustomerId instead of a customerId), set the tempCustomerId field here to tie those together.
     *
     * Optionally, if there is device information available, send Ravelin information about the device the customer is using in this event.
     */
    private String tempCustomerId;

    /**
     * Information about the device used by this customer. Optional, and mutually exclusive with the
     * {@link #deviceId} field.
     */
    private Device device;

    /**
     * If the device used by the user was already sent in a previous event, its deviceId can be sent
     * here instead of a full device object. Optional, and mutually exclusive with the
     * {@link #device} field.
     */
    private String deviceId;

    public LoginEvent(int timestamp, String customerId, String tempCustomerId, Device device, String deviceId) {

        super(timestamp);
        this.customerId = customerId;
        this.tempCustomerId = tempCustomerId;
        this.device = device;
        this.deviceId = deviceId;
    }

    public String getCustomerId() {

        return customerId;
    }

    public void setCustomerId(String customerId) {

        this.customerId = customerId;
    }

    public String getTempCustomerId() {

        return tempCustomerId;
    }

    public void setTempCustomerId(String tempCustomerId) {

        this.tempCustomerId = tempCustomerId;
    }

    public Device getDevice() {

        return device;
    }

    public void setDevice(Device device) {

        this.device = device;
    }

    public String getDeviceId() {

        return deviceId;
    }

    public void setDeviceId(String deviceId) {

        this.deviceId = deviceId;
    }

    @Override public String getPath() {

        return "login";
    }

    @Override public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        LoginEvent that = (LoginEvent) o;

        if (getCustomerId() != null ? !getCustomerId().equals(that.getCustomerId()) : that.getCustomerId() != null)
            return false;
        if (getTempCustomerId() != null ? !getTempCustomerId().equals(that.getTempCustomerId()) : that.getTempCustomerId() != null)
            return false;
        if (getDevice() != null ? !getDevice().equals(that.getDevice()) : that.getDevice() != null)
            return false;
        return getDeviceId() != null ? getDeviceId().equals(that.getDeviceId()) : that.getDeviceId() == null;

    }

    @Override public int hashCode() {

        int result = super.hashCode();
        result = 31 * result + (getCustomerId() != null ? getCustomerId().hashCode() : 0);
        result = 31 * result + (getTempCustomerId() != null ? getTempCustomerId().hashCode() : 0);
        result = 31 * result + (getDevice() != null ? getDevice().hashCode() : 0);
        result = 31 * result + (getDeviceId() != null ? getDeviceId().hashCode() : 0);
        return result;
    }

    @Override public String toString() {

        return "LoginEvent{" +
               "customerId='" + customerId + '\'' +
               ", tempCustomerId='" + tempCustomerId + '\'' +
               ", device=" + device +
               ", deviceId='" + deviceId + '\'' +
               '}';
    }
}
