package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 22..
 */
public enum CONTENT_TYPE_ID_ENG {
    Tourist_Attractions(76),
    Cultural_Facilities(78),
    Festivals_Events_Performances(85),
    Leisure_Sports(75),
    Accommodation(80),
    Shopping(79),
    Dining(82),
    Transportation(77);

    private int value;
    private static Map map = new HashMap<>();

    private CONTENT_TYPE_ID_ENG(int value) {
        this.value = value;
    }

    static {
        for (CONTENT_TYPE_ID_ENG content_type_id : CONTENT_TYPE_ID_ENG.values()) {
            map.put(content_type_id.value, content_type_id);
        }
    }

    public static CONTENT_TYPE_ID_ENG valueOf(int content_type_id) {
        return (CONTENT_TYPE_ID_ENG) map.get(content_type_id);
    }

    public int getValue() {
        return value;
    }
}
