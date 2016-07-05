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
public class PayPal extends PaymentMethod {

    private String email;

    public PayPal(String paymentMethodId, String nickName, Boolean banned, Boolean active, Integer registrationTime, Pattern eMAIL_PATTERN, String email) {
        super(paymentMethodId, nickName, banned, active, registrationTime);
        setEmail(email);
    }


    public String getEmail() {

        return email;
    }


    public void setEmail(String email) {

        this.email = email;
    }

    @Override
    String getMethodType() {

        return "paypal";
    }

    @Override public String toString() {

        return "PayPal{" +
               "email='" + email + '\'' +
               '}';
    }

    @Override public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PayPal payPal = (PayPal) o;

        return getEmail() != null ? getEmail().equals(payPal.getEmail()) : payPal.getEmail() == null;

    }

    @Override public int hashCode() {

        return getEmail() != null ? getEmail().hashCode() : 0;
    }
}
