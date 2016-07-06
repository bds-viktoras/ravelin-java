/**
 * 
 */
package com.github.mcac0006.ravelin.transaction;

import static java.lang.String.format;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author <a href="matthew.cachia@gmail.com">matthew.cachia</a>
 *
 */
public class PreTransaction {

    /**
     * A unique identifier for the transaction.
     */
    private String transactionId;

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
     * (required) The name of the payment gateway.
     */
    private String gateway;

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

    public PreTransaction(String transactionId,
                          String email,
                          String currency,
                          Integer debit,
                          Integer credit,
                          String gateway,
                          TransactionType type,
                          Integer time,
                          Map<String, Object> custom) {
        super();
        setTransactionId(transactionId);
        setEmail(email);
        setCurrency(currency);
        setDebit(debit);
        setCredit(credit);
        setGateway(gateway);
        setType(type);
        setTime(time);
        this.custom = new HashMap<String, Object>();
    }


    public String getTransactionId() {

        return transactionId;
    }


    public void setTransactionId(String transactionId) {

        this.transactionId = transactionId;
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


    public String getGateway() {

        return gateway;
    }


    public void setGateway(String gateway) {

        this.gateway = gateway;
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

    public void addToCustom(String key, Object value) {

        if (getCustom() == null)
            this.custom = new HashMap<String, Object>();

        getCustom().put(key, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreTransaction that = (PreTransaction) o;

        if (getTransactionId() != null ? !getTransactionId().equals(that.getTransactionId()) : that.getTransactionId() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getCurrency() != null ? !getCurrency().equals(that.getCurrency()) : that.getCurrency() != null)
            return false;
        if (getDebit() != null ? !getDebit().equals(that.getDebit()) : that.getDebit() != null) return false;
        if (getCredit() != null ? !getCredit().equals(that.getCredit()) : that.getCredit() != null) return false;
        if (getGateway() != null ? !getGateway().equals(that.getGateway()) : that.getGateway() != null) return false;
        if (getType() != that.getType()) return false;
        if (getTime() != null ? !getTime().equals(that.getTime()) : that.getTime() != null) return false;
        return getCustom() != null ? getCustom().equals(that.getCustom()) : that.getCustom() == null;

    }

    @Override
    public int hashCode() {
        int result = getTransactionId() != null ? getTransactionId().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getCurrency() != null ? getCurrency().hashCode() : 0);
        result = 31 * result + (getDebit() != null ? getDebit().hashCode() : 0);
        result = 31 * result + (getCredit() != null ? getCredit().hashCode() : 0);
        result = 31 * result + (getGateway() != null ? getGateway().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getTime() != null ? getTime().hashCode() : 0);
        result = 31 * result + (getCustom() != null ? getCustom().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PreTransaction{" +
                "transactionId='" + transactionId + '\'' +
                ", email='" + email + '\'' +
                ", currency='" + currency + '\'' +
                ", debit=" + debit +
                ", credit=" + credit +
                ", gateway='" + gateway + '\'' +
                ", type=" + type +
                ", time=" + time +
                ", custom=" + custom +
                '}';
    }
}
