package com.github.mcac0006.ravelin.transaction;

import com.github.mcac0006.ravelin.base.Device;
import com.github.mcac0006.ravelin.base.Event;
import com.github.mcac0006.ravelin.base.paymentmethod.PaymentMethod;


/**
 * 
 * Used once the transaction has been placed with the PSP, regardless of success or failure status.
 * 
 * If this transaction was already submitted as a preTransaction event, make sure to use the same
 * transactionId.
 * 
 * @author <a href="matthew.cachia@gmail.com">matthew.cachia</a>
 *
 */
public class TransactionEvent extends Event {

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
     * The transaction which was committed to the PSP, including the response from the PSP.
     */
    private Transaction transaction;

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

    public TransactionEvent(int timestamp,
                            String customerId,
                            String tempCustomerId,
                            PaymentMethod paymentMethod,
                            String paymentMethodId,
                            String orderId,
                            Transaction transaction,
                            Device device,
                            String deviceId) {
        super(timestamp);
        setCustomerId(customerId);
        setTempCustomerId(tempCustomerId);
        setPaymentMethod(paymentMethod);
        setPaymentMethodId(paymentMethodId);
        setOrderId(orderId);
        setTransaction(transaction);
        setDevice(device);
        setDeviceId(deviceId);
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


    public Transaction getTransaction() {

        return transaction;
    }


    public void setTransaction(Transaction transaction) {

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
}
