package com.chu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class KvPageFather<T> {

    private List<T> list;
    private Integer totalCount;
    private Integer totalPage;
    private Integer per;
    private Integer page;
    private Integer index;

    private Map<String,List<String>> typeMap;
    private Map<String,List<String>> selectMap;

    private String URI;

    private String[] fields;

    @Override
    public String toString() {
        return "KvPageFather{" +
                "list=" + list +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", per=" + per +
                ", page=" + page +
                ", index=" + index +
                ", typeMap=" + typeMap +
                ", selectMap=" + selectMap +
                ", URI='" + URI + '\'' +
                ", fields=" + Arrays.toString(fields) +
                '}';
    }

    public String[] getFields() {
        return fields;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

    public Map<String, List<String>> getSelectMap() {
        return selectMap;
    }

    public void setSelectMap(Map<String, List<String>> selectMap) {
        this.selectMap = selectMap;
    }

    public Map<String, List<String>> getTypeMap() {
        return typeMap;
    }

    public void setTypeMap(Map<String, List<String>> typeMap) {
        this.typeMap = typeMap;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
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
