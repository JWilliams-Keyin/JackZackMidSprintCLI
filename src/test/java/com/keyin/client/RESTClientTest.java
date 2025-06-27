package com.keyin.client;

import com.keyin.client.RESTClientTest;
import com.keyin.domain.Airport;
import com.keyin.domain.Aircraft;
import com.keyin.http.client.RESTClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.http.*;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RESTClientTest {

    private RESTClient restClient;
    private HttpClient mockHttpClient;
    private HttpResponse<String> mockResponse;

    @BeforeEach
    public void setUpTestRestClient() {
        restClient = new RESTClient();

        mockHttpClient = mock(HttpClient.class);
        mockResponse = mock(HttpResponse.class);

        restClient.setHttpClient(mockHttpClient);
    }

    @Test
    public void testGetResponseFromHttpRequest_ReturnsBodyOnSuccess() throws Exception {
        String expectedBody = "Hello I am mocked data";

        when(mockResponse.statusCode()).thenReturn(200);
        when(mockResponse.body()).thenReturn(expectedBody);
        when(mockHttpClient.send(any(HttpRequest.class), eq(HttpResponse.BodyHandlers.ofString())))
                .thenReturn(mockResponse);

        String actualBody = restClient.getResponseFromHttpRequest();

        assertEquals(expectedBody, actualBody);
    }

    @Test
    public void testGetResponseFromHttpRequest_HandlesNon200() throws Exception {
        String expectedBody = "Something went wrong, which is what I want";

        when(mockResponse.statusCode()).thenReturn(500);
        when(mockResponse.body()).thenReturn(expectedBody);
        when(mockHttpClient.send(any(HttpRequest.class), eq(HttpResponse.BodyHandlers.ofString())))
                .thenReturn(mockResponse);

        String actualBody = restClient.getResponseFromHttpRequest();

        assertEquals(expectedBody, actualBody);
    }

    @Test
    public void testGetResponseFromHttpRequest_ExceptionReturnsEmptyString() throws Exception {
        when(mockHttpClient.send(any(HttpRequest.class), eq(HttpResponse.BodyHandlers.ofString())))
                .thenThrow(new IOException("Connection failed (but that's good)"));

        String actualBody = restClient.getResponseFromHttpRequest();

        assertEquals("", actualBody);
    }
}