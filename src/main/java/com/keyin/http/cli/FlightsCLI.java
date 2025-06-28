package com.keyin.http.cli;

import com.keyin.domain.Aircraft;
import com.keyin.domain.Airport;
import com.keyin.http.client.RESTClient;

import java.util.List;

public class FlightsCLI {

    private RESTClient restClient;

    public FlightsCLI() {
        this.restClient = new RESTClient();
    }

    public FlightsCLI(RESTClient restClient) {
        this.restClient = restClient;
    }

    public String airportsByCityReport() {
        List<Airport> airports = restClient.getAirportsByCity();

        StringBuilder report = new StringBuilder();
        report.append("Airports by City:\n");

        for (Airport airport : airports) {
            report.append(airport.getAirportCity() != null ? airport.getAirportCity().getName() : "Unknown City");
            report.append(": ");
            report.append(airport.getAirportName()).append(" (").append(airport.getAirportCode()).append(")\n");
        }

        String output = report.toString();
        System.out.println(output);
        return output;
    }

    public String aircraftByPassengerReport() {
        List<Aircraft> aircrafts = restClient.getAircraftByPassenger();

        StringBuilder report = new StringBuilder();
        report.append("Aircraft by Passenger:\n");

        for (Aircraft ac : aircrafts) {
            report.append(ac.getAircraftPassengers().toString()).append(" ").append(ac.getAircraftType()).append(" (").append(ac.getAirlineName()).append(")\n");
        }

        String output = report.toString();
        System.out.println(output);
        return output;
    }

    public String airportsByAircraftReport() {
        List<Aircraft> aircrafts = restClient.getAirportsByAircraft();

        StringBuilder report = new StringBuilder();
        report.append("Airports by Aircraft:\n");

        for (Aircraft aircraft : aircrafts) {
            report.append(aircraft.getAircraftType()).append(" ").append(aircraft.getAircraftAirports().toString()).append("\n");
        }

        String output = report.toString();
        System.out.println(output);
        return output;
    }

    public String airportsByPassengerReport() {
        List<Airport> airports = restClient.getAirportsByPassengers();

        StringBuilder report = new StringBuilder();
        report.append("Airports used by Passengers:\n");

        for (Airport airport : airports) {
            report.append(airport.getAirportName()).append(" (").append(airport.getAirportCode()).append(")\n");
        }

        String output = report.toString();
        System.out.println(output);
        return output;
    }

    public RESTClient getRestClient() {
        return restClient;
    }

    public void setRestClient(RESTClient restClient) {
        this.restClient = restClient;
    }

    public static void main(String[] args) {


        String serverURL = "http://localhost:8080/airport";

        FlightsCLI cli = new FlightsCLI();
        cli.getRestClient().setServerURL(serverURL);
        cli.airportsByCityReport();

        serverURL = "http://localhost:8080/aircraft";
        cli.getRestClient().setServerURL(serverURL);
        cli.aircraftByPassengerReport();
        cli.airportsByAircraftReport();

        serverURL = "http://localhost:8080/airport";
        cli.getRestClient().setServerURL(serverURL);
        cli.airportsByPassengerReport();
    }
}
