package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 22..
 */
public enum CONTENT_TYPE_ID {
    관광(12),
    문화시(14),
    축제_공연_행사(15),
    여행코스(25),
    레포츠(28),
    숙박(32),
    쇼핑(38),
    음식(39);

    private int value;
    private static Map map = new HashMap<>();

    private CONTENT_TYPE_ID(int value) {
        this.value = value;
    }

    static {
        for (CONTENT_TYPE_ID content_type_id : CONTENT_TYPE_ID.values()) {
            map.put(content_type_id.value, content_type_id);
        }
    }

    public static CONTENT_TYPE_ID valueOf(int content_type_id) {
        return (CONTENT_TYPE_ID) map.get(content_type_id);
    }

    public int getValue() {
        return value;
    }
}
