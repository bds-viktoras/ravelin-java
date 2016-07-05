package com.github.mcac0006.ravelin.order;

/**
 * Status reason provides context to the order status. Valid values depend on the stage.
 *
 * Created by matthew.cachia on 05/07/2016.
 */
public enum Reason {

    payment_declined,
    seller_rejected,
    system_error,
    buyer,
    seller,
    merchant,
    ravelin,
    returned,
    complaint
    ;
}
