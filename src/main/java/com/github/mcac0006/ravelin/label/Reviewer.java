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
     * The name of the person doing the review.
     */
    private String name;

    /**
     * The email of the person doing the review.
     */
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

        this.email = email;
    }

    @Override public String toString() {

        return "Reviewer{" +
               "name='" + name + '\'' +
               ", email='" + email + '\'' +
               '}';
    }

    @Override public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Reviewer reviewer = (Reviewer) o;

        if (getName() != null ? !getName().equals(reviewer.getName()) : reviewer.getName() != null)
            return false;
        return getEmail() != null ? getEmail().equals(reviewer.getEmail()) : reviewer.getEmail() == null;

    }

    @Override public int hashCode() {

        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }
}
