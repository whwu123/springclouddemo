package com.wch.web;

import com.wch.service.CUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Cuser")
public class CUserController {
    @Autowired
    private CUserService cUserService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public void saveUser(int id){
        cUserService.saveUser(id);
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public List<String> test(){
        return  discoveryClient.getServices();
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    @ResponseBody
    public List<ServiceInstance> test2(){
        return  discoveryClient.getInstances("nacos01");
    }

}
