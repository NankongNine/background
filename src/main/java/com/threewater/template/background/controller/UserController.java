package com.threewater.template.background.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.threewater.template.background.domain.UserInfo;
import com.threewater.template.background.mapper.UserMapper;
import com.threewater.template.background.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    public UserMapper userMapper;

    @Autowired
    public SqlSession sqlSession;

    @Autowired
    public UserService userService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public int addUser(String name, String sex){
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setSex(sex);
        userInfo.setMod(new Date());

        return this.sqlSession.insert("mapper.userInfo.insertUser", userInfo);
    }

    @RequestMapping(path = "/findById", method = RequestMethod.GET)
    public UserInfo findUser(int id){
        return this.sqlSession.selectOne("mapper.user.selectUserById", id);
    }

    @RequestMapping(path="/findByIdAno", method = RequestMethod.GET)
    public UserInfo findUserAno(int id){
        return userMapper.findByIdAno(id);
    }

    @RequestMapping(path="/testTransaction", method = RequestMethod.POST)
    public UserInfo findUserAno(String name, String sex){
        return userService.addAccount(name, sex);
    }

    @RequestMapping(path="/findAllByAno", method = RequestMethod.GET)
    public PageInfo<UserInfo> findAllByAno(int pageNum, int pageSize){
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(pageNum, pageSize);
        List<UserInfo> userInfoList = userMapper.findAll();
        PageInfo<UserInfo> userPageInfo = new PageInfo<>(userInfoList);
        return userPageInfo;
    }
}
