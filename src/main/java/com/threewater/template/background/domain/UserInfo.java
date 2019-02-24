package com.threewater.template.background.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Document(indexName = "blog", type = "user")
public class UserInfo {
    @JsonIgnore
    private String id;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String sex;
    @JsonProperty("modify_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date mod;

    public UserInfo(){}

    public UserInfo(String name, String sex, Date mod) {
        this.name = name;
        this.sex = sex;
        this.mod = mod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getMod() {
        return mod;
    }

    public void setMod(Date mod) {
        this.mod = mod;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", mod=" + mod +
                '}';
    }
}
