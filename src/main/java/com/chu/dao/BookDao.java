package com.chu.dao;

import com.chu.domain.Book;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {

    @Select("select * from book where day like #{day} ")
    @Results(id = "bookMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "day",column = "day"),
            @Result(property = "roles",column = "id",many = @Many(select = "com.chu.dao.RoleDao.findByBookId",fetchType = FetchType.LAZY)),
    })
    List<Book> findAll(String day);

}
                    /*@Result(column = "",property = ""),
                    @Result(column = "",property = ""),*/



/*
@Results(id = "bookMap",value = {
        @Result(id = true,property = "id",column = "id"),
        @Result(property = "name",column = "name"),
        @Result(property = "day",column = "day"),
        @Result(property = "roleNames",column = "id",many = @Many(select = "com.chu.dao.RoleDao.findNamesByBookId",fetchType = FetchType.LAZY)),
})*/
