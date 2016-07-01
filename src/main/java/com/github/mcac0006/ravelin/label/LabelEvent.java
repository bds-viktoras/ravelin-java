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
public class LabelEvent extends Event {

    private String customerId;

    private Label label;

    private String comment;

    private Reviewer reviewer;

    public LabelEvent(int timestamp, String customerId, Label label, String comment, Reviewer reviewer) {
        super(timestamp);
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
}
