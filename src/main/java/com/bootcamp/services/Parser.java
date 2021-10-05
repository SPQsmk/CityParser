package com.bootcamp.services;

import com.bootcamp.models.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityParser {
    private CityParser() {}

    public static List<City> parse(String fileName) {
        List<City> res = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine()) {
                String[] params = sc.nextLine().split(";", 6);

                String name = params[1];
                String region = params[2];
                String district = params[3];

                int population = Integer.parseInt(params[4]);
                int foundation = Integer.parseInt(params[5]);

                City city = new City(name, region, district, population, foundation);

                res.add(city);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return res;
    }
}
