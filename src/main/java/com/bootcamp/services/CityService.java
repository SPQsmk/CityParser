package com.bootcamp.services;

import com.bootcamp.models.City;
import org.hibernate.SessionFactory;

import java.util.*;

public class CityService {
    private List<City> cities;
    private SessionFactory factory;

    public CityService() {
        cities = Parser.parse("src/main/resources/cities.txt");

    }

    public List<City> getCities() {
        return new ArrayList<>(cities);
    }

    public List<City> sortByNameDescIgnoreCase() {
        Comparator<City> cmp = (c1, c2) -> c2.getName().compareToIgnoreCase(c1.getName());
        return getSortedList(cmp);
    }

    public List<City> sortByDistrictAndNameDesc() {
        Comparator<City> cmp = (c1, c2) -> {
            int c = c1.getDistrict().compareTo(c2.getDistrict());

            if (c == 0)
                return c1.getName().compareTo(c2.getName());

            return c;
        };

        return getSortedList(cmp);
    }

    public int[] getMaxPopulationData() {
        if (cities.isEmpty())
            return new int[] {-1, -1};

        City[] arr = new City[cities.size()];
        cities.toArray(arr);

        int maxIndex = 0;
        int maxPopulation = arr[maxIndex].getPopulation();

        int currentPopulation;
        for (int i = 1; i < arr.length; ++i) {
            currentPopulation = arr[i].getPopulation();
            if (currentPopulation > maxPopulation) {
                maxIndex = i;
                maxPopulation = currentPopulation;
            }
        }

        return new int[] {maxIndex, maxPopulation};
    }

    public Map<String, Integer> getRegions() {
        Map<String, Integer> res = new HashMap<>();

        for (City o : cities) {
            String regionName = o.getRegion();
            res.put(regionName, res.getOrDefault(regionName, 0) + 1);
        }

        return res;
    }

    private List<City> getSortedList(Comparator<City> cmp) {
        List<City> res = new ArrayList<>(cities);
        res.sort(cmp);
        return res;
    }
}
