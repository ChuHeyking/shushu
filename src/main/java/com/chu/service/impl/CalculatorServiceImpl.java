package com.chu.service.impl;

import com.chu.domain.Calculate;
import com.chu.service.CalculatorService;
import org.springframework.objenesis.instantiator.android.Android10Instantiator;
import org.springframework.stereotype.Service;

@Service("calculatorService")
public class CalculatorServiceImpl implements CalculatorService {

    /*@Override
    public Calculate easyCalculate(Calculate calculate) {
        double dNo = d5(calculate);
        double dYes = d6(dNo, calculate.getCriticalDamageRate());
        double proficiencyMultiple = 0;
        String damageType = calculate.getDamageType();
        if (damageType.equals("amplification1")) {
            proficiencyMultiple = getProficiencyMultipleZengFu(calculate.getElementProficiency())*1.15;
            System.out.println(proficiencyMultiple);
            dNo = getFanYing(dNo, 1.5, proficiencyMultiple);
            dYes = getFanYing(dYes, 1.5, proficiencyMultiple);
        } else if (damageType.equals("amplification2")) {
            proficiencyMultiple = getProficiencyMultipleZengFu(calculate.getElementProficiency());
            dNo = getFanYing(dNo, 2, proficiencyMultiple);
            dYes = getFanYing(dYes, 2, proficiencyMultiple);
        } else if (damageType.equals("upheaval")) {
            proficiencyMultiple = getProficiencyMultipleJuBian(calculate.getElementProficiency());
            dNo = dJuBian(calculate);
            dNo = getFanYing(dNo, 1, proficiencyMultiple);
            dYes = dNo;
        } else {

        }
        calculate.setNormalDamage(dNo);
        calculate.setCriticalDamage(dYes);
        return calculate;
    }

    public double d5(Calculate calculate) {
        double d2 = Math.floor(calculate.getAttack() * calculate.getSkill() * 0.01) - 1 + 1;
        double d3 = d2 + calculate.getPlus();
        double d1 = Math.floor(d3 * (calculate.getMultiple() * 0.01 + 1)) - 1 + 1;
        double afterDefense = (100 + calculate.getRoleLv()) / ((1 - calculate.getDefenseCut()) * (100 + calculate.getEnemyLv()) + 100 + calculate.getRoleLv());
        double d4 = Math.floor(d1 * afterDefense) - 1 + 1;
        double er = calculate.getEnemyResistance() - calculate.getResistanceCut();
        double ee = ee(er);
        double d5 = Math.floor(d4 * ee) - 1 + 1;
        return d5;
    }

    public double dJuBian(Calculate calculate) {
        double d2 = Math.floor(calculate.getAttack() * calculate.getSkill() * 0.01) - 1 + 1;
        double d3 = d2 + calculate.getPlus();
        double d1 = Math.floor(d3 * (calculate.getMultiple() * 0.01 + 1)) - 1 + 1;
        double d4 = d1;
        double er = calculate.getEnemyResistance() - calculate.getResistanceCut();
        double ee = ee(er);
        double d5 = Math.floor(d4 * ee) - 1 + 1;
        return d5;
    }

    public double ee(double er) {
        double ee = 0;
        if (er < 0) {
            ee = 1 - er * 0.01 / 2;
        } else if (er < 75) {
            ee = 1 - er * 0.01;
        } else {
            ee = 1 / (4 * er * 0.01 + 1);
        }
        return ee;
    }

    public double d6(double d, double criticalDamageRate) {
        return Math.floor(d * (1 + criticalDamageRate * 0.01)) - 1 + 1;
    }

    public double getProficiencyMultipleZengFu(double d) {
        return (d * 278 / (d + 1400)) * 0.01;
    }

    public double getProficiencyMultipleJuBian(double d) {
        return (d * 667 / (d + 1400)) * 0.01;
    }

    public double getFanYing(double d, double times, double proficiencyMultiple) {
        return Math.floor(d * times * (1 + proficiencyMultiple));
    }*/

    @Override
    public Calculate easyCalculate(Calculate calculate) {
        if (calculate.getPluss() != null && calculate.getPluss().length >= 2) {
            calculate.setPlus(sum(calculate.getPluss()));
        }
        if (calculate.getMultiples() != null && calculate.getMultiples().length >= 2) {
            calculate.setMultiple(sum(calculate.getMultiples()));
        }
        if (calculate.getResistanceCuts() != null && calculate.getResistanceCuts().length >= 2) {
            calculate.setResistanceCut(sum(calculate.getResistanceCuts()));
        }
        double dNo = d5(calculate);
        double dYes = d6(dNo, calculate.getCriticalDamageRate());
        double proficiencyMultiple = 0;
        String damageType = calculate.getDamageType();
        if (damageType.equals("amplification1")) {
            proficiencyMultiple = getProficiencyMultipleZengFu(calculate.getElementProficiency());
            System.out.println(proficiencyMultiple);
            dNo = getFanYing(dNo, 1.5, proficiencyMultiple);
            dYes = getFanYing(dYes, 1.5, proficiencyMultiple);
        } else if (damageType.equals("amplification2")) {
            proficiencyMultiple = getProficiencyMultipleZengFu(calculate.getElementProficiency());
            dNo = getFanYing(dNo, 2, proficiencyMultiple);
            dYes = getFanYing(dYes, 2, proficiencyMultiple);
        } else if (damageType.equals("upheaval")) {
            proficiencyMultiple = getProficiencyMultipleJuBian(calculate.getElementProficiency());
            dNo = dJuBian(calculate);
            dNo = getFanYing(dNo, 1, proficiencyMultiple);
            dYes = dNo;
        } else {

        }
        calculate.setNormalDamage(dNo);
        calculate.setCriticalDamage(dYes);
        return calculate;
    }

    public double sum(double[] ds) {
        double sum = 0;
        for (double d : ds) {
            sum += d;
        }
        return sum;
    }

    public double d5(Calculate calculate) {
        double d2 = calculate.getAttack() * calculate.getSkill() * 0.01;
        double d3 = d2 + calculate.getPlus();
        double d1 = d3 * (calculate.getMultiple() * 0.01 + 1);
        double afterDefense = (100 + calculate.getRoleLv()) / ((1 - calculate.getDefenseCut()) * (100 + calculate.getEnemyLv()) + 100 + calculate.getRoleLv());
        double d4 = d1 * afterDefense;
        double er = calculate.getEnemyResistance() - calculate.getResistanceCut();
        double ee = ee(er);
        double d5 = d4 * ee;
        return Math.floor(d5);
    }

    public double dJuBian(Calculate calculate) {
        double d2 = calculate.getAttack() * calculate.getSkill() * 0.01;
        double d3 = d2 + calculate.getPlus();
        double d1 = d3 * (calculate.getMultiple() * 0.01 + 1);
        double d4 = d1;
        double er = calculate.getEnemyResistance() - calculate.getResistanceCut();
        double ee = ee(er);
        double d5 = d4 * ee;
        return d5;
    }

    public double ee(double er) {
        double ee = 0;
        if (er < 0) {
            ee = 1 - er * 0.01 / 2;
        } else if (er < 75) {
            ee = 1 - er * 0.01;
        } else {
            ee = 1 / (4 * er * 0.01 + 1);
        }
        return ee;
    }

    public double d6(double d, double criticalDamageRate) {
        return Math.floor(d * (1 + criticalDamageRate * 0.01));
    }

    public double getProficiencyMultipleZengFu(double d) {
        return (d * 278 / (d + 1400)) * 0.01;
    }

    public double getProficiencyMultipleJuBian(double d) {
        return (d * 667 / (d + 1400)) * 0.01;
    }

    public double getFanYing(double d, double times, double proficiencyMultiple) {
        return Math.floor(d * times * (1 + proficiencyMultiple));
    }
}
