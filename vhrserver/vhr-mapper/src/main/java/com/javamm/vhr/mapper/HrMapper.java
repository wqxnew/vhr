package com.javamm.vhr.mapper;

import com.javamm.vhr.model.Hr;
import com.javamm.vhr.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);

    List<Role> getHrRolesById(Integer id);

    List<Hr> getAllHr(@Param("keywords") String keywords,@Param("hrid") Integer hrid);

    List<Hr> getAllHrWithoutHrSelf(Integer id);
}