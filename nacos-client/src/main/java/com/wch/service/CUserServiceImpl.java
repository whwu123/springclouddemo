package com.wch.service;

import com.wch.dto.SUserDto;
import com.wch.entity.ClientUser;
import com.wch.mapper.CUserMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Log4j2
public class CUserServiceImpl implements CUserService {
    @Autowired
    private CUserMapper cUserMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public void saveUser(int id) {
         //获取服务
        // List<ServiceInstance> instances = discoveryClient.getInstances("nacos01");
         //完成负载均衡
       // int randomIndex = ThreadLocalRandom.current().nextInt(instances.size());
        //根据随机数随机获取一个服务出来
        //ServiceInstance serviceInstance = instances.get(randomIndex);
        //组装地址
       // String targetURL = serviceInstance.getUri().toString()+"/user/get/{id}";
        String targetURL = "http://nacos-zuul/user/get/{id}";
        //请求路径
        //String userServiceURL = "http://localhost:8761/user/get/{id}";
        log.info("请求的地址是："+targetURL);
        SUserDto sUser = restTemplate.getForObject(targetURL, SUserDto.class,id);
        log.info("返回的数据"+sUser);
        ClientUser user = ClientUser.builder().userName(sUser.getName()).userPwd(sUser.getPassword()).build();
        cUserMapper.insert(user);
    }
}
