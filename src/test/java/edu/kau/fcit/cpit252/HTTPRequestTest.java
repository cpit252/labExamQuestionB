package edu.kau.fcit.cpit252;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.HashMap;

public class HTTPRequestTest {

    @Test
    public void testBuildGetRequest() throws MalformedURLException {
        HTTPRequest request = new HTTPRequest.Builder("https://api.example.com/users")
                .method(HTTPMethod.GET)
                .header("Accept", "application/json")
                .build();

        assertEquals(HTTPMethod.GET, request.getMethod());
        assertEquals("application/json", request.getHeaders().get("Accept"));
    }

    @Test
    public void testBuildPostRequest() throws MalformedURLException {
        String jsonBody = "{\"name\":\"John\",\"age\":30}";
        HTTPRequest request = new HTTPRequest.Builder("https://api.example.com/users")
                .method(HTTPMethod.POST)
                .contentType("application/json")
                .body(jsonBody)
                .build();

        assertEquals(HTTPMethod.POST, request.getMethod());
        assertEquals(jsonBody, request.getBody());
        assertEquals("application/json", request.getContentType());
    }

    @Test
    public void testQueryParameters() throws MalformedURLException {
        HTTPRequest request = new HTTPRequest.Builder("https://api.example.com/search")
                .method(HTTPMethod.GET)
                .queryParam("q", "test")
                .queryParam("page", "1")
                .build();

        Map<String, String> params = request.getQueryParams();
        assertEquals("test", params.get("q"));
        assertEquals("1", params.get("page"));
    }

    @Test
    public void testMultipleHeaders() throws MalformedURLException {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Authorization", "Bearer token123");

        HTTPRequest request = new HTTPRequest.Builder("https://api.example.com/users")
                .method(HTTPMethod.GET)
                .headers(headers)
                .build();

        assertEquals(headers, request.getHeaders());
    }

    @Test
    public void testBasicAuth() throws MalformedURLException {
        HTTPRequest request = new HTTPRequest.Builder("https://api.example.com/secure")
                .method(HTTPMethod.GET)
                .basicAuth("username", "password")
                .build();

        assertEquals("username", request.getUsername());
        assertEquals("password", request.getPassword());
    }

    @Test
    public void testInvalidURL() {
        assertThrows(MalformedURLException.class, () -> {
            new HTTPRequest.Builder("not a valid url").build();
        });
    }

    @Test
    public void testTimeout() throws MalformedURLException {
        HTTPRequest request = new HTTPRequest.Builder("https://api.example.com/users")
                .method(HTTPMethod.GET)
                .timeout(5000)
                .build();

        assertEquals(5000, request.getTimeout());
    }

    @Test
    public void testMethodChaining() throws MalformedURLException {
        HTTPRequest.Builder builder = new HTTPRequest.Builder("https://api.example.com/users");
        assertSame(builder, builder.method(HTTPMethod.GET), "Method chaining not working for method()");
        assertSame(builder, builder.header("key", "value"), "Method chaining not working for header()");
    }
}
