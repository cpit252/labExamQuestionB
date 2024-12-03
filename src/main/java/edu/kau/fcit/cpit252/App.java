package edu.kau.fcit.cpit252;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        try {
            // Simple GET request
            HTTPRequest getRequest = new HTTPRequest.Builder("https://api.example.com/users")
                    .method(HTTPMethod.GET)
                    .header("Accept", "application/json")
                    .queryParam("page", "1")
                    .queryParam("size", "10")
                    .timeout(5000)
                    .build();

            System.out.println("GET Request Example:");
            System.out.println(getRequest);
            System.out.println();

            // POST request with JSON body
            String jsonBody = "{\"name\":\"John Doe\",\"email\":\"john@example.com\"}";
            HTTPRequest postRequest = new HTTPRequest.Builder("https://api.example.com/users")
                    .method(HTTPMethod.POST)
                    .contentType("application/json")
                    .body(jsonBody)
                    .build();

            System.out.println("POST Request Example:");
            System.out.println(postRequest);
            System.out.println();

            // PUT request with authentication
            HTTPRequest putRequest = new HTTPRequest.Builder("https://api.example.com/users/123")
                    .method(HTTPMethod.PUT)
                    .basicAuth("admin", "password123")
                    .contentType("application/json")
                    .body("{\"status\":\"active\"}")
                    .build();

            System.out.println("PUT Request with Auth Example:");
            System.out.println(putRequest);
            System.out.println();

            // Complex GET request with multiple headers and parameters
            Map<String, String> headers = new HashMap<>();
            headers.put("Accept-Language", "en-US");
            headers.put("User-Agent", "MyApp/1.0");
            headers.put("Authorization", "Bearer token123");

            Map<String, String> queryParams = new HashMap<>();
            queryParams.put("filter", "active");
            queryParams.put("sort", "name");
            queryParams.put("order", "desc");

            HTTPRequest complexRequest = new HTTPRequest.Builder("https://api.example.com/search")
                    .method(HTTPMethod.GET)
                    .headers(headers)
                    .queryParams(queryParams)
                    .timeout(10000)
                    .build();

            System.out.println("Complex GET Request Example:");
            System.out.println(complexRequest);

        } catch (Exception e) {
            System.err.println("Error creating HTTP request: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
