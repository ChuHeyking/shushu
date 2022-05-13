package com.chu.dao;

import com.chu.domain.Weapon;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FindDao<T> {

    @Select("select ${s1} from ${tableName} GROUP BY ${s1}")
    List<T> findType(@Param("s1") String s1,@Param("tableName") String tableName);

    @Select("select * from ${tableName} where 1=1 ${sqlString} limit #{index},#{per}")
    List<T> findSomeByCondition(@Param("index") Integer index,@Param("per") Integer per,@Param("sqlString") String sqlString,@Param("tableName") String tableName);

    @Select("select count(*) from ${tableName} where 1=1 ${sqlString}")
    Integer findCountByCondition(@Param("sqlString") String sqlString,@Param("tableName") String tableName);

}
