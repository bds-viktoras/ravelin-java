/**
 * 
 */
package com.github.mcac0006.ravelin.customer;

import com.github.mcac0006.ravelin.base.Customer;
import com.github.mcac0006.ravelin.base.Device;
import com.github.mcac0006.ravelin.base.Event;


/**
 * An event to signify when a customer registers, or changes their profile.
 * 
 * @author <a href="matthew.cachia@gmail.com">matthew.cachia</a>
 *
 */
public class CustomerEvent extends Event {

    /**
     * The customer to create or update.
     */
    private Customer customer;

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


    public CustomerEvent(int timestamp, String deviceId, Customer customer, Device device) {
        super(timestamp);
        this.deviceId = deviceId;
        this.customer = customer;
        this.device = device;
    }


    public String getDeviceId() {

        return deviceId;
    }


    public void setDeviceId(String deviceId) {

        this.deviceId = deviceId;
    }
}
