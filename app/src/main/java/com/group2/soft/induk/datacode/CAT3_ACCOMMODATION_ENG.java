package com.group2.soft.induk.datacode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JHK on 16. 8. 20..
 */
public enum CAT3_ACCOMMODATION_ENG {
    B02010100("Hotels (Modern)"),
    B02010200("Floating Hotels"),
    B02010300("Hotels (Traditional)"),
    B02010400("Hotels (Family)"),
    B02010500("Condominiums"),
    B02010600("Youth Hostels"),
    B02010700("Pensions"),
    B02010800("Inns"),
    B02010900("Motels"),
    B02011000("Private Rooms"),
    B02011100("Guest Houses"),
    B02011200("Home Stays"),
    B02011300("Serviced Residences");

    private String value;
    private static Map map = new HashMap<>();

    private CAT3_ACCOMMODATION_ENG(String value) {
        this.value = value;
    }

    static {
        for (CAT3_ACCOMMODATION_ENG cat3 : CAT3_ACCOMMODATION_ENG.values()) {
            map.put(cat3.value, cat3);
        }
    }

    public String getValue() {
        return value;
    }
}
