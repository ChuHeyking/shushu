package com.chu.dao;

import com.chu.domain.Weapon;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataDao {

    @Select("select id,weaponRarity from weapon")
    List<Weapon> findWeapon();

    @Update("update weapon set weaponRarity=#{value} where id = #{id}")
    void updateWeaponRarityDeletePoint(@Param("id") Integer id, @Param("value") String value);
}
