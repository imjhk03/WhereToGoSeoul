package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 22..
 */
public enum SIGUNGUCODE_ENG {
    Gangnam_gu(1),
    Gangdong_gu(2),
    Gangbuk_gu(3),
    Gangseo_gu(4),
    Gwanak_gu(5),
    Gwangjin_gu(6),
    Guro_gu(7),
    Geumcheon_gu(8),
    Nowon_gu(9),
    Dobong_gu(10),
    Dongdaemun_gu(11),
    Dongjak_gu(12),
    Mapo_gu(13),
    Seodaemun_gu(14),
    Seocho_gu(15),
    Seongdong_gu(16),
    Seongbuk_gu(17),
    Songpa_gu(18),
    Yangcheon_gu(19),
    Yeongdeungpo_gu(20),
    Yongsan_gu(21),
    Eunpyeong_gu(22),
    Jongno_gu(23),
    Jung_gu(24),
    Jungnang_gu(25);

    private int value;
    private static Map map = new HashMap<>();

    private SIGUNGUCODE_ENG(int value) {
        this.value = value;
    }

    static {
        for (SIGUNGUCODE_ENG sigungucode : SIGUNGUCODE_ENG.values()) {
            map.put(sigungucode.value, sigungucode);
        }
    }

    public static SIGUNGUCODE_ENG valueOf(int sigungucode) {
        return (SIGUNGUCODE_ENG) map.get(sigungucode);
    }

    public int getValue() {
        return value;
    }
}
