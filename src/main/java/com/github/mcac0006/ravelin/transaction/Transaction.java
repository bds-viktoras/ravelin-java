package com.github.mcac0006.ravelin.transaction;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 
 * @author <a href="matthew.cachia@gmail.com">matthew.cachia</a>
 *
 */
public class Transaction {

    /**
     * A unique identifier for the transaction.
     */
    private String transactionId;

    /**
     * (required) Whether the transaction successfully completed with no error.
     */
    private Boolean success;

    /**
     * The email that the customer wants to be notified about transactions on.
     */
    private String email;

    /**
     * (required) The ISO 4217 currency code.
     */
    private String currency;

    /**
     * (required) The debit amount (money coming from the payment method, i.e. normal charge) of the
     * transaction in the lowest denomination of the currency.
     */
    private Integer debit;

    /**
     * (required) The credit amount (money going to the payment method, i.e. a refund) of the
     * transaction in the lowest denomination of the currency.
     */
    private Integer credit;

    /**
     * A code returned from the payment gateway after an attempt to charge, if applicable.
     */
    private String authCode;

    /**
     * The decline code from the payment gateway, if applicable.
     */
    private String declineCode;

    /**
     * (required) The name of the payment gateway.
     */
    private String gateway;

    /**
     * (required) Transaction Reference provided by the payment gateway.
     */
    private String gatewayReference;

    /**
     * The result code from address verification for both street and postal code verification.
     */
    private AVSResult avsResultCode;

    /**
     * The result code from a CVV verification.
     */
    private VerificationResult cvvResultCode;

    /**
     * The type of transaction.
     */
    private TransactionType type;

    /**
     * When this transaction is authed, captured, or otherwise actioned (depending on the
     * {@link #type}).
     */
    private Integer time;

    private Map<String, Object> custom;

    public Transaction(String transactionId,
                       Boolean success,
                       String email,
                       String currency,
                       Integer debit,
                       Integer credit,
                       String authCode,
                       String declineCode,
                       String gateway,
                       String gatewayReference,
                       AVSResult avsResultCode,
                       VerificationResult cvvResultCode,
                       TransactionType type,
                       Integer time) {

        this.transactionId = transactionId;
        this.success = success;
        this.email = email;
        this.currency = currency;
        this.debit = debit;
        this.credit = credit;
        this.authCode = authCode;
        this.declineCode = declineCode;
        this.gateway = gateway;
        this.gatewayReference = gatewayReference;
        this.avsResultCode = avsResultCode;
        this.cvvResultCode = cvvResultCode;
        this.type = type;
        this.time = time;
        this.custom = null;
    }

    public String getTransactionId() {

        return transactionId;
    }


    public void setTransactionId(String transactionId) {

        this.transactionId = transactionId;
    }


    public Boolean getSuccess() {

        return success;
    }


    public void setSuccess(Boolean success) {

        this.success = success;
    }


    public String getEmail() {

        return email;
    }


    public void setEmail(String email) {

        this.email = email;
    }


    public String getCurrency() {

        return currency;
    }


    public void setCurrency(String currency) {

        this.currency = currency;
    }


    public Integer getDebit() {

        return debit;
    }


    public void setDebit(Integer debit) {

        this.debit = debit;
    }


    public Integer getCredit() {

        return credit;
    }


    public void setCredit(Integer credit) {

        this.credit = credit;
    }


    public String getAuthCode() {

        return authCode;
    }


    public void setAuthCode(String authCode) {

        this.authCode = authCode;
    }


    public String getDeclineCode() {

        return declineCode;
    }


    public void setDeclineCode(String declineCode) {

        this.declineCode = declineCode;
    }


    public String getGateway() {

        return gateway;
    }


    public void setGateway(String gateway) {

        this.gateway = gateway;
    }


    public String getGatewayReference() {

        return gatewayReference;
    }


    public void setGatewayReference(String gatewayReference) {

        this.gatewayReference = gatewayReference;
    }


    public AVSResult getAvsResultCode() {

        return avsResultCode;
    }


    public void setAvsResultCode(AVSResult avsResultCode) {

        this.avsResultCode = avsResultCode;
    }


    public VerificationResult getCvvResultCode() {

        return cvvResultCode;
    }


    public void setCvvResultCode(VerificationResult cvvResultCode) {

        this.cvvResultCode = cvvResultCode;
    }


    public TransactionType getType() {

        return type;
    }


    public void setType(TransactionType type) {

        this.type = type;
    }


    public Integer getTime() {

        return time;
    }


    public void setTime(Integer time) {

        this.time = time;
    }


    public Map<String, Object> getCustom() {

        return custom;
    }


    public void addToCustom(String key, Object val) {

        if (getCustom() == null)
            this.custom = new HashMap<String, Object>();

        getCustom().put(key, val);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", success=" + success +
                ", email='" + email + '\'' +
                ", currency='" + currency + '\'' +
                ", debit=" + debit +
                ", credit=" + credit +
                ", authCode='" + authCode + '\'' +
                ", declineCode='" + declineCode + '\'' +
                ", gateway='" + gateway + '\'' +
                ", gatewayReference='" + gatewayReference + '\'' +
                ", avsResultCode=" + avsResultCode +
                ", cvvResultCode=" + cvvResultCode +
                ", type=" + type +
                ", time=" + time +
                ", custom=" + custom +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (getTransactionId() != null ? !getTransactionId().equals(that.getTransactionId()) : that.getTransactionId() != null)
            return false;
        if (getSuccess() != null ? !getSuccess().equals(that.getSuccess()) : that.getSuccess() != null) return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getCurrency() != null ? !getCurrency().equals(that.getCurrency()) : that.getCurrency() != null)
            return false;
        if (getDebit() != null ? !getDebit().equals(that.getDebit()) : that.getDebit() != null) return false;
        if (getCredit() != null ? !getCredit().equals(that.getCredit()) : that.getCredit() != null) return false;
        if (getAuthCode() != null ? !getAuthCode().equals(that.getAuthCode()) : that.getAuthCode() != null)
            return false;
        if (getDeclineCode() != null ? !getDeclineCode().equals(that.getDeclineCode()) : that.getDeclineCode() != null)
            return false;
        if (getGateway() != null ? !getGateway().equals(that.getGateway()) : that.getGateway() != null) return false;
        if (getGatewayReference() != null ? !getGatewayReference().equals(that.getGatewayReference()) : that.getGatewayReference() != null)
            return false;
        if (getAvsResultCode() != null ? !getAvsResultCode().equals(that.getAvsResultCode()) : that.getAvsResultCode() != null)
            return false;
        if (getCvvResultCode() != that.getCvvResultCode()) return false;
        if (getType() != that.getType()) return false;
        if (getTime() != null ? !getTime().equals(that.getTime()) : that.getTime() != null) return false;
        return getCustom() != null ? getCustom().equals(that.getCustom()) : that.getCustom() == null;

    }

    @Override
    public int hashCode() {
        int result = getTransactionId() != null ? getTransactionId().hashCode() : 0;
        result = 31 * result + (getSuccess() != null ? getSuccess().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getCurrency() != null ? getCurrency().hashCode() : 0);
        result = 31 * result + (getDebit() != null ? getDebit().hashCode() : 0);
        result = 31 * result + (getCredit() != null ? getCredit().hashCode() : 0);
        result = 31 * result + (getAuthCode() != null ? getAuthCode().hashCode() : 0);
        result = 31 * result + (getDeclineCode() != null ? getDeclineCode().hashCode() : 0);
        result = 31 * result + (getGateway() != null ? getGateway().hashCode() : 0);
        result = 31 * result + (getGatewayReference() != null ? getGatewayReference().hashCode() : 0);
        result = 31 * result + (getAvsResultCode() != null ? getAvsResultCode().hashCode() : 0);
        result = 31 * result + (getCvvResultCode() != null ? getCvvResultCode().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getTime() != null ? getTime().hashCode() : 0);
        result = 31 * result + (getCustom() != null ? getCustom().hashCode() : 0);
        return result;
    }
}
