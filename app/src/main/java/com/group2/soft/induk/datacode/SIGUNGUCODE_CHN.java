package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 22..
 */
public enum SIGUNGUCODE_CHN {
    江南区(1),
    江东区(2),
    江北区(3),
    江西区(4),
    冠岳区(5),
    广津区(6),
    九老区(7),
    衿川区(8),
    芦原区(9),
    道峰区(10),
    东大门区(11),
    铜雀区(12),
    麻浦区(13),
    西大门区(14),
    瑞草区(15),
    城东区(16),
    城北区(17),
    松坡区(18),
    阳川区(19),
    永登浦区(20),
    龙山区(21),
    恩平区(22),
    钟路区(23),
    中区(24),
    中浪区(25);

    private int value;
    private static Map map = new HashMap<>();

    private SIGUNGUCODE_CHN(int value) {
        this.value = value;
    }

    static {
        for (SIGUNGUCODE_CHN sigungucode : SIGUNGUCODE_CHN.values()) {
            map.put(sigungucode.value, sigungucode);
        }
    }

    public static SIGUNGUCODE_CHN valueOf(int sigungucode) {
        return (SIGUNGUCODE_CHN) map.get(sigungucode);
    }

    public int getValue() {
        return value;
    }
}
