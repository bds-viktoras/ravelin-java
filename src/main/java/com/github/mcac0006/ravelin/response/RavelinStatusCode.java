package com.github.mcac0006.ravelin.response;

import static java.lang.String.format;

/**
 * Created by matthew.cachia on 06/07/2016.
 */
public enum RavelinStatusCode {

    OK(200, 204),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    NOT_ACCEPTABLE(406),
    TOO_MANY_REQUESTS(429),
    INTERNAL_SERVER_ERROR(500),
    SERVICE_UNAVAILABLE(503),
    SERVICE_TIMEOUT(504);

    private int[] httpResponseCodes;

    private RavelinStatusCode(int... httpResponseCodes) {
        this.httpResponseCodes = httpResponseCodes;
    }

    public int[] getHttpResponseCodes() {
        return httpResponseCodes;
    }

    /**
     *
     * Returns the enum constant of the specified http response code.
     *
     * @param httpResponseCode the http response code received from Ravelin's servers.
     * @return the enum constant of the specified http response code
     * @throws IllegalArgumentException if the specified http response code has
     *                                  no constant with the specified name.
     * @throws NullPointerException     if {@code httpResponseCodes} is null.
     */
    public static RavelinStatusCode resolve(int httpResponseCode) {

        for (RavelinStatusCode errorCode : values()) {
            for (int responseCode : errorCode.httpResponseCodes) {
                if (responseCode == httpResponseCode) {
                    return errorCode;
                }
            }
        }

        throw new IllegalArgumentException(format("Cannot find error code for the specified http response code [%s].", httpResponseCode));
    }
}
