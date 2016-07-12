/**
 * 
 */
package com.github.mcac0006.ravelin.order;

import com.github.mcac0006.ravelin.base.Device;
import com.github.mcac0006.ravelin.base.Event;
import com.github.mcac0006.ravelin.order.Order;


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
     * The order to update.
     */
    private Order order;

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

    public OrderEvent(int timestamp, String customerId, String tempCustomerId, Order order, Device device, String deviceId) {

        super(timestamp);
        this.customerId = customerId;
        this.tempCustomerId = tempCustomerId;
        this.order = order;
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

        return "v2/order";
    }

    @Override public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        OrderEvent that = (OrderEvent) o;

        if (getCustomerId() != null ? !getCustomerId().equals(that.getCustomerId()) : that.getCustomerId() != null)
            return false;
        if (getTempCustomerId() != null ? !getTempCustomerId().equals(that.getTempCustomerId()) : that.getTempCustomerId() != null)
            return false;
        if (order != null ? !order.equals(that.order) : that.order != null)
            return false;
        if (getDevice() != null ? !getDevice().equals(that.getDevice()) : that.getDevice() != null)
            return false;
        return getDeviceId() != null ? getDeviceId().equals(that.getDeviceId()) : that.getDeviceId() == null;

    }

    @Override public int hashCode() {

        int result = super.hashCode();
        result = 31 * result + (getCustomerId() != null ? getCustomerId().hashCode() : 0);
        result = 31 * result + (getTempCustomerId() != null ? getTempCustomerId().hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (getDevice() != null ? getDevice().hashCode() : 0);
        result = 31 * result + (getDeviceId() != null ? getDeviceId().hashCode() : 0);
        return result;
    }

    @Override public String toString() {

        return "OrderEvent{" +
               "customerId='" + customerId + '\'' +
               ", tempCustomerId='" + tempCustomerId + '\'' +
               ", order=" + order +
               ", device=" + device +
               ", deviceId='" + deviceId + '\'' +
               '}';
    }
}
