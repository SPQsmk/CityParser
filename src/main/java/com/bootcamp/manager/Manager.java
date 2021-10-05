package com.bootcamp.manager;

import java.util.Scanner;

public class Manager {
    public static void showMenu() {
        try (Scanner sc = new Scanner(System.in)) {
            showActions();
            String s;
            while (!(s = sc.next()).equals("q")) {
                switch (s) {
                    case "1":
                        System.out.println(1);
                        break;
                    case "2":
                        System.out.println(2);
                        break;
                    case "3":
                        System.out.println(3);
                        break;
                    case "4":
                        System.out.println(4);
                        break;
                    case "5":
                        System.out.println(5);
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
