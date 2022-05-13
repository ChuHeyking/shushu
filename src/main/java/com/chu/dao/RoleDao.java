package com.chu.dao;

import com.chu.domain.Kv2;
import com.chu.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao extends FindDao<Role>{

    @Select("select * from role where bookid = #{bookid}")
    List<Role> findByBookId(Integer bookid);

//    @Select("select ${s1} from role GROUP BY ${s1}")
//    List<Role> findType(@Param("s1") String s1);
//
//    @Select("select * from role where 1=1 ${sqlString} limit #{index},#{per}")
//    List<Role> findSomeByCondition(@Param("index") Integer index,@Param("per") Integer per,@Param("sqlString") String sqlString);
//
//    @Select("select count(*) from role where 1=1 ${sqlString}")
//    Integer findCountByCondition(@Param("sqlString") String sqlString);


/*    @Select("select r.name from role r where bookid = #{bookid}")
    List<String> findNamesByBookId(Integer bookid);*/

//    @Select("select * from role limit #{index},#{per}")
//    List<Role> findSome(@Param("index") Integer index,@Param("per") Integer per);
//
//    @Select("select count(*) from role")
//    Integer findCount();



//    @Select("select * from role where breakthrough like #{name}")
//    List<Role> findPlus(@Param("name") String name);
//
//    @Update("update role set breakthrough=#{breakthrough} where id=#{id}")
//    void updatePlus(Role role);
}
