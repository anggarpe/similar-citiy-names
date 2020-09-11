package com.angpe.city;

import info.debatty.java.stringsimilarity.Damerau;
import info.debatty.java.stringsimilarity.JaroWinkler;
import info.debatty.java.stringsimilarity.Levenshtein;

public class Similarity {



    /**
     * Calculates the similarity (a number within 0 and 1) between two strings.
     */
    public static double Similar(String s1, String s2) {
        JaroWinkler jw = new JaroWinkler();
        Damerau d = new Damerau();
        Levenshtein l = new Levenshtein();

        String longer = s1, shorter = s2;
        if (s1.length() < s2.length()) { // longer should always have greater length
            longer = s2; shorter = s1;
        }
        int longerLength = longer.length();
        if (longerLength == 0) return 1.0; /* both strings are zero length */
        return (longerLength - EditDistance(longer, shorter)) / (double) longerLength;
//        return (longerLength - l.distance(longer, shorter)) / (double) longerLength;

    }

    // Example implementation of the Levenshtein Edit Distance
    // See http://r...content-available-to-author-only...e.org/wiki/Levenshtein_distance#Java
    public static int EditDistance(String s1, String s2) {
        s1 = s1.toLowerCase();//longer
        s2 = s2.toLowerCase();//shorter

        int[] costs = new int[s2.length() + 1];//make array with length shorter+1
        for (int i = 0; i <= s1.length(); i++) {//loop length longer
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {//loop length shorter
                if (i == 0) costs[j] = j; //first element array will assign value 0
                else lastValue = setLastValue(s1, s2, lastValue, costs, i, j);
            }
            if (i > 0) costs[s2.length()] = lastValue;//last index will assign lastValue
        }
        return costs[s2.length()];
    }

    public static int setLastValue(String s1, String s2, int lastValue, int[] costs, int i, int j){
        if (j > 0) {
            int newValue = costs[j - 1];//assign newValue with value before
            lastValue= swapValue(s1, s2, lastValue, newValue, costs, i, j);
        }
        return lastValue;
    }

    public static int swapValue(String s1, String s2, int lastValue, int newValue, int[] costs, int firstIndex, int secIndex){
        if (s1.charAt(firstIndex - 1) != s2.charAt(secIndex - 1))
            //find minimum of two integer
            newValue = Math.min(Math.min(newValue, lastValue), costs[secIndex]) + 1;
        costs[secIndex - 1] = lastValue;
        return newValue;
    }

}
