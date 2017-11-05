package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 22..
 */
public enum CAT2_CHN {
    A0101("自然景点"),
    A0102("旅游资源"),
    A0201("历史景点"),
    A0202("休养胜地"),
    A0203("体验型旅游景点"),
    A0204("产业旅游景点"),
    A0205("建筑/造型物"),
    A0206("文化设施"),
    A0207("庆典"),
    A0208("公演/活动"),

    A0301("休闲运动介绍"),
    A0302("陆地休闲运动"),
    A0303("水上休闲运动"),
    A0304("空中休闲运动"),
    A0305("复合休闲运动"),

    B0201("住宿设施"),

    A0401("购物"),

    A0502("餐厅"),

    B0102("餐厅");

    private String value;
    private static Map map = new HashMap<>();

    private CAT2_CHN(String value) {
        this.value = value;
    }

    static {
        for (CAT2_CHN cat2 : CAT2_CHN.values()) {
            map.put(cat2.value, cat2);
        }
    }

    public String getValue() {
        return value;
    }
}
