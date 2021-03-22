package com.demo.nacos.nacosapi.registery;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.Event;
import com.alibaba.nacos.api.naming.listener.EventListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

//@Component
public class NacosRegistery implements CommandLineRunner {

    @NacosInjected
    private NamingService namingService;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private Integer port;

    @Override
    public void run(String... args) throws Exception {
        namingService.registerInstance(appName, InetAddress.getLocalHost().getHostAddress(), port);
    }

    @Bean
    public void sub() throws Exception{
        namingService.subscribe("nacos-server", new EventListener() {
            @Override
            public void onEvent(Event event) {
                //event.
                System.out.println("服务状态已发生变化");
            }
        });
    }
}
