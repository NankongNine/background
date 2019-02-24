package com.threewater.template.background.controller;

import com.threewater.template.background.domain.UserInfo;
import com.threewater.template.background.repository.UserRepository;
import com.threewater.template.background.utils.JsonData;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/elastic")
public class ElasticController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/save/user")
    public Object save(String id, String name, String sex){

        UserInfo userInfo = new UserInfo(name, sex, new Date());
        userInfo.setId(id);

        userRepository.save(userInfo);

        return JsonData.buildSuccess();
    }

    @GetMapping("/search/user")
    public Object search(String name){

        //QueryBuilder queryBuilder = QueryBuilders.matchAllQuery(); //搜索全部文档
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("name", name);

        Iterable<UserInfo> list =  userRepository.search(queryBuilder);

        return JsonData.buildSuccess(list);
    }

}
