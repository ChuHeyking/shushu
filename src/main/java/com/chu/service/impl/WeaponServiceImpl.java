package com.chu.service.impl;


import com.chu.dao.WeaponDao;
import com.chu.domain.KvPageFather;
import com.chu.domain.Role;
import com.chu.domain.Weapon;
import com.chu.domain.Kv3;
import com.chu.service.WeaponService;
import com.chu.util.JedisPoolUtil;
import com.chu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("weaponService")
public class WeaponServiceImpl extends FindServiceImpl<Weapon> {

    @Autowired
    private WeaponDao weaponDao;

    @Override
    public Map<String, List<String>> findType(KvPageFather<Weapon> kvPageFather) {
        super.setFindDao(weaponDao);
        return super.findType(kvPageFather);
    }

    @Override
    public KvPageFather<Weapon> findByCondition(KvPageFather<Weapon> kvPageFather) {
        super.setFindDao(weaponDao);
        return super.findByCondition(kvPageFather);
    }

    //    @Autowired
//    private WeaponDao weaponDao;
//
//    @Override
//    public Map<String, List<String>> findType() {
//        String[] fields= new String[]{"type","weaponRarity","access"};
//        Jedis jedis = JedisPoolUtil.getJedis();
//
//        Map<String, List<String>> typeMap = new HashMap<>();
//        for (String field : fields) {
//            List<String> lrange = jedis.lrange(field, 0, -1);
//            typeMap.put(field,lrange);
//        }
//        if (typeMap.get("type")==null || typeMap.get("type").size()==0){
//            for (String field : fields) {
//                List<Weapon> list = weaponDao.findType(field);
//                List<String> list1 = new ArrayList<>();
//                for (Weapon weapon : list) {
//                    try {
//                        Field declaredField = weapon.getClass().getDeclaredField(field);
//                        declaredField.setAccessible(true);
//                        String s= (String) declaredField.get(weapon);
//                        list1.add(s);
//                        jedis.rpush(field,s);
//                    } catch (NoSuchFieldException e) {
//                        e.printStackTrace();
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//                typeMap.put(field,list1);
//            }
//            System.out.println("firstUse");
//        }else {
//            System.out.println("redisUse");
//        }
//        return typeMap;
//    }
//
//    @Override
//    public KvPageFather<Weapon> findByCondition(KvPageFather<Weapon> kvPageFather) {
//        Map<String, List<String>> selectMap = kvPageFather.getSelectMap();
//        String sql = "";
//
//        if (selectMap==null || selectMap.size()==0){
//            sql = "";
//        }else {
//            StringBuilder builder = new StringBuilder();
//            for (String field : selectMap.keySet()) {
//                builder.append("and " + field + " in (");
//            /*builder.append("and ");
//            builder.append(field);
//            builder.append(" in (");*/
//                List<String> list = selectMap.get(field);
//                for (String value : list) {
//                    builder.append("'" + value + "',");
//                }
//                builder.deleteCharAt(builder.length() - 1);
//                builder.append(") ");
//            }
//            sql = builder.toString();
//            System.out.println(sql);
//        }
//
//        Integer count = weaponDao.findCountByCondition(sql);
//        kvPageFather = new PageUtil<Weapon>().getKvPF(count, kvPageFather);
//        List<Weapon> weapons = weaponDao.findSomeByCondition(kvPageFather.getIndex(), kvPageFather.getPer(), sql);
//        kvPageFather.setList(weapons);
//        return kvPageFather;
//    }

}
