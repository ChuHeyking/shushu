package com.chu.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Weapon implements Serializable {
    private Integer id;
    private String name;
    private String type;
    private String weaponRarity;
    private String access;
    private double initialAttack;
    private String initialAttribute;
    private double fullAttack;
    private String fullAttribute;
    private String skill;

    @Override
    public String toString() {
        return "Weapon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", weaponRarity='" + weaponRarity + '\'' +
                ", access='" + access + '\'' +
                ", initialAttack=" + initialAttack +
                ", initialAttribute='" + initialAttribute + '\'' +
                ", fullAttack=" + fullAttack +
                ", fullAttribute='" + fullAttribute + '\'' +
                ", skill='" + skill + '\'' +
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeaponRarity() {
        return weaponRarity;
    }

    public void setWeaponRarity(String weaponRarity) {
        this.weaponRarity = weaponRarity;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public double getInitialAttack() {
        return initialAttack;
    }

    public void setInitialAttack(double initialAttack) {
        this.initialAttack = initialAttack;
    }

    public String getInitialAttribute() {
        return initialAttribute;
    }

    public void setInitialAttribute(String initialAttribute) {
        this.initialAttribute = initialAttribute;
    }

    public double getFullAttack() {
        return fullAttack;
    }

    public void setFullAttack(double fullAttack) {
        this.fullAttack = fullAttack;
    }

    public String getFullAttribute() {
        return fullAttribute;
    }

    public void setFullAttribute(String fullAttribute) {
        this.fullAttribute = fullAttribute;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
