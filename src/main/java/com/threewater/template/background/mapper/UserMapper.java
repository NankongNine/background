package com.threewater.template.background.mapper;

import com.threewater.template.background.domain.UserInfo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper 该注解和mapperScan只用有一个就行，如果没有mapperScan，则每个mapper类都需要有@Mapper注解，如果有mapperScan，则可以不适用@Mapper
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    @Results(
            {@Result(column = "modtime", property = "mod")}
    )
    UserInfo findByIdAno(int id);

    @Select("select * from user")
    @Results(
            {@Result(column = "modtime", property = "mod")}
    )
    List<UserInfo> findAll();
}
