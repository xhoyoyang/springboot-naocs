package com.demo.nacos.nacosapi.Controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.net.spi.nameservice.NameService;

import javax.crypto.interfaces.PBEKey;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final String appName="nacos-server";

    @NacosInjected
    private NamingService namingService;

    @GetMapping("/user")
    public Object userList() throws Exception{

        Instance instance = namingService.selectOneHealthyInstance(appName);
        String host = "http://"+instance.getIp()+":"+instance.getPort();
        String uri = "/user/list";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(host+uri,String.class);
    }

    @GetMapping("/instance")
    public Object getInstanceList()throws Exception{
        return namingService.getAllInstances(appName);
    }

}
