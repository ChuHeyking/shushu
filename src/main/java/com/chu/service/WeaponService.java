package com.chu.service;

import com.chu.domain.Kv3;
import com.chu.domain.KvPageFather;
import com.chu.domain.Weapon;

import java.util.List;
import java.util.Map;

public interface WeaponService {

//    KvPageFather<Weapon> findByPage(KvPageFather<Weapon> kvPageFather);

    Map<String, List<String>> findType();

    KvPageFather<Weapon> findByCondition(KvPageFather<Weapon> kvPageFather);
}
