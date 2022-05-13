package com.chu.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Role implements Serializable {

    private Integer id;
    private String name;
    private String rarity;
    private String weapontype;
    private String elementtype;
    private String gender;
    private String area;
    private Integer blood;
    private Integer attack;
    private Integer defense;
    private String breakthrough;
    private String description;
    private Integer bookid;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rarity='" + rarity + '\'' +
                ", weapontype='" + weapontype + '\'' +
                ", elementtype='" + elementtype + '\'' +
                ", gender='" + gender + '\'' +
                ", area='" + area + '\'' +
                ", blood=" + blood +
                ", attack=" + attack +
                ", defense=" + defense +
                ", breakthrough='" + breakthrough + '\'' +
                ", description='" + description + '\'' +
                ", bookid=" + bookid +
                '}';
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
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

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getWeapontype() {
        return weapontype;
    }

    public void setWeapontype(String weapontype) {
        this.weapontype = weapontype;
    }

    public String getElementtype() {
        return elementtype;
    }

    public void setElementtype(String elementtype) {
        this.elementtype = elementtype;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getBlood() {
        return blood;
    }

    public void setBlood(Integer blood) {
        this.blood = blood;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public String getBreakthrough() {
        return breakthrough;
    }

    public void setBreakthrough(String breakthrough) {
        this.breakthrough = breakthrough;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
