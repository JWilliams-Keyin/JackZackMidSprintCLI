package com.keyin.client;

import com.keyin.client.RESTClientTest;
import com.keyin.domain.Airport;
import com.keyin.domain.Aircraft;
import com.keyin.http.client.RESTClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RESTClientTest {

    @BeforeEach
    public void setUpTestRestClient() {
        RESTClient restClient = new RESTClient();

        HttpClient mockHttpClient = mock(HttpClient.class);
        HttpResponse<String> mockResponse = mock(HttpResponse.class);

        restClient.setHttpClient(mockHttpClient);
    }
}
