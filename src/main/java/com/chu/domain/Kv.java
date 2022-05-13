package com.chu.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Kv implements Serializable {
    private String src;
    private List<Book> books;
    private String day;

    @Override
    public String toString() {
        return "Kv{" +
                "src='" + src + '\'' +
                ", books=" + books +
                ", day='" + day + '\'' +
                '}';
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    /*    @Override
    public String toString() {
        return "{" +
                "\"src\":\"" + src + '\"' +
                ",\"books\":" + books +
                '}';
    }*/

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
