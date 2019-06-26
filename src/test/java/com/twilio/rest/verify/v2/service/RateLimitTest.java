/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.verify.v2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static com.twilio.TwilioTest.serialize;
import static org.junit.Assert.*;

public class RateLimitTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testCreateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.VERIFY.toString(),
                                          "/v2/Services/VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/RateLimits");
            request.addPostParam("UniqueName", serialize("unique_name"));
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            RateLimit.creator("VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "unique_name").create();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testCreateRateLimitResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"RKaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"unique_name\": \"unique.name\",\"description\": \"Description\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"url\": \"https://verify.twilio.com/v2/Services/VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/RateLimits/RKaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"links\": {\"buckets\": \"https://verify.twilio.com/v2/Services/VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/RateLimits/RKaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Buckets\"}}", TwilioRestClient.HTTP_STATUS_CODE_CREATED);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        RateLimit.creator("VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "unique_name").create();
    }

    @Test
    public void testUpdateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.VERIFY.toString(),
                                          "/v2/Services/VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/RateLimits/RKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            RateLimit.updater("VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "RKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").update();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testUpdateRateLimitResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"RKaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"unique_name\": \"unique.name\",\"description\": \"Description\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"url\": \"https://verify.twilio.com/v2/Services/VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/RateLimits/RKaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"links\": {\"buckets\": \"https://verify.twilio.com/v2/Services/VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/RateLimits/RKaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Buckets\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        RateLimit.updater("VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "RKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").update();
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.VERIFY.toString(),
                                          "/v2/Services/VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/RateLimits/RKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            RateLimit.fetcher("VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "RKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchRateLimitResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"RKaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"unique_name\": \"unique.name\",\"description\": \"Description\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"url\": \"https://verify.twilio.com/v2/Services/VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/RateLimits/RKaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"links\": {\"buckets\": \"https://verify.twilio.com/v2/Services/VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/RateLimits/RKaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Buckets\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(RateLimit.fetcher("VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "RKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch());
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.VERIFY.toString(),
                                          "/v2/Services/VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/RateLimits");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            RateLimit.reader("VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadAllResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"meta\": {\"page\": 0,\"page_size\": 50,\"first_page_url\": \"https://verify.twilio.com/v2/Services/VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/RateLimits?PageSize=50&Page=0\",\"previous_page_url\": null,\"next_page_url\": null,\"key\": \"rate_limits\",\"url\": \"https://verify.twilio.com/v2/Services/VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/RateLimits?PageSize=50&Page=0\"},\"rate_limits\": [{\"sid\": \"RKaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"unique_name\": \"unique.name\",\"description\": \"Description\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"url\": \"https://verify.twilio.com/v2/Services/VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/RateLimits/RKaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"links\": {\"buckets\": \"https://verify.twilio.com/v2/Services/VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/RateLimits/RKaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Buckets\"}}]}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(RateLimit.reader("VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read());
    }

    @Test
    public void testDeleteRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.DELETE,
                                          Domains.VERIFY.toString(),
                                          "/v2/Services/VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/RateLimits/RKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            RateLimit.deleter("VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "RKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").delete();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testDeleteResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("null", TwilioRestClient.HTTP_STATUS_CODE_NO_CONTENT);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        RateLimit.deleter("VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "RKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").delete();
    }
}