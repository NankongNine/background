package com.threewater.template.background.service;

import com.threewater.template.background.domain.UserInfo;

public interface UserService {

    /**
     * 功能描述：测试事务
     * @return
     */
    public UserInfo addAccount(String name, String sex);

}
