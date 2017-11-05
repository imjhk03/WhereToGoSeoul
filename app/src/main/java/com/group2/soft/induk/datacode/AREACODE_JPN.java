package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 22..
 * 지역코드조회
 */

public enum AREACODE_JPN {
    ソウル特別市(1),
    仁川広域市(2),
    大田広域市(3),
    大邱広域市(4),
    光州広域市(5),
    釜山広域市(6),
    蔚山広域市(7),
    世宗特別自治市(8),
    京畿道(31),
    江原道(32),
    忠清北道(33),
    忠清南道(34),
    慶尚北道(35),
    慶尚南道(36),
    全羅北道(37),
    全羅南道(38),
    済州特別自治道(39);

    private int value;
    private static Map map = new HashMap<>();

    private AREACODE_JPN(int value) {
        this.value = value;
    }

    static {
        for (AREACODE_JPN areacode : AREACODE_JPN.values()) {
            map.put(areacode.value, areacode);
        }
    }

    public static AREACODE_JPN valueOf(int areacode) {
        return (AREACODE_JPN) map.get(areacode);
    }

    public int getValue() {
        return value;
    }
}
