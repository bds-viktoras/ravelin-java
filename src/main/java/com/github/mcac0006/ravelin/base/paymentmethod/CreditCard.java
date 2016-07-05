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

    private Boolean successfulRegistration;

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
                      Boolean successfulRegistration,
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
        setSuccessfulRegistration(successfulRegistration);
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


    public Boolean getSuccessfulRegistration() {

        return successfulRegistration;
    }


    public void setSuccessfulRegistration(Boolean successfulRegistration) {

        this.successfulRegistration = successfulRegistration;
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

    @Override public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        CreditCard that = (CreditCard) o;

        if (getInstrumentId() != null ? !getInstrumentId().equals(that.getInstrumentId()) : that.getInstrumentId() != null)
            return false;
        if (getNameOnCard() != null ? !getNameOnCard().equals(that.getNameOnCard()) : that.getNameOnCard() != null)
            return false;
        if (getCardBin() != null ? !getCardBin().equals(that.getCardBin()) : that.getCardBin() != null)
            return false;
        if (getCardLastFour() != null ? !getCardLastFour().equals(that.getCardLastFour()) : that.getCardLastFour() != null)
            return false;
        if (getCardType() != null ? !getCardType().equals(that.getCardType()) : that.getCardType() != null)
            return false;
        if (getExpiryMonth() != null ? !getExpiryMonth().equals(that.getExpiryMonth()) : that.getExpiryMonth() != null)
            return false;
        if (getExpiryYear() != null ? !getExpiryYear().equals(that.getExpiryYear()) : that.getExpiryYear() != null)
            return false;
        if (getSuccessfulRegistration() != null ? !getSuccessfulRegistration().equals(that.getSuccessfulRegistration()) : that.getSuccessfulRegistration() != null)
            return false;
        if (getPrepaidCard() != null ? !getPrepaidCard().equals(that.getPrepaidCard()) : that.getPrepaidCard() != null)
            return false;
        if (getIssuer() != null ? !getIssuer().equals(that.getIssuer()) : that.getIssuer() != null)
            return false;
        return getCountryIssued() != null ? getCountryIssued().equals(that.getCountryIssued()) : that.getCountryIssued() == null;

    }

    @Override public int hashCode() {

        int result = getInstrumentId() != null ? getInstrumentId().hashCode() : 0;
        result = 31 * result + (getNameOnCard() != null ? getNameOnCard().hashCode() : 0);
        result = 31 * result + (getCardBin() != null ? getCardBin().hashCode() : 0);
        result = 31 * result + (getCardLastFour() != null ? getCardLastFour().hashCode() : 0);
        result = 31 * result + (getCardType() != null ? getCardType().hashCode() : 0);
        result = 31 * result + (getExpiryMonth() != null ? getExpiryMonth().hashCode() : 0);
        result = 31 * result + (getExpiryYear() != null ? getExpiryYear().hashCode() : 0);
        result = 31 * result + (getSuccessfulRegistration() != null ? getSuccessfulRegistration().hashCode() : 0);
        result = 31 * result + (getPrepaidCard() != null ? getPrepaidCard().hashCode() : 0);
        result = 31 * result + (getIssuer() != null ? getIssuer().hashCode() : 0);
        result = 31 * result + (getCountryIssued() != null ? getCountryIssued().hashCode() : 0);
        return result;
    }

    @Override public String toString() {

        return "CreditCard{" +
               "instrumentId='" + instrumentId + '\'' +
               ", nameOnCard='" + nameOnCard + '\'' +
               ", cardBin='" + cardBin + '\'' +
               ", cardLastFour='" + cardLastFour + '\'' +
               ", cardType='" + cardType + '\'' +
               ", expiryMonth=" + expiryMonth +
               ", expiryYear=" + expiryYear +
               ", successfulRegistration=" + successfulRegistration +
               ", prepaidCard=" + prepaidCard +
               ", issuer='" + issuer + '\'' +
               ", countryIssued='" + countryIssued + '\'' +
               '}';
    }
}
