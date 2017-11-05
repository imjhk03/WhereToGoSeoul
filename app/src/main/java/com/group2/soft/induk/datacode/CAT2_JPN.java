package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 22..
 */
public enum CAT2_JPN {
    A0101("自然観光地"),
    A0102("観光資源"),
    A0201("歴史観光地"),
    A0202("休養観光地"),
    A0203("体験観光地"),
    A0204("産業観光地"),
    A0205("建築／オブジェ"),
    A0206("文化施設"),
    A0207("祭り"),
    A0208("公演／イベント"),

    A0301("レジャースポーツ紹介"),
    A0302("陸上レジャースポーツ"),
    A0303("水上レジャースポーツ"),
    A0304("空中レジャースポーツ"),
    A0305("複合レジャースポーツ"),

    B0201("宿泊施設"),

    A0401("ショッピング"),

    A0502("飲食店"),

    B0102("交通施設");

    private String value;
    private static Map map = new HashMap<>();

    private CAT2_JPN(String value) {
        this.value = value;
    }

    static {
        for (CAT2_JPN cat2 : CAT2_JPN.values()) {
            map.put(cat2.value, cat2);
        }
    }

    public String getValue() {
        return value;
    }
}
