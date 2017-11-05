package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 22..
 */
public enum CONTENT_TYPE_ID_CHN {
    旅游景点(76),
    文化设施(78),
    庆典_公演_活动(85),
    休闲运动(75),
    住宿(80),
    购物(79),
    饮食(82),
    交通(77);

    private int value;
    private static Map map = new HashMap<>();

    private CONTENT_TYPE_ID_CHN(int value) {
        this.value = value;
    }

    static {
        for (CONTENT_TYPE_ID_CHN content_type_id : CONTENT_TYPE_ID_CHN.values()) {
            map.put(content_type_id.value, content_type_id);
        }
    }

    public static CONTENT_TYPE_ID_CHN valueOf(int content_type_id) {
        return (CONTENT_TYPE_ID_CHN) map.get(content_type_id);
    }

    public int getValue() {
        return value;
    }
}
