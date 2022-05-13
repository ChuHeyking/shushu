package com.chu.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Kv3 implements Serializable {

    private List<Weapon> weapons;
    private Integer totalCount;
    private Integer totalPage;
    private Integer per;
    private Integer page;
    private Integer index;

    @Override
    public String toString() {
        return "Kv3{" +
                "weapons=" + weapons +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", per=" + per +
                ", page=" + page +
                ", index=" + index +
                '}';
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPer() {
        return per;
    }

    public void setPer(Integer per) {
        this.per = per;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
