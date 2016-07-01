/**
 * 
 */
package com.github.mcac0006.ravelin.response;


/**
 * @author <a href="matthew.cachia@gmail.com">matthew.cachia</a>
 *
 */
public class RavelinResponse {

    /**
     * Identifier for this customer, as supplied by the client.
     */
    private String customerId;

    /**
     * Action to take for this customer, according to Ravelin.
     */
    private Action action;

    /**
     * Ravelin score for this customer as an integer. Debugging purposes only.
     */
    private Integer score;

    /**
     * Source of the score, e.g. RAVELIN or MANUAL_REVIEW.
     */
    private String source;

    /**
     * Unique identifier for this score or callback.
     */
    private String scoreId;

    /**
     * In the case of manual review, this is the comment left by the reviewer on this particular
     * review action.
     */
    private String comment;

    public RavelinResponse(String customerId, Action action, Integer score, String source, String scoreId, String comment) {
        super();
        this.customerId = customerId;
        this.action = action;
        this.score = score;
        this.source = source;
        this.scoreId = scoreId;
        this.comment = comment;
    }


    public String getCustomerId() {

        return customerId;
    }


    public void setCustomerId(String customerId) {

        this.customerId = customerId;
    }


    public Action getAction() {

        return action;
    }


    public void setAction(Action action) {

        this.action = action;
    }


    public Integer getScore() {

        return score;
    }


    public void setScore(Integer score) {

        this.score = score;
    }


    public String getSource() {

        return source;
    }


    public void setSource(String source) {

        this.source = source;
    }


    public String getScoreId() {

        return scoreId;
    }


    public void setScoreId(String scoreId) {

        this.scoreId = scoreId;
    }


    public String getComment() {

        return comment;
    }


    public void setComment(String comment) {

        this.comment = comment;
    }


}
