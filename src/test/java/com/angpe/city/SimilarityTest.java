package com.angpe.city;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityTest {

    String s1 = "jakarta";
    String s2 = "jakarta";
    int lastValue = 2;
    int newValue = 3;
    int[] costs = {1, 2, 3, 4};
    int firstIndex = 1;
    int secIndex = 3;

    @Test
    void similar() {
        assertEquals(1.0, Similarity.Similar("jakarta", "jakarta"));
    }

    @Test
    void editDistance() {
        assertEquals(0, Similarity.EditDistance("jakarta", "jakarta"));
    }

    @Test
    void setLastValue() {
        assertEquals(3, Similarity.setLastValue(s1,s2,lastValue, costs,firstIndex,secIndex));
    }

    @Test
    void swapValue() {
        assertEquals(3, Similarity.swapValue(s1,s2,lastValue, newValue, costs,firstIndex,secIndex));
    }
}