package org.example;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите цифры для подсчёта: -> ");
        String scanResult = scan.nextLine();

        try {
            calc.calcStart(scanResult);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}