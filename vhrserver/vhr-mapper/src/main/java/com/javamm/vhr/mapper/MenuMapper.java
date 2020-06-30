package com.javamm.vhr.mapper;

import com.javamm.vhr.model.Menu;
import com.javamm.vhr.model.Role;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getMenuByHrId(Integer hrId);

    List<Menu> getAllMenusWithRole();

    List<Menu> getAllMenus();

    List<Integer> getRole_Menus(Integer rid);
}