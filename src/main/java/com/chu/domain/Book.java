package com.chu.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Book implements Serializable {

    private Integer id;
    private String name;
    private String day;
    //private List<String> roleNames;

    private List<Role> roles;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", day='" + day + '\'' +
                ", roles=" + roles +
                '}';
    }


/*    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ",\"name\":\"" + name + '\"' +
                ",\"day\":\"" + day + '\"' +
                ",\"roleNames\":" + roleNames +
                '}';
    }*/


/*    public List<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

        public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
