/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.wireless.v1;

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

public class UsageRecordTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.WIRELESS.toString(),
                                          "/v1/UsageRecords");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            UsageRecord.reader().read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"usage_records\": [{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"commands\": {\"billing_units\": \"USD\",\"billed\": 0,\"total\": 3,\"from_sim\": 1,\"to_sim\": 2,\"home\": {\"billing_units\": \"USD\",\"billed\": 0,\"total\": 3,\"from_sim\": 1,\"to_sim\": 2},\"national_roaming\": {\"billing_units\": \"USD\",\"billed\": 0,\"total\": 0,\"from_sim\": 0,\"to_sim\": 0},\"international_roaming\": []},\"data\": {\"billing_units\": \"USD\",\"billed\": 0.35,\"total\": 3494609,\"upload\": 731560,\"download\": 2763049,\"units\": \"bytes\",\"home\": {\"billing_units\": \"USD\",\"billed\": 0.35,\"total\": 3494609,\"upload\": 731560,\"download\": 2763049,\"units\": \"bytes\"},\"national_roaming\": {\"billing_units\": \"USD\",\"billed\": 0,\"total\": 0,\"upload\": 0,\"download\": 0,\"units\": \"bytes\"},\"international_roaming\": []},\"period\": {\"start\": \"2015-07-30T20:00:00Z\",\"end\": \"2015-07-30T20:00:00Z\"}},{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"commands\": {},\"data\": {},\"period\": {}}],\"meta\": {\"first_page_url\": \"https://wireless.twilio.com/v1/UsageRecords?Start=2015-07-30T20%3A00%3A00Z&End=2015-07-30T20%3A00%3A00Z&PageSize=50&Page=0\",\"key\": \"usage_records\",\"next_page_url\": null,\"page\": 0,\"page_size\": 50,\"previous_page_url\": null,\"url\": \"https://wireless.twilio.com/v1/UsageRecords?Start=2015-07-30T20%3A00%3A00Z&End=2015-07-30T20%3A00%3A00Z&PageSize=50&Page=0\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(UsageRecord.reader().read());
    }
}