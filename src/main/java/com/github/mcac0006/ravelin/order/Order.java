package com.github.mcac0006.ravelin.order;

import com.github.mcac0006.ravelin.base.Location;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by matthew.cachia on 05/07/2016.
 */
public class Order {

    /**
     * 	A unique identifier for the order.
     */
    private String orderId;

    /**
     * A contact email for this order.
     */
    private String email;

    /**
     * The price of the purchase in the lowest denomination of the currency.
     */
    private Integer price;

    /**
     * The ISO 4217 currency code.
     */
    private String currency;

    /**
     * The unique identifier of the seller/counterparty in the transaction, if not your business. E.g. an ID of a driver when a customer is ordering a car, or the ID of a restaurant when a customer is ordering food.
     */
    private String sellerId;

    /**
     * The “start” location of the order.
     */
    private Location from;

    /**
     * The “end” location of the order.
     */
    private Location to;

    /**
     * The ‘country’ of the order; ISO 3166 (2- or 3-letter).
     */
    private String country;

    /**
     * The logical place in which this order occured.
     */
    private String market;

    /**
     * The unix timestamp, in seconds, of when the order was created.
     */
    private Integer creationTime;

    /**
     * The unix timestamp, in seconds, of when the order was executed. Specifically; when this order was to be used or obtained by the customer. For example; with taxis, you may prebook - this is the time the prebook is for. With tickets, this may be the time of the event.
     */
    private Integer executionTime;

    /**
     * Items registered with this order. Set to the empty array to empty the cart, do not specify at all if no information is available.
     */
    private Item[] items;

    /**
     * The most recent status of the order.
     */
    private Status status;

    private Map<String, Object> custom;

    public Order(String orderId,
                 String email,
                 Integer price,
                 String currency,
                 String sellerId,
                 Location from,
                 Location to,
                 String country,
                 String market,
                 Integer creationTime,
                 Integer executionTime,
                 Item[] items,
                 Status status) {

        this.orderId = orderId;
        this.email = email;
        this.price = price;
        this.currency = currency;
        this.sellerId = sellerId;
        this.from = from;
        this.to = to;
        this.country = country;
        this.market = market;
        this.creationTime = creationTime;
        this.executionTime = executionTime;
        this.items = items;
        this.status = status;
        this.custom = null;
    }

    public String getOrderId() {

        return orderId;
    }

    public void setOrderId(String orderId) {

        this.orderId = orderId;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public Integer getPrice() {

        return price;
    }

    public void setPrice(Integer price) {

        this.price = price;
    }

    public String getCurrency() {

        return currency;
    }

    public void setCurrency(String currency) {

        this.currency = currency;
    }

    public String getSellerId() {

        return sellerId;
    }

    public void setSellerId(String sellerId) {

        this.sellerId = sellerId;
    }

    public Location getFrom() {

        return from;
    }

    public void setFrom(Location from) {

        this.from = from;
    }

    public Location getTo() {

        return to;
    }

    public void setTo(Location to) {

        this.to = to;
    }

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {

        this.country = country;
    }

    public String getMarket() {

        return market;
    }

    public void setMarket(String market) {

        this.market = market;
    }

    public Integer getCreationTime() {

        return creationTime;
    }

    public void setCreationTime(Integer creationTime) {

        this.creationTime = creationTime;
    }

    public Integer getExecutionTime() {

        return executionTime;
    }

    public void setExecutionTime(Integer executionTime) {

        this.executionTime = executionTime;
    }

    public Item[] getItems() {

        return items;
    }

    public void setItems(Item[] items) {

        this.items = items;
    }

    public Status getStatus() {

        return status;
    }

    public void setStatus(Status status) {

        this.status = status;
    }

    public Map<String, Object> getCustom() {

        return custom;
    }

    public void setCustom(Map<String, Object> custom) {

        this.custom = custom;
    }

    public void addToCustom(String key, Object value) {

        if (getCustom() == null)
            setCustom(new HashMap<String, Object>());

        getCustom().put(key, value);
    }

    @Override public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Order order = (Order) o;

        if (getOrderId() != null ? !getOrderId().equals(order.getOrderId()) : order.getOrderId() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(order.getEmail()) : order.getEmail() != null)
            return false;
        if (getPrice() != null ? !getPrice().equals(order.getPrice()) : order.getPrice() != null)
            return false;
        if (getCurrency() != null ? !getCurrency().equals(order.getCurrency()) : order.getCurrency() != null)
            return false;
        if (getSellerId() != null ? !getSellerId().equals(order.getSellerId()) : order.getSellerId() != null)
            return false;
        if (getFrom() != null ? !getFrom().equals(order.getFrom()) : order.getFrom() != null)
            return false;
        if (getTo() != null ? !getTo().equals(order.getTo()) : order.getTo() != null)
            return false;
        if (getCountry() != null ? !getCountry().equals(order.getCountry()) : order.getCountry() != null)
            return false;
        if (getMarket() != null ? !getMarket().equals(order.getMarket()) : order.getMarket() != null)
            return false;
        if (getCreationTime() != null ? !getCreationTime().equals(order.getCreationTime()) : order.getCreationTime() != null)
            return false;
        if (getExecutionTime() != null ? !getExecutionTime().equals(order.getExecutionTime()) : order.getExecutionTime() != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getItems(), order.getItems()))
            return false;
        if (getStatus() != null ? !getStatus().equals(order.getStatus()) : order.getStatus() != null)
            return false;
        return getCustom() != null ? getCustom().equals(order.getCustom()) : order.getCustom() == null;

    }

    @Override public int hashCode() {

        int result = getOrderId() != null ? getOrderId().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getCurrency() != null ? getCurrency().hashCode() : 0);
        result = 31 * result + (getSellerId() != null ? getSellerId().hashCode() : 0);
        result = 31 * result + (getFrom() != null ? getFrom().hashCode() : 0);
        result = 31 * result + (getTo() != null ? getTo().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getMarket() != null ? getMarket().hashCode() : 0);
        result = 31 * result + (getCreationTime() != null ? getCreationTime().hashCode() : 0);
        result = 31 * result + (getExecutionTime() != null ? getExecutionTime().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getItems());
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getCustom() != null ? getCustom().hashCode() : 0);
        return result;
    }

    @Override public String toString() {

        return "Order{" +
               "orderId='" + orderId + '\'' +
               ", email='" + email + '\'' +
               ", price=" + price +
               ", currency='" + currency + '\'' +
               ", sellerId='" + sellerId + '\'' +
               ", from=" + from +
               ", to=" + to +
               ", country='" + country + '\'' +
               ", market='" + market + '\'' +
               ", creationTime=" + creationTime +
               ", executionTime=" + executionTime +
               ", items=" + Arrays.toString(items) +
               ", status=" + status +
               ", custom=" + custom +
               '}';
    }
}
