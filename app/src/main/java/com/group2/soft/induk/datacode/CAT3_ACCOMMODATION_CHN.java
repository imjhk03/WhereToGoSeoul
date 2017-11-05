package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 20..
 */
public enum CAT3_ACCOMMODATION_CHN {
    B02010100("观光酒店"),
    B02010200("水上观光酒店"),
    B02010300("传统酒店"),
    B02010400("家庭酒店"),
    B02010500("公寓式酒店"),
    B02010600("青年旅馆"),
    B02010700("别墅"),
    B02010800("旅馆"),
    B02010900("汽车旅馆"),
    B02011000("民宿"),
    B02011100("客房旅馆"),
    B02011200("家庭寄宿"),
    B02011300("住宅式酒店");

    private String value;
    private static Map map = new HashMap<>();

    private CAT3_ACCOMMODATION_CHN(String value) {
        this.value = value;
    }

    static {
        for (CAT3_ACCOMMODATION_CHN cat3 : CAT3_ACCOMMODATION_CHN.values()) {
            map.put(cat3.value, cat3);
        }
    }

    public String getValue() {
        return value;
    }
}
