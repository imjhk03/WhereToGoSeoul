package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 22..
 */
public enum CAT3_FOOD_ENG {
    A05020100("Korean Restaurants"),
    A05020200("Western Restaurants"),
    A05020300("Japanese Restaurants"),
    A05020400("Chinese Restaurants"),
    A05020500("Asian Restaurants"),
    A05020600("Family Restaurants"),
    A05020700("Unique Restaurants"),
    A05020800("Vegetarian Restaurants"),
    A05020900("Bars/Cafes"),
    A05021000("Clubs");

    private String value;
    private static Map map = new HashMap<>();

    private CAT3_FOOD_ENG(String value) {
        this.value = value;
    }

    static {
        for (CAT3_FOOD_ENG cat3 : CAT3_FOOD_ENG.values()) {
            map.put(cat3.value, cat3);
        }
    }

    public String getValue() {
        return value;
    }
}
