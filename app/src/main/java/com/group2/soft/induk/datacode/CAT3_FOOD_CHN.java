package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 22..
 */
public enum CAT3_FOOD_CHN {
    A05020100("韩式"),
    A05020200("西式"),
    A05020300("日式"),
    A05020400("中式"),
    A05020500("亚洲式"),
    A05020600("家庭式餐厅"),
    A05020700("特色饮食店"),
    A05020800("素食专门店"),
    A05020900("酒吧/咖啡厅"),
    A05021000("俱乐部");

    private String value;
    private static Map map = new HashMap<>();

    private CAT3_FOOD_CHN(String value) {
        this.value = value;
    }

    static {
        for (CAT3_FOOD_CHN cat3 : CAT3_FOOD_CHN.values()) {
            map.put(cat3.value, cat3);
        }
    }

    public String getValue() {
        return value;
    }
}
