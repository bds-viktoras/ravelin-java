/**
 *
 */
package com.github.mcac0006.ravelin.test;

import com.github.mcac0006.ravelin.base.Customer;
import com.github.mcac0006.ravelin.base.Location;
import com.github.mcac0006.ravelin.base.paymentmethod.CreditCard;
import com.github.mcac0006.ravelin.base.paymentmethod.PaymentMethod;
import com.github.mcac0006.ravelin.customer.CustomerEvent;
import com.github.mcac0006.ravelin.paymentmethodevent.PaymentMethodEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.deploy.util.StringUtils;
import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @author <a href="matthew.cachia@gmail.com">matthew.cachia</a>
 */
public class CustomerEventTest {

    @Test public void testPaymentMethodEvent() throws Exception {

        final PaymentMethodEvent generatedEvent;
        {
            final PaymentMethod paymentMethod = new CreditCard("783917",
                                                               "MasterCard **** 4242",
                                                               false,
                                                               true,
                                                               1429029735,
                                                               "card_16nWlGHD2LFseSsHaUp9kIW2",
                                                               null,
                                                               "123456",
                                                               "4242",
                                                               "mastercard",
                                                               6,
                                                               2019,
                                                               true,
                                                               false,
                                                               null,
                                                               "GBR");

            generatedEvent = new PaymentMethodEvent(1429029735, "61283761287361", null, paymentMethod, null, null);
        }

        final PaymentMethodEvent expectedEvent;
        {
            final List list = FileUtils.readLines(new File("target/test-classes/paymentMethodEvent.json"));
            final String content = StringUtils.join(list, "");

            Gson gson = new GsonBuilder().registerTypeAdapter(PaymentMethod.class, new PaymentMethodDeserializer()).create();
            expectedEvent = gson.fromJson(content, PaymentMethodEvent.class);
        }

        Assert.assertEquals(expectedEvent, generatedEvent);
    }

    @Test public void testCustomerEvent() throws Exception {

        final CustomerEvent generatedEvent;
        {
            final Location location = new Location("James St", null, null, null, "Darwen", "Blackburn with Darwen", "GBR", null, "BB3 1AS", 53.697471d, -2.470891d, null);

            final Customer customer = new Customer("61283761287361",
                                                   1429029731,
                                                   null,
                                                   "Mark",
                                                   "Twain",
                                                   null,
                                                   null,
                                                   "marktwain@gmail.com",
                                                   null,
                                                   "mtwain",
                                                   null,
                                                   null,
                                                   null,
                                                   location,
                                                   null,
                                                   "lon");

            customer.addCustom("newsletter", false);
            customer.addCustom("invitedBy", "7198737117");

            generatedEvent = new CustomerEvent(1429029735, null, customer, null);
        }

        final List list = FileUtils.readLines(new File("target/test-classes/customerevent.json"));
        final String content = StringUtils.join(list, "");

        Gson gson = new Gson();
        final CustomerEvent expectedEvent = gson.fromJson(content, CustomerEvent.class);

        Assert.assertEquals(expectedEvent, generatedEvent);
    }
}
