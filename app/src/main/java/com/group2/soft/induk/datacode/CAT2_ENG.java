package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 22..
 */
public enum CAT2_ENG {
    A0101("Natural Sites"),
    A0102("Natural Resources"),
    A0201("Historical Sites"),
    A0202("Recreational Sites"),
    A0203("Experience Programs"),
    A0204("Industrial Sites"),
    A0205("Architectural Sights"),
    A0206("Cultural Facilities"),
    A0207("Festivals"),
    A0208("Events/Performances"),

    A0301("Introduction"),
    A0302("Leisure/Sports (Land)"),
    A0303("Leisure/Sports (Water)"),
    A0304("Leisure/Sports (Sky)"),
    A0305("Leisure/Sports (Others)"),

    B0201("Accommodations"),

    A0401("Shopping"),

    A0502("Restaurants"),

    B0102("Transportation Facilities");

    private String value;
    private static Map map = new HashMap<>();

    private CAT2_ENG(String value) {
        this.value = value;
    }

    static {
        for (CAT2_ENG cat2 : CAT2_ENG.values()) {
            map.put(cat2.value, cat2);
        }
    }

    public String getValue() {
        return value;
    }
}
