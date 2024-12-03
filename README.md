# Lab Exam - Question B

## Description

A development team needs to implement a flexible HTTP request builder that allows developers to construct HTTP requests 
in a readable and maintainable way. The current implementation uses multiple constructors and setter methods, making it 
difficult to create requests with different combinations of headers, parameters, and body content.

The team wants to implement a fluent Builder pattern that supports:
- Different HTTP methods (GET, POST, PUT, DELETE)
- Custom headers
- Query parameters
- Request body (for POST/PUT requests)
- Basic authentication
- Custom timeouts
- Content type settings

## Requirements
- Maven
- JUnit 5
- An IDE such as IntelliJ IDEA or editor such as VS Code

## Question
Complete the implementation of the `HTTPRequest` class using the Builder pattern. The class should:
1. Use a nested static Builder class with method chaining
2. Support all major HTTP methods
3. Allow adding multiple headers and parameters
4. Validate the request configuration before building
5. Handle different content types appropriately
6. Implement proper input validation

Fix the broken/incomplete implementation in `src/main/java/com/example/HTTPRequest.java` and make all tests pass.
