package com.github.mcac0006.ravelin.order;

/**
 * Order statuses specify the current status of the order
 * <p>
 * Created by matthew.cachia on 05/07/2016.
 */
public class Status {

    /**
     * The most recent status of the order.
     */
    private Stage stage;

    /**
     * Status reason provides context to the order status. Valid values depend on the stage.
     */
    private Reason reason;

    /**
     * Status actor is the entity that caused the latest order status. You can use this string to provide additional information to your Ravelin dashboard users e.g. customerId123, order-cancelling-service, customerservice@company.com.
     */
    private String actor;

    public Status(Stage stage, Reason reason, String actor) {

        this.stage = stage;
        this.reason = reason;
        this.actor = actor;
    }

    public Stage getStage() {

        return stage;
    }

    public void setStage(Stage stage) {

        this.stage = stage;
    }

    public Reason getReason() {

        return reason;
    }

    public void setReason(Reason reason) {

        this.reason = reason;
    }

    public String getActor() {

        return actor;
    }

    public void setActor(String actor) {

        this.actor = actor;
    }

    @Override public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Status status = (Status) o;

        if (getStage() != status.getStage())
            return false;
        if (getReason() != status.getReason())
            return false;
        return getActor() != null ? getActor().equals(status.getActor()) : status.getActor() == null;

    }

    @Override public int hashCode() {

        int result = getStage() != null ? getStage().hashCode() : 0;
        result = 31 * result + (getReason() != null ? getReason().hashCode() : 0);
        result = 31 * result + (getActor() != null ? getActor().hashCode() : 0);
        return result;
    }

    @Override public String toString() {

        return "Status{" +
               "stage=" + stage +
               ", reason=" + reason +
               ", actor='" + actor + '\'' +
               '}';
    }
}
