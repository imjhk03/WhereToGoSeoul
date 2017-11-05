package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 20..
 * 지역코드조회
 */

public enum AREACODE {
    서울특별시(1),
    인천(2),
    대전(3),
    대구(4),
    광주(5),
    부산(6),
    울산(7),
    세종특별자치시(8),
    경기도(31),
    강원도(32),
    충청북도(33),
    충청남도(34),
    경상북도(35),
    경상남도(36),
    전라북도(37),
    전라남도(38),
    제주도(39);

    private int value;
    private static Map map = new HashMap<>();

    private AREACODE(int value) {
        this.value = value;
    }

    static {
        for (AREACODE areacode : AREACODE.values()) {
            map.put(areacode.value, areacode);
        }
    }

    public static AREACODE valueOf(int areacode) {
        return (AREACODE) map.get(areacode);
    }

    public int getValue() {
        return value;
    }
}
