package com.angpe.city;

import info.debatty.java.stringsimilarity.NormalizedLevenshtein;

import java.util.*;

public class City {
    public static void main(String[] args) {
        DataJson dj = new DataJson();
        List<String> cities = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String input = "";

        do{
            System.out.print("Enter city name, not have to be exact. (0 to exit): ");
            input = scanner.next();
            if(input.equals("0")){
                break;
            }
            for (String city : dj.City()){
                double indexValue = Similarity.Similar(input, city);
//                double indexValue = similarWithLibrary(input, city);
                addSimilarCities(indexValue, city, cities);
            }
            System.out.println(cities.toString());
            check();
            cities.clear();

        }while (true);

    }

    public  static double similarWithLibrary(String s1, String s2){
        NormalizedLevenshtein l = new NormalizedLevenshtein();
        return l.similarity(s1,s2);
    }

    public static void addSimilarCities(double index, String city, List<String> cities){
        if (checkIndex(index)) cities.add(city);
    }
    public static boolean checkIndex(double index){
        return index >= 0.56;
    }

    public static void check(){
        String s1 = "jakarta";
        String s2 = "jakarta";
        int lastValue = 2;
        int newValue = 3;
        int[] costs = {1, 2, 3, 4};
        int firstIndex = 1;
        int secIndex = 3;

        System.out.println(Similarity.swapValue(s1,s2,lastValue, newValue, costs,firstIndex,secIndex) + " swap");
        System.out.println(Similarity.setLastValue(s1,s2,lastValue, costs,firstIndex,secIndex)+ " set last");
    }
}
