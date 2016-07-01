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

    abstract String getMethodType();

    private Boolean banned;

    private Boolean active;

    private Integer registrationTime;

    private Map<String, Object> custom;


    public PaymentMethod(String paymentMethodId, String nickName, Boolean banned, Boolean active, Integer registrationTime) {
        super();
        setPaymentMethodId(paymentMethodId);
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
}
