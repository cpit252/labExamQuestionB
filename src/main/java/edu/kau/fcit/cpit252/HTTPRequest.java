package edu.kau.fcit.cpit252;


import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.net.URL;

public class HTTPRequest {
    private final URL url;
    private final HTTPMethod method;
    private final Map<String, String> headers;
    private final Map<String, String> queryParams;
    private final String body;
    private final int timeout;
    private final String username;
    private final String password;
    private final String contentType;

    // TODO: Implement private constructor

    // TODO: Implement getters for all fields

    // TODO: Implement toString method

    public class Builder {
        // TODO: Add fields for all request components

        // TODO: Implement constructor that takes URL
        public Builder(String url) {
            // Initialize builder with required URL
        }

        // TODO: Implement method() to set HTTP method

        // TODO: Implement header() to add a single header

        // TODO: Implement headers() to add multiple headers

        // TODO: Implement queryParam() to add a single query parameter

        // TODO: Implement queryParams() to add multiple parameters

        // TODO: Implement body() to set request body

        // TODO: Implement timeout() to set request timeout

        // TODO: Implement basicAuth() to set authentication credentials

        // TODO: Implement contentType() to set content type header

        // TODO: Implement build() method that validates and creates HTTPRequest

        private void validate() {
            if (url == null) {
                throw new IllegalStateException("URL is required");
            }
            if (method == null) {
                throw new IllegalStateException("HTTP method is required");
            }
            if ((method == HTTPMethod.POST || method == HTTPMethod.PUT) && body == null) {
                throw new IllegalStateException("Request body is required for POST/PUT requests");
            }
            if (body != null && (method == HTTPMethod.GET || method == HTTPMethod.DELETE)) {
                throw new IllegalStateException("Request body is not allowed for GET/DELETE requests");
            }
        }
    }
