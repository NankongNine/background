package com.threewater.template.background.mapper;

import com.threewater.template.background.vo.SysRoleVo;
import org.apache.ibatis.annotations.Select;

public interface SysRoleMapper {
    @Select("SELECT * FROM sys_role WHERE id = #{id}")
    SysRoleVo selectById(Integer id);
}