package com.github.mcac0006.ravelin.paymentmethodevent;

import com.github.mcac0006.ravelin.base.Device;
import com.github.mcac0006.ravelin.base.Event;
import com.github.mcac0006.ravelin.base.paymentmethod.PaymentMethod;

/**
 * Created by matthew.cachia on 05/07/2016.
 */
public class PaymentMethodEvent extends Event {

    private String customerId;

    private String tempCustomerId;

    private PaymentMethod paymentMethod;

    private Device device;

    private String deviceId;

    public PaymentMethodEvent(int timestamp, String customerId, String tempCustomerId, PaymentMethod paymentMethod, Device device, String deviceId) {

        super(timestamp);
        this.customerId = customerId;
        this.tempCustomerId = tempCustomerId;
        this.paymentMethod = paymentMethod;
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

    public PaymentMethod getPaymentMethod() {

        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {

        this.paymentMethod = paymentMethod;
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

        return "v2/paymentmethod";
    }

    @Override public String toString() {

        return "PaymentMethodEvent{" +
               "customerId='" + customerId + '\'' +
               ", tempCustomerId='" + tempCustomerId + '\'' +
               ", paymentMethod=" + paymentMethod +
               ", device=" + device +
               ", deviceId='" + deviceId + '\'' +
               '}';
    }

    @Override public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        PaymentMethodEvent that = (PaymentMethodEvent) o;

        if (getCustomerId() != null ? !getCustomerId().equals(that.getCustomerId()) : that.getCustomerId() != null)
            return false;
        if (getTempCustomerId() != null ? !getTempCustomerId().equals(that.getTempCustomerId()) : that.getTempCustomerId() != null)
            return false;
        if (getPaymentMethod() != null ? !getPaymentMethod().equals(that.getPaymentMethod()) : that.getPaymentMethod() != null)
            return false;
        if (getDevice() != null ? !getDevice().equals(that.getDevice()) : that.getDevice() != null)
            return false;
        return getDeviceId() != null ? getDeviceId().equals(that.getDeviceId()) : that.getDeviceId() == null;

    }

    @Override public int hashCode() {

        int result = super.hashCode();
        result = 31 * result + (getCustomerId() != null ? getCustomerId().hashCode() : 0);
        result = 31 * result + (getTempCustomerId() != null ? getTempCustomerId().hashCode() : 0);
        result = 31 * result + (getPaymentMethod() != null ? getPaymentMethod().hashCode() : 0);
        result = 31 * result + (getDevice() != null ? getDevice().hashCode() : 0);
        result = 31 * result + (getDeviceId() != null ? getDeviceId().hashCode() : 0);
        return result;
    }
}
