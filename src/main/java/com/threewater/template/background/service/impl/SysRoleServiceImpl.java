package com.threewater.template.background.service.impl;

import com.threewater.template.background.mapper.SysRoleMapper;
import com.threewater.template.background.service.SysRoleService;
import com.threewater.template.background.vo.SysRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;
    @Override
    public SysRoleVo selectById(Integer id) {
        return roleMapper.selectById(id);
    }
}
