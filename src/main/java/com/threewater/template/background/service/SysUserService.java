package com.threewater.template.background.service;

import com.threewater.template.background.vo.SysUserVo;

public interface SysUserService {
    public SysUserVo selectById(Integer id);
    public SysUserVo selectByName(String name);
}
