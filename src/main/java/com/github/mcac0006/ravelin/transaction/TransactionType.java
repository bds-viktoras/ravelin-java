package com.github.mcac0006.ravelin.transaction;


import com.github.mcac0006.ravelin.base.paymentmethod.CreditCard;
import com.github.mcac0006.ravelin.base.paymentmethod.PaymentMethod;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Optional;

/**
 * 
 * @author <a href="matthew.cachia@gmail.com">matthew.cachia</a>
 *
 */
public enum TransactionType {

    AUTH("auth"),
    CAPTURE("capture"),
    AUTH_CAPTURE("auth_capture"),
    VOID("void"),
    REFUND("refund"),
    REDEEM("redeem"),
    USE("use"),;

    private String code;

    TransactionType(String code) {
        this.code = code;
    }

    /**
     * @param code
     * @return
     * @throws IllegalArgumentException - if the specified enum type has no constant with the specified name, or the specified class object does not represent an enum type.
     */
    public static TransactionType resolve(String code) throws IllegalArgumentException {

        Optional<TransactionType> first = Arrays.asList(values()).stream().filter(tt -> tt.code.equals(code)).findFirst();
        if (first.isPresent())
            return first.get();
        else
            throw new IllegalArgumentException();
    }

    public static class TransactionTypeHandler implements JsonSerializer<TransactionType>, JsonDeserializer<TransactionType> {
        @Override
        public TransactionType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

            return TransactionType.resolve(json.getAsString());
        }

        @Override
        public JsonElement serialize(TransactionType src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.code);
        }
    }
}
