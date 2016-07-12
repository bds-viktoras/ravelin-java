package com.github.mcac0006.ravelin.response;

import com.google.gson.Gson;

/**
 * Created by matthew.cachia on 11/07/2016.
 */
public class RavelinResponse {

    private Integer timestamp;

    private Integer status;

    private String message;

    private String traceId;

    private RavelinScoreResponse data;

    public RavelinResponse() {}

    public RavelinResponse(Integer timestamp, Integer status, String message, String traceId, RavelinScoreResponse data) {

        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.traceId = traceId;
        this.data = data;
    }

    public static RavelinResponse parse(String content) {

        return new Gson().fromJson(content, RavelinResponse.class);
    }

    public Integer getTimestamp() {

        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {

        this.timestamp = timestamp;
    }

    public Integer getStatus() {

        return status;
    }

    public void setStatus(Integer status) {

        this.status = status;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public String getTraceId() {

        return traceId;
    }

    public void setTraceId(String traceId) {

        this.traceId = traceId;
    }

    public RavelinScoreResponse getData() {

        return data;
    }

    public void setData(RavelinScoreResponse data) {

        this.data = data;
    }

    @Override public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        RavelinResponse that = (RavelinResponse) o;

        if (getTimestamp() != null ? !getTimestamp().equals(that.getTimestamp()) : that.getTimestamp() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(that.getStatus()) : that.getStatus() != null)
            return false;
        if (getMessage() != null ? !getMessage().equals(that.getMessage()) : that.getMessage() != null)
            return false;
        if (getTraceId() != null ? !getTraceId().equals(that.getTraceId()) : that.getTraceId() != null)
            return false;
        return getData() != null ? getData().equals(that.getData()) : that.getData() == null;

    }

    @Override public int hashCode() {

        int result = getTimestamp() != null ? getTimestamp().hashCode() : 0;
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
        result = 31 * result + (getTraceId() != null ? getTraceId().hashCode() : 0);
        result = 31 * result + (getData() != null ? getData().hashCode() : 0);
        return result;
    }

    @Override public String toString() {

        return "RavelinResponse{" +
               "timestamp=" + timestamp +
               ", status=" + status +
               ", message='" + message + '\'' +
               ", traceId='" + traceId + '\'' +
               ", data=" + data +
               '}';
    }
}
