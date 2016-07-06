package com.github.mcac0006.ravelin.order;

import java.util.HashMap;
import java.util.Map;

/**
 * Items describe the elements that make up an order, like the different items in a shopping basket, or a single taxi ride. An item is always unique across orders, even if it represents the same underlying thing you can buy.
 *
 * This means two orders can have an item with the same SKU, but different prices or names, without any problems.
 *
 * Item arrays are atomic blocks: to update one item in the basket, the entire basket must be resubmitted.
 *
 * Created by matthew.cachia on 05/07/2016.
 */
public class Item {

    /**
     * A merchant specific identifier for an item or a service.
     */
    private String sku;

    /**
     * The name of the product that is being purchased.
     */
    private String name;

    /**
     * The price of the single item, if many bought, in the lowest denomination of the currency: e.g. cents for US dollars, pence for GB pound.
     */
    private Integer price;

    /**
     * The ISO 4217 currency code.
     */
    private String currency;

    /**
     * The name of the brand that the item is from
     */
    private String brand;

    /**
     * The name of the Universal Item Code.
     */
    private String upc;

    /**
     * The highest level category that this item is sold in.
     */
    private String category;

    /**
     * The number of times this item is represented in the basket. 0 to remove.
     */
    private Integer quantity;

    private Map<String, Object> custom;

    public Item(String sku, String name, Integer price, String currency, String brand, String upc, String category, Integer quantity) {

        this.sku = sku;
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.brand = brand;
        this.upc = upc;
        this.category = category;
        this.quantity = quantity;
        this.custom = null;
    }

    public String getSku() {

        return sku;
    }

    public void setSku(String sku) {

        this.sku = sku;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
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

    public String getBrand() {

        return brand;
    }

    public void setBrand(String brand) {

        this.brand = brand;
    }

    public String getUpc() {

        return upc;
    }

    public void setUpc(String upc) {

        this.upc = upc;
    }

    public String getCategory() {

        return category;
    }

    public void setCategory(String category) {

        this.category = category;
    }

    public Integer getQuantity() {

        return quantity;
    }

    public void setQuantity(Integer quantity) {

        this.quantity = quantity;
    }

    public Map<String, Object> getCustom() {

        return custom;
    }

    public void addToCustom(String key, Object value) {

        if (getCustom() == null)
            this.custom = new HashMap<String, Object>();

        getCustom().put(key, value);
    }

    @Override public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Item item = (Item) o;

        if (getSku() != null ? !getSku().equals(item.getSku()) : item.getSku() != null)
            return false;
        if (getName() != null ? !getName().equals(item.getName()) : item.getName() != null)
            return false;
        if (getPrice() != null ? !getPrice().equals(item.getPrice()) : item.getPrice() != null)
            return false;
        if (getCurrency() != null ? !getCurrency().equals(item.getCurrency()) : item.getCurrency() != null)
            return false;
        if (getBrand() != null ? !getBrand().equals(item.getBrand()) : item.getBrand() != null)
            return false;
        if (getUpc() != null ? !getUpc().equals(item.getUpc()) : item.getUpc() != null)
            return false;
        if (getCategory() != null ? !getCategory().equals(item.getCategory()) : item.getCategory() != null)
            return false;
        if (getQuantity() != null ? !getQuantity().equals(item.getQuantity()) : item.getQuantity() != null)
            return false;
        return getCustom() != null ? getCustom().equals(item.getCustom()) : item.getCustom() == null;

    }

    @Override public int hashCode() {

        int result = getSku() != null ? getSku().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getCurrency() != null ? getCurrency().hashCode() : 0);
        result = 31 * result + (getBrand() != null ? getBrand().hashCode() : 0);
        result = 31 * result + (getUpc() != null ? getUpc().hashCode() : 0);
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        result = 31 * result + (getQuantity() != null ? getQuantity().hashCode() : 0);
        result = 31 * result + (getCustom() != null ? getCustom().hashCode() : 0);
        return result;
    }

    @Override public String toString() {

        return "Item{" +
               "sku='" + sku + '\'' +
               ", name='" + name + '\'' +
               ", price=" + price +
               ", currency='" + currency + '\'' +
               ", brand='" + brand + '\'' +
               ", upc='" + upc + '\'' +
               ", category='" + category + '\'' +
               ", quantity=" + quantity +
               ", custom=" + custom +
               '}';
    }
}
