package com.github.mcac0006.ravelin.base;

import static java.lang.String.format;

/**
 * Created by matthew.cachia on 12/07/2016.
 */
public abstract class RavelinRequest {

    public String getURL() {

        return format("https://api.ravelin.com/%s", getPath());
    }

    public abstract String getPath();
}
