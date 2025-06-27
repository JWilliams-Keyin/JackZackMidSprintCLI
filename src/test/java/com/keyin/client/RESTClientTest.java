package com.keyin.client;

import com.keyin.http.client.RESTClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.http.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RESTClientTest {

    private RESTClient restClient;
    private HttpClient httpClient;
    private HttpResponse<String> httpResponse;

    @BeforeEach
    public void setUpTestRestClient() {
        restClient = new RESTClient();

        httpClient = HttpClient.newBuilder().build();

        restClient.setHttpClient(httpClient);
    }
}