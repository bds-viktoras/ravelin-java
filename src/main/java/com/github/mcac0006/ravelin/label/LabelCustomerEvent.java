/**
 * 
 */
package com.github.mcac0006.ravelin.label;

import com.github.mcac0006.ravelin.base.Event;


/**
 * Used to change the status of a customer (be it Genuine or Fraudster).
 * 
 * @author <a href="matthew.cachia@gmail.com">matthew.cachia</a>
 *
 */
public class LabelCustomerEvent {

    /**
     * The unique identifier of this customer in your system.
     */
    private String customerId;

    /**
     * The label for this customer.
     */
    private Label label;

    /**
     * The reason for this label.
     */
    private String comment;

    /**
     * The individual creating this label.
     */
    private Reviewer reviewer;

    public LabelCustomerEvent(String customerId, Label label, String comment, Reviewer reviewer) {
        this.customerId = customerId;
        this.label = label;
        this.comment = comment;
        this.reviewer = reviewer;
    }


    public String getCustomerId() {

        return customerId;
    }


    public void setCustomerId(String customerId) {

        this.customerId = customerId;
    }


    public Label getLabel() {

        return label;
    }


    public void setLabel(Label label) {

        this.label = label;
    }


    public String getComment() {

        return comment;
    }


    public void setComment(String comment) {

        this.comment = comment;
    }


    public Reviewer getReviewer() {

        return reviewer;
    }


    public void setReviewer(Reviewer reviewer) {

        this.reviewer = reviewer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LabelCustomerEvent that = (LabelCustomerEvent) o;

        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (label != that.label) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        return reviewer != null ? reviewer.equals(that.reviewer) : that.reviewer == null;

    }

    @Override
    public int hashCode() {
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (reviewer != null ? reviewer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LabelCustomerEvent{" +
                "customerId='" + customerId + '\'' +
                ", label=" + label +
                ", comment='" + comment + '\'' +
                ", reviewer=" + reviewer +
                '}';
    }
}
