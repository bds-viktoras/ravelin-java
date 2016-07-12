package com.github.mcac0006.ravelin.base;

/**
 * The abstraction of all Ravelin events, all of which contain a common set of attributes (as
 * defined below).
 * 
 * @author <a href="matthew.cachia@gmail.com">matthew.cachia</a>
 *
 */
public abstract class Event extends RavelinRequest {

    /**
     * The unix timestamp, in seconds, of when the event occured.
     */
    private int timestamp;

    public Event(int timestamp) {
        super();
        this.timestamp = timestamp;
    }


    public int getTimestamp() {

        return timestamp;
    }


    public void setTimestamp(int timestamp) {

        this.timestamp = timestamp;
    }


    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + timestamp;
        return result;
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Event other = (Event) obj;
        if (timestamp != other.timestamp)
            return false;
        return true;
    }
}
