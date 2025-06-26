package com.keyin.client;

import com.keyin.client.RESTClientTest;
import com.keyin.domain.Airport;
import com.keyin.domain.Aircraft;
import com.keyin.http.client.RESTClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.http.*;
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
}
