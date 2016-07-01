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
     * Used for validation purposes only.
     */
    private transient Pattern ISO_4217_PATTERN = Pattern.compile("^[A-Z]{3}$");

    /**
     * Used for validation purposes only.
     */
    private transient Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

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

        if (!EMAIL_PATTERN.matcher(email).matches())
            throw new IllegalArgumentException(format("Email [%s] is not a valid email.", email));

        this.email = email;
    }


    public String getCurrency() {

        return currency;
    }


    public void setCurrency(String currency) {

        if (!ISO_4217_PATTERN.matcher(currency).matches())
            throw new IllegalArgumentException(format("Currency [%s] is not a valid ISO-4217 currency.", currency));

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


    public void setCustom(Map<String, Object> custom) {

        this.custom = custom;
    }
}
