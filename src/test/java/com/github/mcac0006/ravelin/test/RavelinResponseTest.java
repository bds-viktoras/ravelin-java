package com.github.mcac0006.ravelin.test;

import com.github.mcac0006.ravelin.response.Action;
import com.github.mcac0006.ravelin.response.RavelinResponse;
import com.github.mcac0006.ravelin.response.RavelinScoreResponse;

import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Created by matthew.cachia on 05/07/2016.
 */
public class RavelinResponseTest {

    @Test public void responseNoScoreTest() throws Exception {

        RavelinResponse expectedResponse = new RavelinResponse(1468221320, 200, null, null, null);

        RavelinResponse generatedResponse;
        {
            {
                final List list = FileUtils.readLines(new File("target/test-classes/response/responseWithoutScore.json"));
                final String content = StringUtils.join(list.iterator(), "");

                generatedResponse = RavelinResponse.parse(content);
            }
        }

        Assert.assertEquals(expectedResponse, generatedResponse);
    }

    @Test public void scoreTest() throws Exception {

        RavelinResponse expectedResponse;
        {
            RavelinScoreResponse ravelinScore = new RavelinScoreResponse("61283761287361", Action.ALLOW, 2, "RAVELIN", "2910e099-b00e-44a7-6e16-a42ddfc7c3ff", null);
            expectedResponse = new RavelinResponse(1468224262, 200, null, null, ravelinScore);
        }

        RavelinResponse generatedResponse;
        {
            {
                final List list = FileUtils.readLines(new File("target/test-classes/response/responseWithScore.json"));
                final String content = StringUtils.join(list.iterator(), "");

                generatedResponse = RavelinResponse.parse(content);
            }
        }

        Assert.assertEquals(expectedResponse, generatedResponse);
    }

    @Test public void customerNotFoundScoreTest() throws Exception {

        RavelinResponse expectedResponse = new RavelinResponse(1468222819, 400, "Customer not found", "9f641b70-1522-4971-4af8-001e71494dec", null);

        RavelinResponse generatedResponse;
        {
            {
                final List list = FileUtils.readLines(new File("target/test-classes/response/responseCustomerNotFound.json"));
                final String content = StringUtils.join(list.iterator(), "");

                generatedResponse = RavelinResponse.parse(content);
            }
        }

        Assert.assertEquals(expectedResponse, generatedResponse);
    }
}
