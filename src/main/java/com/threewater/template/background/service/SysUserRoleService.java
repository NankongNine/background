package com.threewater.template.background.service;

import com.threewater.template.background.vo.SysUserRoleVo;

import java.util.List;

public interface SysUserRoleService {
    public List<SysUserRoleVo> listByUserId(Integer userId);
}
