package com.threewater.template.background.service.impl;

import com.threewater.template.background.mapper.SysUserMapper;
import com.threewater.template.background.service.SysUserService;
import com.threewater.template.background.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper userMapper;
    @Override
    public SysUserVo selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public SysUserVo selectByName(String name) {
        return userMapper.selectByName(name);
    }
}
