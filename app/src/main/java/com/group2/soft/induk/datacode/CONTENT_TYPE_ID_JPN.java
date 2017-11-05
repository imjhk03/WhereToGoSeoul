package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 22..
 */
public enum CONTENT_TYPE_ID_JPN {
    観光地(76),
    文化施設(78),
    祭り_公演_イベント(85),
    レジャースポーツ(75),
    宿泊(80),
    ショッピング(79),
    グルメ(82),
    交通(77);

    private int value;
    private static Map map = new HashMap<>();

    private CONTENT_TYPE_ID_JPN(int value) {
        this.value = value;
    }

    static {
        for (CONTENT_TYPE_ID_JPN content_type_id : CONTENT_TYPE_ID_JPN.values()) {
            map.put(content_type_id.value, content_type_id);
        }
    }

    public static CONTENT_TYPE_ID_JPN valueOf(int content_type_id) {
        return (CONTENT_TYPE_ID_JPN) map.get(content_type_id);
    }

    public int getValue() {
        return value;
    }
}
