package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 20..
 */
public enum CAT3_ATTRACTIONS {
    A05020100("한식"),
    A05020200("서양식"),
    A05020300("일식"),
    A05020400("중식"),
    A05020500("아시아"),
    A05020600("패밀리레스토랑"),
    A05020700("이색음식점"),
    A05020800("채식전문점"),
    A05020900("바/까페"),
    A05021000("클럽");

    private String value;
    private static Map map = new HashMap<>();

    private CAT3_ATTRACTIONS(String value) {
        this.value = value;
    }

    static {
        for (CAT3_ATTRACTIONS cat3 : CAT3_ATTRACTIONS.values()) {
            map.put(cat3.value, cat3);
        }
    }

    public String getValue() {
        return value;
    }
}
