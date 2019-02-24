package com.threewater.template.background.service.impl;

import com.threewater.template.background.domain.UserInfo;
import com.threewater.template.background.mapper.UserMapper;
import com.threewater.template.background.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    public SqlSession sqlSession;

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public UserInfo addAccount(String name, String sex) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setSex(sex);
        userInfo.setMod(new Date());

        this.sqlSession.insert("mapper.userInfo.insertUser", userInfo);
        int i = 19/0;
        return userMapper.findByIdAno(1);

    }

}
