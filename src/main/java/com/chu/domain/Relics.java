package com.chu.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

public class Relics implements Serializable {
    private Integer id;
    private String name;
    private String lowestRarity;
    private String highestRarity;
    private String access;
    private String twoEffect;
    private String fourEffect;
    private String description;

    @Override
    public String toString() {
        return "Relics{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lowestRarity='" + lowestRarity + '\'' +
                ", highestRarity='" + highestRarity + '\'' +
                ", access='" + access + '\'' +
                ", twoEffect='" + twoEffect + '\'' +
                ", fourEffect='" + fourEffect + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

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

    public String getLowestRarity() {
        return lowestRarity;
    }

    public void setLowestRarity(String lowestRarity) {
        this.lowestRarity = lowestRarity;
    }

    public String getHighestRarity() {
        return highestRarity;
    }

    public void setHighestRarity(String highestRarity) {
        this.highestRarity = highestRarity;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getTwoEffect() {
        return twoEffect;
    }

    public void setTwoEffect(String twoEffect) {
        this.twoEffect = twoEffect;
    }

    public String getFourEffect() {
        return fourEffect;
    }

    public void setFourEffect(String fourEffect) {
        this.fourEffect = fourEffect;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
