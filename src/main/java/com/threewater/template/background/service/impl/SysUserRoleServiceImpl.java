package com.threewater.template.background.service.impl;

import com.threewater.template.background.mapper.SysUserRoleMapper;
import com.threewater.template.background.service.SysUserRoleService;
import com.threewater.template.background.vo.SysUserRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    private SysUserRoleMapper userRoleMapper;
    @Override
    public List<SysUserRoleVo> listByUserId(Integer userId) {
        return userRoleMapper.listByUserId(userId);
    }
}
