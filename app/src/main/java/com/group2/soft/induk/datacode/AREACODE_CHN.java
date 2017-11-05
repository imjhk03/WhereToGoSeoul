package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 22..
 * 지역코드조회
 */

public enum AREACODE_CHN {
    首尔特別市(1),
    仁川广域市(2),
    大田广域市(3),
    大邱广域市(4),
    光州广域市(5),
    釜山广域市(6),
    蔚山广域市(7),
    世宗市(8),
    京畿道(31),
    江原道(32),
    忠清北道(33),
    忠清南道(34),
    庆尚北道(35),
    庆尚南道(36),
    全罗北道(37),
    全罗南道(38),
    济州道(39);

    private int value;
    private static Map map = new HashMap<>();

    private AREACODE_CHN(int value) {
        this.value = value;
    }

    static {
        for (AREACODE_CHN areacode : AREACODE_CHN.values()) {
            map.put(areacode.value, areacode);
        }
    }

    public static AREACODE_CHN valueOf(int areacode) {
        return (AREACODE_CHN) map.get(areacode);
    }

    public int getValue() {
        return value;
    }
}
