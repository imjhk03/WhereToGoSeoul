package com.group2.soft.induk.model;

/**
 * Created by Lee Kyu Hwa on 2016-08-19.
 */
public class OneDetailDTO {
    private String title;
    private String homepage;
    private String overview;
    private String tel;
    private String telname;

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOverview() {
        return overview;
    }

    public void setTelname(String telname) {
        this.telname = telname;
    }

    public String getTelname() {
        return telname;
    }

}
