package com.bootcamp.manager;

import com.bootcamp.services.CityService;

import java.util.Map;
import java.util.Scanner;

public class Manager {
    public static void showMenu() {
        try (Scanner sc = new Scanner(System.in)) {
            showActions();
            String s;
            CityService cs = new CityService();

            while (!(s = sc.next()).equals("q")) {
                switch (s) {
                    case "1":
                        System.out.println("Список гродов:");
                        cs.getCities().forEach(System.out::println);
                        break;
                    case "2":
                        System.out.println("Сортировка по названию городов по убыванию:");
                        cs.sortByNameDescIgnoreCase().forEach(System.out::println);
                        break;
                    case "3":
                        System.out.println("Сортировка по федеральному округу и названию:");
                        cs.sortByDistrictAndNameDesc().forEach(System.out::println);
                        break;
                    case "4":
                        int[] maxPopulationData = cs.getMaxPopulationData();
                        System.out.println("Индекс города с наибольшим количеством жителей:");
                        System.out.printf("[%d] = %d\n", maxPopulationData[0], maxPopulationData[1]);
                        break;
                    case "5":
                        System.out.println("Количество городов в регионах:");
                        Map<String, Integer> regions = cs.getRegions();
                        for (String o : regions.keySet()) {
                            System.out.printf("%s - %d\n", o, regions.get(o));
                        }
                        break;
                    default:
                        System.out.println("Неизвестная команда");
                        break;
                }
            }
        }
    }

    private static void showActions() {
        System.out.println("1. Список городов");
        System.out.println("2. Сортировка списка городов по названию в алфавитном порядке по убыванию");
        System.out.println("3. Сортировка списка городов по федеральному округу и названию");
        System.out.println("4. Город с наибольшим количеством жителей");
        System.out.println("5. Количество городов в регионах");
        System.out.println("q. Выход");
    }
}
