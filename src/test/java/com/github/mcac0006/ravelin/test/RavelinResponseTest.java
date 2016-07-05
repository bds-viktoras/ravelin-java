package com.github.mcac0006.ravelin.test;

import com.github.mcac0006.ravelin.response.Action;
import com.github.mcac0006.ravelin.response.RavelinResponse;
import com.google.gson.Gson;
import com.sun.deploy.util.StringUtils;
import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Created by matthew.cachia on 05/07/2016.
 */
public class RavelinResponseTest {

    @Test public void responseTest() throws Exception {

        RavelinResponse expectedResponse = new RavelinResponse("123456789", Action.PREVENT, 77, "RAVELIN", "2bf39d-d1299-31", "");

        RavelinResponse generatedResponse;
        {
            {
                final List list = FileUtils.readLines(new File("target/test-classes/response.json"));
                final String content = StringUtils.join(list, "");

                Gson gson = new Gson();
                generatedResponse = gson.fromJson(content, RavelinResponse.class);
            }
        }

        Assert.assertEquals(expectedResponse, generatedResponse);
    }
}
