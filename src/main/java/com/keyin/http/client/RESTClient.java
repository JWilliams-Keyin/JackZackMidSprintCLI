package com.keyin.http.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.keyin.domain.Aircraft;
import com.keyin.domain.Airport;
import com.keyin.domain.City;
import com.keyin.domain.Passenger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class RESTClient {
    private String serverURL;
    private HttpClient httpClient;

    public String getResponseFromHttpRequest() {
        String responseBody = "";
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(serverURL)).build();

        try {
            HttpResponse<String> httpResponse = getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (httpResponse.statusCode() != 200) {
                System.out.println("Error Status Code: " + httpResponse.statusCode());
            }

            responseBody = httpResponse.body();
        } catch (IOException | InterruptedException error) {
            error.printStackTrace();
        }

        return responseBody;
    }

    public List<Airport> getAirportsByCity() {
        List<Airport> airports = new ArrayList<Airport>();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(serverURL)).build();

        try {
            HttpResponse<String> httpResponse = getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (httpResponse.statusCode() == 200) {
                System.out.println("***** " + httpResponse.body());
            } else {
                System.out.println("Error Status Code: " + httpResponse.statusCode());
            }

            airports = buildAirportListFromHttpResponse(httpResponse.body());
        } catch (IOException | InterruptedException error) {
            error.printStackTrace();
        }

        return airports;
    }

    public List<Aircraft> getAircraftByPassenger() {
        List<Aircraft> aircrafts = new ArrayList<Aircraft>();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(serverURL)).build();

        try {
            HttpResponse<String> httpResponse = getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (httpResponse.statusCode() == 200) {
                System.out.println("***** " + httpResponse.body());
            } else {
                System.out.println("Error Status Code: " + httpResponse.statusCode());
            }

            aircrafts = buildAircraftListFromHttpResponse(httpResponse.body());
        } catch (IOException | InterruptedException error) {
            error.printStackTrace();
        }

        return aircrafts;
    }

    public List<Airport> getAirportsByAircraft() {
        List<Airport> airports = new ArrayList<Airport>();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(serverURL)).build();

        try {
            HttpResponse<String> httpResponse = getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (httpResponse.statusCode() == 200) {
                System.out.println("***** " + httpResponse.body());
            } else {
                System.out.println("Error Status Code: " + httpResponse.statusCode());
            }

            airports = buildAirportListFromHttpResponse(httpResponse.body());
        } catch (IOException | InterruptedException error) {
            error.printStackTrace();
        }

        return airports;
    }

    public List<Airport> getAirportsByPassengers() {
        List<Airport> airports = new ArrayList<Airport>();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(serverURL)).build();

        try {
            HttpResponse<String> httpResponse = getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (httpResponse.statusCode() == 200) {
                System.out.println("***** " + httpResponse.body());
            } else {
                System.out.println("Error Status Code: " + httpResponse.statusCode());
            }

            airports = buildAirportListFromHttpResponse(httpResponse.body());
        } catch (IOException | InterruptedException error) {
            error.printStackTrace();
        }

        return airports;
    }

    public List<Airport> buildAirportListFromHttpResponse(String httpResponse) throws JsonProcessingException {
        List<Airport> airports = new ArrayList<Airport>();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        airports = objectMapper.readValue(httpResponse, new TypeReference<List<Airport>>(){});

        return airports;
    }

    public List<Aircraft> buildAircraftListFromHttpResponse(String httpResponse) throws JsonProcessingException {
        List<Aircraft> aircrafts = new ArrayList<Aircraft>();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        aircrafts = objectMapper.readValue(httpResponse, new TypeReference<List<Aircraft>>(){});

        return aircrafts;
    }

    public HttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = HttpClient.newHttpClient();
        }

        return httpClient;
    }
}
