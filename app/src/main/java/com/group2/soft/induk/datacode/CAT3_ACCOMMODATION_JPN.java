package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 20..
 */
public enum CAT3_ACCOMMODATION_JPN {
    B02010100("観光ホテル"),
    B02010200("水上観光ホテル"),
    B02010300("伝統ホテル"),
    B02010400("家族ホテル"),
    B02010500("コンドミニアム"),
    B02010600("ユースホステル"),
    B02010700("ペンション"),
    B02010800("旅館"),
    B02010900("モーテル"),
    B02011000("民宿"),
    B02011100("ゲストハウス"),
    B02011200("ホームステイ"),
    B02011300("レジデンス");

    private String value;
    private static Map map = new HashMap<>();

    private CAT3_ACCOMMODATION_JPN(String value) {
        this.value = value;
    }

    static {
        for (CAT3_ACCOMMODATION_JPN cat3 : CAT3_ACCOMMODATION_JPN.values()) {
            map.put(cat3.value, cat3);
        }
    }

    public String getValue() {
        return value;
    }
}
