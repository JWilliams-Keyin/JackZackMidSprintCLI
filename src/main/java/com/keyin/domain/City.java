package com.keyin.domain;

import java.util.List;

public class City {
    private long id;

    private String name;
    private String state;
    private int population;
    private List<Airport> airports;

    public City() {}

    public City(String name, String state, int population) {
        this.name = name;
        this.state = state;
        this.population = population;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public int getPopulation() {
        return population;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }
}

