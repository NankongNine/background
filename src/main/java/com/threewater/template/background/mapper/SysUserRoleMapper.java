package com.threewater.template.background.mapper;

import com.threewater.template.background.vo.SysUserRoleVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysUserRoleMapper {
    @Select("SELECT * FROM sys_user_role WHERE user_id = #{userId}")
    List<SysUserRoleVo> listByUserId(Integer userId);
}
