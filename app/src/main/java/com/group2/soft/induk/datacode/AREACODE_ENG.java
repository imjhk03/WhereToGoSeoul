package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 22..
 * 지역코드조회
 */

public enum AREACODE_ENG {
    Seoul(1),
    Incheon(2),
    Daejeon(3),
    Daegu(4),
    Gwangju(5),
    Busan(6),
    Ulsan(7),
    Sejong(8),
    Gyeonggi_do(31),
    Gangwon_do(32),
    Chungcheongbuk_do(33),
    Chungcheongnam_do(34),
    Gyeongsangbuk_do(35),
    Gyeongsangnam_do(36),
    Jeollabuk_do(37),
    Jeollanam_do(38),
    Jeju_do(39);

    private int value;
    private static Map map = new HashMap<>();

    private AREACODE_ENG(int value) {
        this.value = value;
    }

    static {
        for (AREACODE_ENG areacode : AREACODE_ENG.values()) {
            map.put(areacode.value, areacode);
        }
    }

    public static AREACODE_ENG valueOf(int areacode) {
        return (AREACODE_ENG) map.get(areacode);
    }

    public int getValue() {
        return value;
    }
}
