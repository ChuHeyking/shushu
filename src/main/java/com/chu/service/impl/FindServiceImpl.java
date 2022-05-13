package com.chu.service.impl;

import com.chu.dao.FindDao;
import com.chu.domain.KvPageFather;
import com.chu.service.FindService;
import com.chu.util.JedisPoolUtil;
import com.chu.util.PageUtil;
import redis.clients.jedis.Jedis;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FindServiceImpl<T> implements FindService<T> {
    private FindDao<T> findDao;

    public FindDao<T> getFindDao() {
        return findDao;
    }

    public void setFindDao(FindDao<T> findDao) {
        this.findDao = findDao;
    }


    @Override
    public Map<String, List<String>> findType(KvPageFather<T> kvPageFather) {
        String[] fields = kvPageFather.getFields();
        Jedis jedis = JedisPoolUtil.getJedis();

        Map<String, List<String>> typeMap = new HashMap<>();
        for (String field : fields) {
            List<String> lrange = jedis.lrange(field, 0, -1);
            typeMap.put(field, lrange);
        }
        if (typeMap.get(fields[0]) == null || typeMap.get(fields[0]).size() == 0) {

            String uri = kvPageFather.getURI();
            String[] split = uri.split("\\/");
            String tableName = split[split.length - 1];

            for (String field : fields) {


                List<T> list = findDao.findType(field, tableName);
                List<String> list1 = new ArrayList<>();
                for (T t : list) {
                    try {
                        Field declaredField = t.getClass().getDeclaredField(field);
                        declaredField.setAccessible(true);
                        String s = (String) declaredField.get(t);
                        list1.add(s);
                        jedis.rpush(field, s);
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                typeMap.put(field, list1);
            }
            System.out.println("firstUse");
        } else {
            System.out.println("redisUse");
        }
        return typeMap;
    }

    @Override
    public KvPageFather<T> findByCondition(KvPageFather<T> kvPageFather) {
        Map<String, List<String>> selectMap = kvPageFather.getSelectMap();
        String sql = "";

        if (selectMap == null || selectMap.size() == 0) {
            sql = "";
        } else {
            StringBuilder builder = new StringBuilder();
            for (String field : selectMap.keySet()) {
                builder.append("and " + field + " in (");
            /*builder.append("and ");
            builder.append(field);
            builder.append(" in (");*/
                List<String> list = selectMap.get(field);
                for (String value : list) {
                    builder.append("'" + value + "',");
                }
                builder.deleteCharAt(builder.length() - 1);
                builder.append(") ");
            }
            sql = builder.toString();
            System.out.println(sql);
        }

        String uri = kvPageFather.getURI();
        String[] split = uri.split("\\/");
        String tableName = split[split.length - 1];

        Integer count = findDao.findCountByCondition(sql, tableName);
        kvPageFather = new PageUtil<T>().getKvPF(count, kvPageFather);
        List<T> ts = findDao.findSomeByCondition(kvPageFather.getIndex(), kvPageFather.getPer(), sql, tableName);
        kvPageFather.setList(ts);
        return kvPageFather;
    }

}
