/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.insights.v1;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class ConferenceReader extends Reader<Conference> {
    private String conferenceSid;
    private String friendlyName;
    private String status;
    private String createdAfter;
    private String createdBefore;
    private String mixerRegion;
    private String tags;
    private String subaccount;
    private String detectedIssues;
    private String endReason;

    /**
     * The SID of the conference..
     *
     * @param conferenceSid The SID of the conference.
     * @return this
     */
    public ConferenceReader setConferenceSid(final String conferenceSid) {
        this.conferenceSid = conferenceSid;
        return this;
    }

    /**
     * Custom label for the conference resource, up to 64 characters..
     *
     * @param friendlyName Custom label for the conference.
     * @return this
     */
    public ConferenceReader setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * Conference status..
     *
     * @param status Conference status.
     * @return this
     */
    public ConferenceReader setStatus(final String status) {
        this.status = status;
        return this;
    }

    /**
     * Conferences created after the provided timestamp specified in ISO 8601
     * format.
     *
     * @param createdAfter Conferences created after timestamp.
     * @return this
     */
    public ConferenceReader setCreatedAfter(final String createdAfter) {
        this.createdAfter = createdAfter;
        return this;
    }

    /**
     * Conferences created before the provided timestamp specified in ISO 8601
     * format..
     *
     * @param createdBefore Conferences created before timestamp.
     * @return this
     */
    public ConferenceReader setCreatedBefore(final String createdBefore) {
        this.createdBefore = createdBefore;
        return this;
    }

    /**
     * Twilio region where the conference media was mixed..
     *
     * @param mixerRegion Region where the conference was mixed.
     * @return this
     */
    public ConferenceReader setMixerRegion(final String mixerRegion) {
        this.mixerRegion = mixerRegion;
        return this;
    }

    /**
     * Tags applied by Twilio for common potential configuration, quality, or
     * performance issues..
     *
     * @param tags Tags applied by Twilio for common issues.
     * @return this
     */
    public ConferenceReader setTags(final String tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Account SID for the subaccount whose resources you wish to retrieve..
     *
     * @param subaccount Account SID for the subaccount.
     * @return this
     */
    public ConferenceReader setSubaccount(final String subaccount) {
        this.subaccount = subaccount;
        return this;
    }

    /**
     * Potential configuration, behavior, or performance issues detected during the
     * conference..
     *
     * @param detectedIssues Potential issues detected during the conference.
     * @return this
     */
    public ConferenceReader setDetectedIssues(final String detectedIssues) {
        this.detectedIssues = detectedIssues;
        return this;
    }

    /**
     * Conference end reason; e.g. last participant left, modified by API, etc..
     *
     * @param endReason Conference end reason.
     * @return this
     */
    public ConferenceReader setEndReason(final String endReason) {
        this.endReason = endReason;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Conference ResourceSet
     */
    @Override
    public ResourceSet<Conference> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Conference ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Conference> firstPage(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.INSIGHTS.toString(),
            "/v1/Conferences"
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the target page from the Twilio API.
     *
     * @param targetUrl API-generated URL for the requested results page
     * @param client TwilioRestClient with which to make the request
     * @return Conference ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Conference> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }

    /**
     * Retrieve the next page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<Conference> nextPage(final Page<Conference> page,
                                     final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.INSIGHTS.toString())
        );
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the previous page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Previous Page
     */
    @Override
    public Page<Conference> previousPage(final Page<Conference> page,
                                         final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.INSIGHTS.toString())
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of Conference Resources for a given request.
     *
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<Conference> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Conference read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
           throw new ApiException(restException);
        }

        return Page.fromJson(
            "conferences",
            response.getContent(),
            Conference.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     *
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (conferenceSid != null) {
            request.addQueryParam("ConferenceSid", conferenceSid);
        }

        if (friendlyName != null) {
            request.addQueryParam("FriendlyName", friendlyName);
        }

        if (status != null) {
            request.addQueryParam("Status", status);
        }

        if (createdAfter != null) {
            request.addQueryParam("CreatedAfter", createdAfter);
        }

        if (createdBefore != null) {
            request.addQueryParam("CreatedBefore", createdBefore);
        }

        if (mixerRegion != null) {
            request.addQueryParam("MixerRegion", mixerRegion);
        }

        if (tags != null) {
            request.addQueryParam("Tags", tags);
        }

        if (subaccount != null) {
            request.addQueryParam("Subaccount", subaccount);
        }

        if (detectedIssues != null) {
            request.addQueryParam("DetectedIssues", detectedIssues);
        }

        if (endReason != null) {
            request.addQueryParam("EndReason", endReason);
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}