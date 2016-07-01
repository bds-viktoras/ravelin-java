/**
 * 
 */
package com.github.mcac0006.ravelin.label;

import static java.lang.String.format;
import java.util.regex.Pattern;

/**
 * The reviewer is the person who is doing the review. Their details will appear in the audit log on
 * the dashboard so you are able to see who did this review and why.
 * 
 * @author <a href="matthew.cachia@gmail.com">matthew.cachia</a>
 *
 */
public class Reviewer {

    /**
     * Used for validation purposes only.
     */
    private transient Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private String name;

    private String email;

    public Reviewer(String name, String email) {
        super();
        setName(name);
        setEmail(email);
    }


    public String getName() {

        return name;
    }


    public void setName(String name) {

        this.name = name;
    }


    public String getEmail() {

        return email;
    }


    public void setEmail(String email) {

        if (!EMAIL_PATTERN.matcher(email).matches())
            throw new IllegalArgumentException(format("Email [%s] is not a valid email.", email));

        this.email = email;
    }
}
