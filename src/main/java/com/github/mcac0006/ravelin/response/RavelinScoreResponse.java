/**
 * 
 */
package com.github.mcac0006.ravelin.response;


import com.google.gson.Gson;

/**
 * @author <a href="matthew.cachia@gmail.com">matthew.cachia</a>
 *
 */
public class RavelinScoreResponse {

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

    public RavelinScoreResponse(String customerId, Action action, Integer score, String source, String scoreId, String comment) {
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

    public static RavelinScoreResponse parse(String content) {

        Gson gson = new Gson();
        return gson.fromJson(content, RavelinScoreResponse.class);
    }

    @Override public String toString() {

        return "RavelinScoreResponse{" +
               "customerId='" + customerId + '\'' +
               ", action=" + action +
               ", score=" + score +
               ", source='" + source + '\'' +
               ", scoreId='" + scoreId + '\'' +
               ", comment='" + comment + '\'' +
               '}';
    }

    @Override public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        RavelinScoreResponse that = (RavelinScoreResponse) o;

        if (getCustomerId() != null ? !getCustomerId().equals(that.getCustomerId()) : that.getCustomerId() != null)
            return false;
        if (getAction() != that.getAction())
            return false;
        if (getScore() != null ? !getScore().equals(that.getScore()) : that.getScore() != null)
            return false;
        if (getSource() != null ? !getSource().equals(that.getSource()) : that.getSource() != null)
            return false;
        if (getScoreId() != null ? !getScoreId().equals(that.getScoreId()) : that.getScoreId() != null)
            return false;
        return getComment() != null ? getComment().equals(that.getComment()) : that.getComment() == null;

    }

    @Override public int hashCode() {

        int result = getCustomerId() != null ? getCustomerId().hashCode() : 0;
        result = 31 * result + (getAction() != null ? getAction().hashCode() : 0);
        result = 31 * result + (getScore() != null ? getScore().hashCode() : 0);
        result = 31 * result + (getSource() != null ? getSource().hashCode() : 0);
        result = 31 * result + (getScoreId() != null ? getScoreId().hashCode() : 0);
        result = 31 * result + (getComment() != null ? getComment().hashCode() : 0);
        return result;
    }
}
