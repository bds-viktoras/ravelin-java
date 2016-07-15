/**
 * 
 */
package com.github.mcac0006.ravelin.base.paymentmethod;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="matthew.cachia@gmail.com">matthew.cachia</a>
 *
 */
public abstract class PaymentMethod {

    private String paymentMethodId;

    private String nickName;

    private String methodType;

    private Boolean banned;

    private Boolean active;

    private Integer registrationTime;

    private Map<String, Object> custom;


    public PaymentMethod(String paymentMethodId, String paymentMethod, String nickName, Boolean banned, Boolean active, Integer registrationTime) {
        super();
        setPaymentMethodId(paymentMethodId);
        setMethodType(paymentMethod);
        setNickName(nickName);
        setBanned(banned);
        setActive(active);
        setRegistrationTime(registrationTime);
        this.custom = new HashMap<String, Object>();
    }


    public String getPaymentMethodId() {

        return paymentMethodId;
    }


    public void setPaymentMethodId(String paymentMethodId) {

        this.paymentMethodId = paymentMethodId;
    }


    public String getNickName() {

        return nickName;
    }


    public void setNickName(String nickName) {

        this.nickName = nickName;
    }


    public Boolean getBanned() {

        return banned;
    }


    public String getMethodType() {

        return methodType;
    }

    public void setMethodType(String methodType) {

        this.methodType = methodType;
    }

    public void setBanned(Boolean banned) {

        this.banned = banned;
    }


    public Boolean getActive() {

        return active;
    }


    public void setActive(Boolean active) {

        this.active = active;
    }


    public Integer getRegistrationTime() {

        return registrationTime;
    }


    public void setRegistrationTime(Integer registrationTime) {

        this.registrationTime = registrationTime;
    }


    public Map<String, Object> getCustom() {

        return custom;
    }

    @Override public String toString() {

        return "PaymentMethod{" +
               "paymentMethodId='" + paymentMethodId + '\'' +
               ", nickName='" + nickName + '\'' +
               ", methodType='" + methodType + '\'' +
               ", banned=" + banned +
               ", active=" + active +
               ", registrationTime=" + registrationTime +
               ", custom=" + custom +
               '}';
    }

    @Override public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PaymentMethod that = (PaymentMethod) o;

        if (getPaymentMethodId() != null ? !getPaymentMethodId().equals(that.getPaymentMethodId()) : that.getPaymentMethodId() != null)
            return false;
        if (getNickName() != null ? !getNickName().equals(that.getNickName()) : that.getNickName() != null)
            return false;
        if (getMethodType() != null ? !getMethodType().equals(that.getMethodType()) : that.getMethodType() != null)
            return false;
        if (getBanned() != null ? !getBanned().equals(that.getBanned()) : that.getBanned() != null)
            return false;
        if (getActive() != null ? !getActive().equals(that.getActive()) : that.getActive() != null)
            return false;
        if (getRegistrationTime() != null ? !getRegistrationTime().equals(that.getRegistrationTime()) : that.getRegistrationTime() != null)
            return false;
        return getCustom() != null ? getCustom().equals(that.getCustom()) : that.getCustom() == null;

    }

    @Override public int hashCode() {

        int result = getPaymentMethodId() != null ? getPaymentMethodId().hashCode() : 0;
        result = 31 * result + (getNickName() != null ? getNickName().hashCode() : 0);
        result = 31 * result + (getMethodType() != null ? getMethodType().hashCode() : 0);
        result = 31 * result + (getBanned() != null ? getBanned().hashCode() : 0);
        result = 31 * result + (getActive() != null ? getActive().hashCode() : 0);
        result = 31 * result + (getRegistrationTime() != null ? getRegistrationTime().hashCode() : 0);
        result = 31 * result + (getCustom() != null ? getCustom().hashCode() : 0);
        return result;
    }
}
