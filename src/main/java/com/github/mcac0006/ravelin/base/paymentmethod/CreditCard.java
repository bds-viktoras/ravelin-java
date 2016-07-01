/**
 * 
 */
package com.github.mcac0006.ravelin.base.paymentmethod;

import static java.lang.String.format;
import java.util.regex.Pattern;

/**
 * @author <a href="matthew.cachia@gmail.com">matthew.cachia</a>
 *
 */
public class CreditCard extends PaymentMethod {

    /**
     * Used for validation purposes only.
     */
    private transient Pattern ISO_3166_PATTERN = Pattern.compile("^[A-Z]{2,3}$");

    private String instrumentId;

    private String nameOnCard;

    private String cardBin;

    private String cardLastFour;

    private String cardType;

    private Integer expiryMonth;

    private Integer expiryYear;

    private Boolean successflRegistration;

    private Boolean prepaidCard;

    private String issuer;

    private String countryIssued;

    public CreditCard(String paymentMethodId,
                      String nickName,
                      Boolean banned,
                      Boolean active,
                      Integer registrationTime,
                      String instrumentId,
                      String nameOnCard,
                      String cardBin,
                      String cardLastFour,
                      String cardType,
                      Integer expiryMonth,
                      Integer expiryYear,
                      Boolean successflRegistration,
                      Boolean prepaidCard,
                      String issuer,
                      String countryIssued) {
        super(paymentMethodId, nickName, banned, active, registrationTime);
        setInstrumentId(instrumentId);
        setNameOnCard(nameOnCard);
        setCardBin(cardBin);
        setCardLastFour(cardLastFour);
        setCardType(cardType);
        setExpiryMonth(expiryMonth);
        setExpiryYear(expiryYear);
        setSuccessflRegistration(successflRegistration);
        setPrepaidCard(prepaidCard);
        setIssuer(issuer);
        setCountryIssued(countryIssued);
    }


    public String getInstrumentId() {

        return instrumentId;
    }


    public void setInstrumentId(String instrumentId) {

        this.instrumentId = instrumentId;
    }


    public String getNameOnCard() {

        return nameOnCard;
    }


    public void setNameOnCard(String nameOnCard) {

        this.nameOnCard = nameOnCard;
    }


    public String getCardBin() {

        return cardBin;
    }


    public void setCardBin(String cardBin) {

        this.cardBin = cardBin;
    }


    public String getCardLastFour() {

        return cardLastFour;
    }


    public void setCardLastFour(String cardLastFour) {

        this.cardLastFour = cardLastFour;
    }


    public String getCardType() {

        return cardType;
    }


    public void setCardType(String cardType) {

        this.cardType = cardType;
    }


    public Integer getExpiryMonth() {

        return expiryMonth;
    }


    public void setExpiryMonth(Integer expiryMonth) {

        this.expiryMonth = expiryMonth;
    }


    public Integer getExpiryYear() {

        return expiryYear;
    }


    public void setExpiryYear(Integer expiryYear) {

        this.expiryYear = expiryYear;
    }


    public Boolean getSuccessflRegistration() {

        return successflRegistration;
    }


    public void setSuccessflRegistration(Boolean successflRegistration) {

        this.successflRegistration = successflRegistration;
    }


    public Boolean getPrepaidCard() {

        return prepaidCard;
    }


    public void setPrepaidCard(Boolean prepaidCard) {

        this.prepaidCard = prepaidCard;
    }


    public String getIssuer() {

        return issuer;
    }


    public void setIssuer(String issuer) {

        this.issuer = issuer;
    }


    public String getCountryIssued() {

        return countryIssued;
    }


    public void setCountryIssued(String countryIssued) {

        if (!ISO_3166_PATTERN.matcher(countryIssued).matches())
            throw new IllegalArgumentException(format("Country [%s] is not in the expected ISO-3166 format.", countryIssued));

        this.countryIssued = countryIssued;
    }

    @Override
    String getMethodType() {
        return "card";
    }

}
