package com.chu.service.impl;

import com.chu.dao.RoleDao;
import com.chu.domain.Kv2;
import com.chu.domain.KvPageFather;
import com.chu.domain.Role;
import com.chu.domain.Weapon;
import com.chu.service.RoleService;
import com.chu.util.JedisPoolUtil;
import com.chu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Field;
import java.util.*;

@Service("roleService")
public class RoleServiceImpl extends FindServiceImpl<Role> {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Map<String, List<String>> findType(KvPageFather<Role> kvPageFather) {
        super.setFindDao(roleDao);
        return super.findType(kvPageFather);
    }

    @Override
    public KvPageFather<Role> findByCondition(KvPageFather<Role> kvPageFather) {
        super.setFindDao(roleDao);
        return super.findByCondition(kvPageFather);
    }

    /*    @Override
    public KvPageFather<Role> findByPage(KvPageFather<Role> kvPageFather) {
        *//*Integer count = roleDao.findCount();
        System.out.println(count);
        kv2.setTotalCount(count);
        double ceil = Math.ceil(((double) (count)) / ((double) (kv2.getPer())));
        kv2.setTotalPage((int)(ceil));
        if (kv2.getPage()<1 || kv2.getPage()>kv2.getTotalPage()){
            kv2.setPage(1);
        }
        Integer index = (kv2.getPage()-1)*kv2.getPer();
        kv2.setIndex(index);
        System.out.println(index);
        List<Role> roles = roleDao.findSome(index, kv2.getPer());
        kv2.setRoles(roles);
        return kv2;*//*
        Jedis jedis = JedisPoolUtil.getJedis();


        Integer count = roleDao.findCount();
        kvPageFather = new PageUtil<Role>().getKvPF(count, kvPageFather);
        List<Role> roles = roleDao.findSome(kvPageFather.getIndex(), kvPageFather.getPer());

        kvPageFather.setList(roles);
        return kvPageFather;
    }

    @Override
    public Map<String, List<String>> findType() {
        String[] strings = new String[]{"rarity", "weapontype", "elementtype", "gender", "area", "breakthrough"};
        Map<String, List<String>> map = new HashMap<>();

        Jedis jedis = JedisPoolUtil.getJedis();
        List<String> lrange;
        lrange = jedis.lrange("rarity", 0, -1);
        if (lrange == null || lrange.size() == 0) {


            for (String string : strings) {
                List<Role> list = roleDao.findType(string);
                List<String> list1 = new ArrayList<String>();
                for (Role role : list) {
                    Class<? extends Role> roleClass = role.getClass();
                    Field field = null;
                    try {
                        field = roleClass.getDeclaredField(string);
                        field.setAccessible(true);
                        String s = (String) field.get(role);
                        list1.add(s);

                        jedis.lpush(string, s);

                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                map.put(string, list1);
            }

            System.out.println("FirstUse");

        } else {


            for (String field : strings) {
                List<String> list = jedis.lrange(field, 0, -1);
                map.put(field, list);
            }
            System.out.println("redisUse");

        }

        return map;
    }


    @Override
    public KvPageFather<Role> findByCondition(KvPageFather<Role> kvPageFather) {
        Map<String, List<String>> selectMap = kvPageFather.getSelectMap();
        StringBuilder builder = new StringBuilder();
        for (String field : selectMap.keySet()) {
            builder.append("and " + field + " in (");
            *//*builder.append("and ");
            builder.append(field);
            builder.append(" in (");*//*
            List<String> list = selectMap.get(field);
            for (String value : list) {
                builder.append("'" + value + "',");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append(") ");
        }
        String sql = builder.toString();
        System.out.println(sql);

        Integer count = roleDao.findCountByCondition(sql);
        kvPageFather = new PageUtil<Role>().getKvPF(count, kvPageFather);
        List<Role> roles = roleDao.findSomeByCondition(kvPageFather.getIndex(), kvPageFather.getPer(), sql);
        kvPageFather.setList(roles);
        return kvPageFather;
    }*/

//    @Override
//    public Map<String, List<String>> findType() {
//        String[] strings = new String[]{"rarity", "weapontype", "elementtype", "gender", "area", "breakthrough"};
//        Map<String, List<String>> map = new HashMap<>();
//
//        Jedis jedis = JedisPoolUtil.getJedis();
//
//        for (String field : strings) {
//            List<String> list = jedis.lrange(field, 0, -1);
//            map.put(field, list);
//        }
//
//        if (map.get("rarity") == null || map.get("rarity").size() == 0) {
//            for (String string : strings) {
//                List<Role> list = roleDao.findType(string);
//                List<String> list1 = new ArrayList<String>();
//                for (Role role : list) {
//                    Class<? extends Role> roleClass = role.getClass();
//                    Field field = null;
//                    try {
//                        field = roleClass.getDeclaredField(string);
//                        field.setAccessible(true);
//                        String s = (String) field.get(role);
//                        list1.add(s);
//
//                        jedis.rpush(string, s);
//
//                    } catch (NoSuchFieldException e) {
//                        e.printStackTrace();
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
//                }
//                map.put(string, list1);
//            }
//            jedis.close();
//            System.out.println("FirstUse");
//
//        } else {
//            System.out.println("redisUse");
//        }
//
//        return map;
//    }
//
//    @Override
//    public KvPageFather<Role> findByCondition(KvPageFather<Role> kvPageFather) {
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
//        Integer count = roleDao.findCountByCondition(sql);
//        kvPageFather = new PageUtil<Role>().getKvPF(count, kvPageFather);
//        List<Role> roles = roleDao.findSomeByCondition(kvPageFather.getIndex(), kvPageFather.getPer(), sql);
//        kvPageFather.setList(roles);
//        return kvPageFather;
//    }


}
