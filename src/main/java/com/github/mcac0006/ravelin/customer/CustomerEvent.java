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

    public Customer getCustomer() {

        return customer;
    }

    public Device getDevice() {

        return device;
    }

    @Override public String getPath() {

        return "customer";
    }

    @Override public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        CustomerEvent that = (CustomerEvent) o;

        if (customer != null ? !customer.equals(that.customer) : that.customer != null)
            return false;
        if (device != null ? !device.equals(that.device) : that.device != null)
            return false;
        return getDeviceId() != null ? getDeviceId().equals(that.getDeviceId()) : that.getDeviceId() == null;

    }

    @Override public int hashCode() {

        int result = super.hashCode();
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (device != null ? device.hashCode() : 0);
        result = 31 * result + (getDeviceId() != null ? getDeviceId().hashCode() : 0);
        return result;
    }

    @Override public String toString() {

        return "CustomerEvent{" +
               "customer=" + customer +
               ", device=" + device +
               ", deviceId='" + deviceId + '\'' +
               '}';
    }
}
