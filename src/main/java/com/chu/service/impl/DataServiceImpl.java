package com.chu.service.impl;

import com.chu.dao.DataDao;
import com.chu.domain.Weapon;
import com.chu.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dataService")
public class DataServiceImpl implements DataService {

    @Autowired
    private DataDao dataDao;

    @Override
    public void update1() {
        List<Weapon> weapons = dataDao.findWeapon();
        for (Weapon weapon : weapons) {
            String weaponRarity = weapon.getWeaponRarity();
            String[] split = weaponRarity.split("\\.");
            String xin = split[0]+"星";
            dataDao.updateWeaponRarityDeletePoint(weapon.getId(),xin);
        }
        System.out.println("11111111111111");
    }
}
