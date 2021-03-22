package com.demo.nacos.nacosserver.vo;

import java.io.Serializable;

public class UserVo implements Serializable {

    private static final long serialVersionUID = 12314141L;

    private Integer id;

    private String name;

    private Integer age;

    public UserVo(){


    }

    public UserVo(Integer id ,String nmae ,Integer age){

        this.id=id;
        this.name=nmae;
        this.age=age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
