package com.bootcamp;

import java.util.Objects;

public class City {
    private final String name;
    private final String region;
    private final String district;
    private final int population;
    private final int foundation;

    public City(String name, String region, String district, int population, int foundation) {
        Objects.requireNonNull(name, "Incorrect name");
        Objects.requireNonNull(region, "Incorrect region");
        Objects.requireNonNull(district, "Incorrect district");

        if (population <= 0)
            throw new IllegalArgumentException("Incorrect population");

        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public int getFoundation() {
        return foundation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return population == city.population && foundation == city.foundation && name.equals(city.name) && region.equals(city.region) && district.equals(city.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, region, district, population, foundation);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation=" + foundation +
                '}';
    }
}
