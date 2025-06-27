package com.keyin.client;

import com.keyin.domain.Aircraft;
import com.keyin.domain.Airport;
import com.keyin.http.client.RESTClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


public class RESTClientTest {

    private RESTClient testRestClient;

    @BeforeEach
    public void setUpRestClient() {
        testRestClient = new RESTClient();
    }

    @Test
    public void testBuildAirportListFromHttpResponse() throws Exception {
        String mockJSON = """
                [
                    {"id": 1, "airportName": "MockedAir1", "airportCode": "HSI"},
                    {"id": 2, "airportName": "MockedAir2", "airportCode": "WTS"}
                ]
                """;

        List<Airport> airportList = testRestClient.buildAirportListFromHttpResponse(mockJSON);

        Assertions.assertEquals("MockedAir1", airportList.get(0).getAirportName());
        Assertions.assertEquals("HSI", airportList.get(0).getAirportCode());

        Assertions.assertEquals("MockedAir2", airportList.get(1).getAirportName());
        Assertions.assertEquals("WTS", airportList.get(1).getAirportCode());
    }

    @Test
    public void testBuildAircraftListFromHttpResponse() throws Exception {
        String mockJSON = """
                [
                    {"id": 1, "aircraftType": "MockedCraft1", "airlineName": "MockedLine1", "numberOfPassengers": 50},
                    {"id": 2, "aircraftType": "MockedCraft2", "airlineName": "MockedLine2", "numberOfPassengers": 20}
                ]
                """;

        List<Aircraft> aircraftList = testRestClient.buildAircraftListFromHttpResponse(mockJSON);

        Assertions.assertEquals("MockedCraft1", aircraftList.get(0).getAircraftType());
        Assertions.assertEquals("MockedLine1", aircraftList.get(0).getAirlineName());

        Assertions.assertEquals("MockedCraft2", aircraftList.get(1).getAircraftType());
        Assertions.assertEquals("MockedLine2", aircraftList.get(1).getAirlineName());
    }
}