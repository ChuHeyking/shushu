package com.chu.dao;

import com.chu.domain.Role;
import com.chu.domain.Weapon;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeaponDao extends FindDao<Weapon>{

//    @Select("select ${s1} from weapon GROUP BY ${s1}")
//    List<Weapon> findType(@Param("s1") String s1);
//
//    @Select("select * from weapon where 1=1 ${sqlString} limit #{index},#{per}")
//    List<Weapon> findSomeByCondition(@Param("index") Integer index,@Param("per") Integer per,@Param("sqlString") String sqlString);
//
//    @Select("select count(*) from weapon where 1=1 ${sqlString}")
//    Integer findCountByCondition(@Param("sqlString") String sqlString);

}
