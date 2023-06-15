package org.example;

import java.util.HashMap;

public class Calculator {
    private HashMap<String, Integer> hashMap = new HashMap<>();
    private String[] digits = new String[2];
    private boolean isArabic = true;
    private boolean isRomanian = false;
    private int excep = 0;
    private int i = 0;
    private int a;
    private int b;
    public void calcStart(String example) throws Exception {

        String[] arr =  example.split(" ");
        if(arr.length < 1 || arr.length > 3) throw new Exception("строка не является математической операцией ИЛИ ЖЕ формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        for (String c : arr) {
            try {
                Integer.parseInt(c);
            } catch (Exception e) {
                excep++;
            }
        }
        if(excep == 2) throw new Exception("используются одновременно разные системы счисления");
        if(excep == 3) {
            isRomanian = true;
            createRomanian();
            a = hashMap.get(arr[0]);
            b = hashMap.get(arr[2]);
            chooseOperation(arr[1]);
        } else {
            a = Integer.parseInt(arr[0]);
            b = Integer.parseInt(arr[2]);
            chooseOperation(arr[1]);
        }


    }
        public void chooseOperation(String oper) throws Exception {
            switch(oper){
                case "+":
                    sum(a, b);
                    break;
                case "-":
                   minus(a, b);
                    break;
                case "*":
                    umnojenie(a, b);
                    break;
                case "/":
                    divide(a, b);
                    break;
                default:
                    System.out.println("There is no operation");
            }

        }
        public void sum(int a, int b){
            int result = a + b;
            if(isRomanian) {
                for(String key : hashMap.keySet()){
                    Integer value = hashMap.get(key);
                    if(value == result){
                        System.out.println(key);
                    }
                }
            } else {
                System.out.println(result);
            }
        }
        public void minus(int a, int b) throws Exception {
            int result = a - b;
            if(isRomanian) {
                if(result <= 0) throw new Exception("There is no zero in Romanian");
                for(String key : hashMap.keySet()){
                    Integer value = hashMap.get(key);
                    if(value == result){
                        System.out.println(key);
                    }
                }
            } else {
                System.out.println(result);
            }
        }
        public void divide(int a, int b){
            int result = a / b;
            if(isRomanian) {
                for(String key : hashMap.keySet()){
                    Integer value = hashMap.get(key);
                    if(value == result){
                        System.out.println(key);
                    }
                }
            } else {
                System.out.println(result);
            }
        }
         public void umnojenie(int a, int b){
             int result = a * b;
             if(isRomanian) {
                 for(String key : hashMap.keySet()){
                     Integer value = hashMap.get(key);
                     if(value == result){
                         System.out.println(key);
                     }
                 }
             } else {
                 System.out.println(result);
             }
         }


      private void createRomanian(){
        hashMap.put("I", 1);
        hashMap.put("II", 2);
        hashMap.put("III", 3);
        hashMap.put("IV", 4);
        hashMap.put("V", 5);
        hashMap.put("VI", 6);
        hashMap.put("VII", 7);
        hashMap.put("VIII", 8);
        hashMap.put("IX", 9);
        hashMap.put("X", 10);
        hashMap.put("XI", 11);
        hashMap.put("XII", 12);
        hashMap.put("XIII", 13);
        hashMap.put("XIV", 14);
        hashMap.put("XV", 15);
        hashMap.put("XVI", 16);
        hashMap.put("XVII", 17);
        hashMap.put("XVIII", 18);
        hashMap.put("XIX", 19);
        hashMap.put("XX", 20);
      }

        public String find(int result){
            for(String key : hashMap.keySet()){
                Integer value = hashMap.get(key);
                if(value == result){
                    return key;
                }
            }
            return "";
        }




}
