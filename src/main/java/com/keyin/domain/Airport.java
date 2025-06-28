package com.keyin.domain;

public class Airport {
    private long id;

    public String airportName;
    public String airportCode;
    private City airportCity;

    public Airport() {

    }

    public Airport(long id) {
        this.id = id;
    }

    public Airport(String airportName, String airportCode) {
        this.airportName = airportName;
        this.airportCode = airportCode;
    }

    public long getId() {
        return id;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public City getAirportCity() {
        return airportCity;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public void setAirportCity(City airportCity) {
        this.airportCity = airportCity;
    }

    public String toString() {
        return airportName + " (" + airportCode + ")";
    }
}

