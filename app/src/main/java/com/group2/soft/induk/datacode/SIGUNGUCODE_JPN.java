package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 22..
 */
public enum SIGUNGUCODE_JPN {
    江南区(1),
    江東区(2),
    江北区(3),
    江西区(4),
    冠岳区(5),
    広津区(6),
    九老区(7),
    衿川区(8),
    蘆原区(9),
    道峰区(10),
    東大門区(11),
    銅雀区(12),
    麻浦区(13),
    西大門区(14),
    瑞草区(15),
    城東区(16),
    城北区(17),
    松坡区(18),
    陽川区(19),
    永登浦区(20),
    龍山区(21),
    恩平区(22),
    鍾路区(23),
    中区(24),
    中浪区(25);

    private int value;
    private static Map map = new HashMap<>();

    private SIGUNGUCODE_JPN(int value) {
        this.value = value;
    }

    static {
        for (SIGUNGUCODE_JPN sigungucode : SIGUNGUCODE_JPN.values()) {
            map.put(sigungucode.value, sigungucode);
        }
    }

    public static SIGUNGUCODE_JPN valueOf(int sigungucode) {
        return (SIGUNGUCODE_JPN) map.get(sigungucode);
    }

    public int getValue() {
        return value;
    }
}
