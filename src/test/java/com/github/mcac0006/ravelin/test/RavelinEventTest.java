/**
 *
 */
package com.github.mcac0006.ravelin.test;

import com.github.mcac0006.ravelin.base.Customer;
import com.github.mcac0006.ravelin.base.Device;
import com.github.mcac0006.ravelin.base.Location;
import com.github.mcac0006.ravelin.base.paymentmethod.CreditCard;
import com.github.mcac0006.ravelin.base.paymentmethod.PaymentMethod;
import com.github.mcac0006.ravelin.customer.CustomerEvent;
import com.github.mcac0006.ravelin.label.Label;
import com.github.mcac0006.ravelin.label.LabelCustomerEvent;
import com.github.mcac0006.ravelin.label.Reviewer;
import com.github.mcac0006.ravelin.login.LoginEvent;
import com.github.mcac0006.ravelin.order.*;
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
public class RavelinEventTest {

    @Test
    public void labelCustomerEventTest() throws Exception {

        final LabelCustomerEvent generatedEvent;
        {
            Reviewer reviewer = new Reviewer("Bilbo Baggins", "bilbo.b@shiremail.com");
            generatedEvent = new LabelCustomerEvent("customer1", Label.GENUINE, "This customer called up and we have determined he is not a fraudster", reviewer);
        }

        final LabelCustomerEvent expectedEvent;
        {
            final List list = FileUtils.readLines(new File("target/test-classes/labelCustomerEvent.json"));
            final String content = StringUtils.join(list, "");

            Gson gson = new Gson();
            expectedEvent = gson.fromJson(content, LabelCustomerEvent.class);
        }

        Assert.assertEquals(expectedEvent, generatedEvent);
    }

    @Test public void loginEventTest() throws Exception {

        final LoginEvent generatedEvent;
        {
            Device device = new Device("2b6f0cc904d137be2e1730235f5664094b831186", "phone", "apple", "iPhone8,1", "iOS 8", "22.231.113.64", null, null, null, null, null);
            generatedEvent = new LoginEvent(1429029750, "61283761287361", null, device, null);
        }

        final LoginEvent expectedEvent;
        {
            final List list = FileUtils.readLines(new File("target/test-classes/loginEvent.json"));
            final String content = StringUtils.join(list, "");

            Gson gson = new Gson();
            expectedEvent = gson.fromJson(content, LoginEvent.class);
        }

        Assert.assertEquals(expectedEvent, generatedEvent);
    }

    @Test public void testOrderEventTest() throws Exception {

        final OrderEvent generatedEvent;
        {
            final Item item1 = new Item("3726-8", "Women's Arch Sweater M 55", 1990, "GBP", null, null, null, 2);
            final Item item2 = new Item("3731-4", "Women's Yellow Tee M 54", 695, "GBP", null, null, null, 1);

            Location from = new Location("19 Gosport Walk", null, null, null, null, "London", "GBR", null, "N17 9QD", null, null, null);
            Location to = new Location("73 Braganza St", null, null, null, null, "London", "GBR", null, "SE17 3RD", null, null, null);

            Status status = new Status(Stage.pending, null, "buyer");

            final Order order = new Order("hXyUc5ef2zhOrdqmRiC", null, 4675, "GBP", null, from, to, null, "lon", 1429029730, 1429029732, new Item[] {item1, item2}, status);

            generatedEvent = new OrderEvent(1429029735, "61283761287361", null, order, null, null);
        }

        final OrderEvent expectedEvent;
        {
            final List list = FileUtils.readLines(new File("target/test-classes/orderEvent.json"));
            final String content = StringUtils.join(list, "");

            Gson gson = new GsonBuilder().registerTypeAdapter(PaymentMethod.class, new PaymentMethodDeserializer()).create();
            expectedEvent = gson.fromJson(content, OrderEvent.class);
        }

        Assert.assertEquals(expectedEvent, generatedEvent);
    }

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
