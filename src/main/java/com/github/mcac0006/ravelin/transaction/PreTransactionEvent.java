/**
 * 
 */
package com.github.mcac0006.ravelin.transaction;

import com.github.mcac0006.ravelin.base.Device;
import com.github.mcac0006.ravelin.base.Event;
import com.github.mcac0006.ravelin.base.paymentmethod.PaymentMethod;


/**
 * 
 * Transactions transfer money from the customer to the vendor, to fulfil an order. One transaction
 * usually fulfils an order, but not always (e.g. outstanding credit, or split payments).
 * 
 * If a transaction event call is intended to get a fraud indication before the transaction is
 * placed with the PSP, some of the transaction properties won�t be available.
 * 
 * In that case, tThis event carries all the information you have available just as a user clicked
 * the �buy� button, but before you�ve passed it through to the PSP.
 * 
 * @author <a href="matthew.cachia@gmail.com">matthew.cachia</a>
 *
 */
public class PreTransactionEvent extends Event {

    /**
     * Customer performing this order.
     */
    private String customerId;

    /**
     * (optional) A session ID, if the customer has not logged in yet.
     */
    private String tempCustomerId;

    /**
     * Payment method used for this transaction. Mutually exclusive with the
     * {@link #paymentMethodId}
     */
    private PaymentMethod paymentMethod;

    /**
     * If a payment method was already added for this user in a previous event, it can be referenced
     * here. Mutually exclusive with the {@link #paymentMethod}.
     */
    private String paymentMethodId;

    /**
     * The order this transaction is (partially) resolving.
     */
    private String orderId;


    /**
     * The transaction that is about to be committed.
     */
    private PreTransaction transaction;

    /**
     * (optional) Information about the device used by this customer. Mutually exclusive with the
     * {@link #deviceId} field.
     */
    private Device device;

    /**
     * (optional) If the device used by the user was already sent in a previous event, its deviceId
     * can be sent here instead of a full device object. Mutually exclusive with the {@link #device}
     * field.
     */
    private String deviceId;


    public PreTransactionEvent(int timestamp,
                               String customerId,
                               String tempCustomerId,
                               PaymentMethod paymentMethod,
                               String paymentMethodId,
                               String orderId,
                               PreTransaction transaction,
                               Device device,
                               String deviceId) {
        super(timestamp);
        this.customerId = customerId;
        this.tempCustomerId = tempCustomerId;
        this.paymentMethod = paymentMethod;
        this.paymentMethodId = paymentMethodId;
        this.orderId = orderId;
        this.transaction = transaction;
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


    public String getPaymentMethodId() {

        return paymentMethodId;
    }


    public void setPaymentMethodId(String paymentMethodId) {

        this.paymentMethodId = paymentMethodId;
    }


    public String getOrderId() {

        return orderId;
    }


    public void setOrderId(String orderId) {

        this.orderId = orderId;
    }


    public PreTransaction getTransaction() {

        return transaction;
    }


    public void setTransaction(PreTransaction transaction) {

        this.transaction = transaction;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PreTransactionEvent that = (PreTransactionEvent) o;

        if (getCustomerId() != null ? !getCustomerId().equals(that.getCustomerId()) : that.getCustomerId() != null)
            return false;
        if (getTempCustomerId() != null ? !getTempCustomerId().equals(that.getTempCustomerId()) : that.getTempCustomerId() != null)
            return false;
        if (getPaymentMethod() != null ? !getPaymentMethod().equals(that.getPaymentMethod()) : that.getPaymentMethod() != null)
            return false;
        if (getPaymentMethodId() != null ? !getPaymentMethodId().equals(that.getPaymentMethodId()) : that.getPaymentMethodId() != null)
            return false;
        if (getOrderId() != null ? !getOrderId().equals(that.getOrderId()) : that.getOrderId() != null) return false;
        if (getTransaction() != null ? !getTransaction().equals(that.getTransaction()) : that.getTransaction() != null)
            return false;
        if (getDevice() != null ? !getDevice().equals(that.getDevice()) : that.getDevice() != null) return false;
        return getDeviceId() != null ? getDeviceId().equals(that.getDeviceId()) : that.getDeviceId() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getCustomerId() != null ? getCustomerId().hashCode() : 0);
        result = 31 * result + (getTempCustomerId() != null ? getTempCustomerId().hashCode() : 0);
        result = 31 * result + (getPaymentMethod() != null ? getPaymentMethod().hashCode() : 0);
        result = 31 * result + (getPaymentMethodId() != null ? getPaymentMethodId().hashCode() : 0);
        result = 31 * result + (getOrderId() != null ? getOrderId().hashCode() : 0);
        result = 31 * result + (getTransaction() != null ? getTransaction().hashCode() : 0);
        result = 31 * result + (getDevice() != null ? getDevice().hashCode() : 0);
        result = 31 * result + (getDeviceId() != null ? getDeviceId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PreTransactionEvent{" +
                "customerId='" + customerId + '\'' +
                ", tempCustomerId='" + tempCustomerId + '\'' +
                ", paymentMethod=" + paymentMethod +
                ", paymentMethodId='" + paymentMethodId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", transaction=" + transaction +
                ", device=" + device +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}
