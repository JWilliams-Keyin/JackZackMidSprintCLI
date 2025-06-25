package com.keyin.domain;

import java.util.List;

public class Aircraft {
    private long id;
    public String aircraftType;
    public String airlineName;
    public int numberOfPassengers;
    private List<Passenger> aircraftPassengers;
    private List<Airport> aircraftAirports;

    public Aircraft() {
    }

    public Aircraft(long id) {
        this.id = id;
    }

    public Aircraft(String aircraftType, String airlineName) {
        this.aircraftType = aircraftType;
        this.airlineName = airlineName;
    }

    public long getId() {
        return id;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public List<Passenger> getAircraftPassengers() {
        return aircraftPassengers;
    }

    public List<Airport> getAircraftAirports() {
        return aircraftAirports;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public void setAircraftPassengers(List<Passenger> aircraftPassengers) {
        this.aircraftPassengers = aircraftPassengers;
    }

    public void setAircraftAirports(List<Airport> aircraftAirports) {
        this.aircraftAirports = aircraftAirports;
    }
}

