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

    /**
     * Used for validation purposes only.
     */
    private transient Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private String email;

    public PayPal(String paymentMethodId, String nickName, Boolean banned, Boolean active, Integer registrationTime, Pattern eMAIL_PATTERN, String email) {
        super(paymentMethodId, nickName, banned, active, registrationTime);
        setEmail(email);
    }


    public String getEmail() {

        return email;
    }


    public void setEmail(String email) {

        if (!EMAIL_PATTERN.matcher(email).matches())
            throw new IllegalArgumentException(format("Email [%s] is not a valid email.", email));

        this.email = email;
    }

    @Override
    String getMethodType() {

        return "paypal";
    }

}
