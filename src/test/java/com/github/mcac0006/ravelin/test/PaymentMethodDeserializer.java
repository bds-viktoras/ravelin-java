package com.github.mcac0006.ravelin.test;

import com.github.mcac0006.ravelin.base.paymentmethod.CreditCard;
import com.github.mcac0006.ravelin.base.paymentmethod.PayPal;
import com.github.mcac0006.ravelin.base.paymentmethod.PaymentMethod;
import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by matthew.cachia on 05/07/2016.
 */
public class PaymentMethodDeserializer implements JsonDeserializer<PaymentMethod> {

    @Override public PaymentMethod deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        final Gson gson = new Gson();
        final Class<? extends PaymentMethod> classOfT = ((JsonObject)json).has("cardBin") ? CreditCard.class : PayPal.class;
        return gson.fromJson(json, classOfT);
    }
}
