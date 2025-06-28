package com.keyin.cli;

import com.keyin.domain.Aircraft;
import com.keyin.domain.Airport;
import com.keyin.domain.City;
import com.keyin.domain.Passenger;
import com.keyin.http.client.RESTClient;
import com.keyin.http.cli.FlightsCLI;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlightsCLITest {

    private static class TestRESTClient extends RESTClient {
        @Override
        public List<Airport> getAirportsByCity() {
            City city = new City();
            city.setName("SampleCity");

            Airport airport1 = new Airport();
            airport1.setAirportName("AirportOne");
            airport1.setAirportCode("A1");
            airport1.setAirportCity(city);

            Airport airport2 = new Airport();
            airport2.setAirportName("AirportTwo");
            airport2.setAirportCode("A2");
            airport2.setAirportCity(city);

            return Arrays.asList(airport1, airport2);
        }

        @Override
        public List<Aircraft> getAircraftByPassenger() {
            Passenger passenger1 = new Passenger("Test", "Man", "1234567890");
            List<Passenger> passengerList1 = new ArrayList<>();
            passengerList1.add(passenger1);

            Aircraft aircraft1 = new Aircraft();
            aircraft1.setAircraftType("TypeX");
            aircraft1.setAirlineName("AirlineX");
            aircraft1.setAircraftPassengers(passengerList1);

            Passenger passenger2 = new Passenger("Test", "Woman", "0987654321");
            List<Passenger> passengerList2 = new ArrayList<>();
            passengerList1.add(passenger2);

            Aircraft aircraft2 = new Aircraft();
            aircraft2.setAircraftType("TypeY");
            aircraft2.setAirlineName("AirlineY");
            aircraft2.setAircraftPassengers(passengerList2);

            return Arrays.asList(aircraft1, aircraft2);
        }

        @Override
        public List<Aircraft> getAirportsByAircraft() {
            Airport airport1 = new Airport("Airport1", "AJS");
            List<Airport> airportsList1 = new ArrayList<>();
            airportsList1.add(airport1);

            Aircraft aircraft1 = new Aircraft();
            aircraft1.setAircraftType("AircraftA");
            aircraft1.setAircraftAirports(airportsList1);

            Airport airport2 = new Airport("Airport2", "ABS");
            List<Airport> airportsList2 = new ArrayList<>();
            airportsList2.add(airport2);

            Aircraft aircraft2 = new Aircraft();
            aircraft2.setAircraftType("AircraftB");
            aircraft2.setAircraftAirports(airportsList2);

            return Arrays.asList(aircraft1, aircraft2);
        }

        @Override
        public List<Airport> getAirportsByPassengers() {
            Airport airport1 = new Airport();
            airport1.setAirportName("AirportX");
            airport1.setAirportCode("XX");

            Airport airport2 = new Airport();
            airport2.setAirportName("AirportY");
            airport2.setAirportCode("YY");

            return Arrays.asList(airport1, airport2);
        }
    }

    @Test
    public void testAirportsByCityReport() {
        FlightsCLI flightsCLI = new FlightsCLI(new TestRESTClient());

        String result = flightsCLI.airportsByCityReport();

        assertTrue(result.contains("SampleCity: AirportOne (A1)"));
        assertTrue(result.contains("SampleCity: AirportTwo (A2)"));
    }

    @Test
    public void testAircraftByPassengerReport() {
        FlightsCLI flightsCLI = new FlightsCLI(new TestRESTClient());

        String result = flightsCLI.aircraftByPassengerReport();

        assertTrue(result.contains("TypeX (AirlineX)"));
        assertTrue(result.contains("TypeY (AirlineY)"));
    }

    @Test
    public void testAirportsByAircraftReport() {
        FlightsCLI flightsCLI = new FlightsCLI(new TestRESTClient());

        String result = flightsCLI.airportsByAircraftReport();

        assertTrue(result.contains("Airports by Aircraft:\nAircraftA [Airport1 (AJS)]\nAircraftB [Airport2 (ABS)]\n"));
    }

    @Test
    public void testAirportsByPassengerReport() {
        FlightsCLI flightsCLI = new FlightsCLI(new TestRESTClient());

        String result = flightsCLI.airportsByPassengerReport();

        assertTrue(result.contains("AirportX (XX)"));
        assertTrue(result.contains("AirportY (YY)"));
    }
}
