/**
 * 
 */
package com.github.mcac0006.ravelin.transaction;

import com.github.mcac0006.ravelin.base.Device;
import com.github.mcac0006.ravelin.base.Event;


/**
 * @author <a href="matthew.cachia@gmail.com">matthew.cachia</a>
 *
 */
public class OrderEvent extends Event {

    /**
     * Customer performing this order.
     */
    private String customerId;

    /**
     * (optional) A session ID, if the customer has not logged in yet.
     */
    private String tempCustomerId;

    /**
     * Optional, and mutually exclusive with the {@link #deviceId} field.
     */
    private Device device;

    /**
     * (optional) If the device used by the customer was already sent in a previous event, its
     * deviceId can be specified instead of a full {@link #device}. Optional, and mutually exclusive
     * with the {@link #device} field.
     */
    private String deviceId;


    public OrderEvent(int timestamp, String customerId, String tempCustomerId, Device device, String deviceId) {
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
}
