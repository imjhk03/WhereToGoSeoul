package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 20..
 */
public enum SIGUNGUCODE {
    강남구(1),
    강동구(2),
    강북구(3),
    강서구(4),
    관악구(5),
    광진구(6),
    구로구(7),
    금천구(8),
    노원구(9),
    도봉구(10),
    동대문구(11),
    동작구(12),
    마포구(13),
    서대문구(14),
    서초구(15),
    성동구(16),
    성북구(17),
    송파구(18),
    양천구(19),
    영등포구(20),
    용산구(21),
    은평구(22),
    종로구(23),
    중구(24),
    중랑구(25);

    private int value;
    private static Map map = new HashMap<>();

    private SIGUNGUCODE(int value) {
        this.value = value;
    }

    static {
        for (SIGUNGUCODE sigungucode : SIGUNGUCODE.values()) {
            map.put(sigungucode.value, sigungucode);
        }
    }

    public static SIGUNGUCODE valueOf(int sigungucode) {
        return (SIGUNGUCODE) map.get(sigungucode);
    }

    public int getValue() {
        return value;
    }
}
