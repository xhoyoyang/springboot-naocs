package com.demo.nacos.nacosserver.Controller;


import com.demo.nacos.nacosserver.vo.UserVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController  {

    @GetMapping("/list")
    public Object userList(){
        List list  = new ArrayList();
        UserVo userVo = new UserVo(1,"zhangsan",18);
        list.add(userVo);
        return list;
    }


}
