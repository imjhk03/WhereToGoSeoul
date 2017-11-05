package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 22..
 */
public enum CAT3_FOOD_JPN {
    A05020100("韓国料理"),
    A05020200("西洋料理"),
    A05020300("日本料理"),
    A05020400("中華料理"),
    A05020500("アジア料理"),
    A05020600("ファミリーレストラン"),
    A05020700("テーマレストラン"),
    A05020800("ベジタリアンレストラン"),
    A05020900("バー／カフェ"),
    A05021000("クラブ");

    private String value;
    private static Map map = new HashMap<>();

    private CAT3_FOOD_JPN(String value) {
        this.value = value;
    }

    static {
        for (CAT3_FOOD_JPN cat3 : CAT3_FOOD_JPN.values()) {
            map.put(cat3.value, cat3);
        }
    }

    public String getValue() {
        return value;
    }
}
