package com.chu.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Arrays;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Calculate implements Serializable {
    private String damageType;

    private double attack;
    private double skill;
    private double plus;

    private double[] pluss;
    private double[] multiples;
    private double[] resistanceCuts;

    private double multiple;
    private double enemyLv;
    private double roleLv;
    private double defenseCut;
    private double enemyResistance;
    private double resistanceCut;
    private double criticalDamageRate;
    private double elementProficiency;

    private double normalDamage;
    private double criticalDamage;

    @Override
    public String toString() {
        return "Calculate{" +
                "damageType='" + damageType + '\'' +
                ", attack=" + attack +
                ", skill=" + skill +
                ", plus=" + plus +
                ", pluss=" + Arrays.toString(pluss) +
                ", multiples=" + Arrays.toString(multiples) +
                ", resistanceCuts=" + Arrays.toString(resistanceCuts) +
                ", multiple=" + multiple +
                ", enemyLv=" + enemyLv +
                ", roleLv=" + roleLv +
                ", defenseCut=" + defenseCut +
                ", enemyResistance=" + enemyResistance +
                ", resistanceCut=" + resistanceCut +
                ", criticalDamageRate=" + criticalDamageRate +
                ", elementProficiency=" + elementProficiency +
                ", normalDamage=" + normalDamage +
                ", criticalDamage=" + criticalDamage +
                '}';
    }

    public double[] getPluss() {
        return pluss;
    }

    public void setPluss(double[] pluss) {
        this.pluss = pluss;
    }

    public double[] getMultiples() {
        return multiples;
    }

    public void setMultiples(double[] multiples) {
        this.multiples = multiples;
    }

    public double[] getResistanceCuts() {
        return resistanceCuts;
    }

    public void setResistanceCuts(double[] resistanceCuts) {
        this.resistanceCuts = resistanceCuts;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public double getElementProficiency() {
        return elementProficiency;
    }

    public void setElementProficiency(double elementProficiency) {
        this.elementProficiency = elementProficiency;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getSkill() {
        return skill;
    }

    public void setSkill(double skill) {
        this.skill = skill;
    }

    public double getPlus() {
        return plus;
    }

    public void setPlus(double plus) {
        this.plus = plus;
    }

    public double getMultiple() {
        return multiple;
    }

    public void setMultiple(double multiple) {
        this.multiple = multiple;
    }

    public double getEnemyLv() {
        return enemyLv;
    }

    public void setEnemyLv(double enemyLv) {
        this.enemyLv = enemyLv;
    }

    public double getRoleLv() {
        return roleLv;
    }

    public void setRoleLv(double roleLv) {
        this.roleLv = roleLv;
    }

    public double getDefenseCut() {
        return defenseCut;
    }

    public void setDefenseCut(double defenseCut) {
        this.defenseCut = defenseCut;
    }

    public double getEnemyResistance() {
        return enemyResistance;
    }

    public void setEnemyResistance(double enemyResistance) {
        this.enemyResistance = enemyResistance;
    }

    public double getResistanceCut() {
        return resistanceCut;
    }

    public void setResistanceCut(double resistanceCut) {
        this.resistanceCut = resistanceCut;
    }

    public double getCriticalDamageRate() {
        return criticalDamageRate;
    }

    public void setCriticalDamageRate(double criticalDamageRate) {
        this.criticalDamageRate = criticalDamageRate;
    }

    public double getNormalDamage() {
        return normalDamage;
    }

    public void setNormalDamage(double normalDamage) {
        this.normalDamage = normalDamage;
    }

    public double getCriticalDamage() {
        return criticalDamage;
    }

    public void setCriticalDamage(double criticalDamage) {
        this.criticalDamage = criticalDamage;
    }
}
