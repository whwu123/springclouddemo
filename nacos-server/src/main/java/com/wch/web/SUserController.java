package com.wch.web;

import com.wch.entity.SUser;
import com.wch.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SUserController {

    @Autowired
    public SUserService sUserService;
    //@RequestMapping(value="/{id}",method=RequestMethod.GET)
    //@RequestMapping(value="/{id}",method=RequestMethod.POST)
    //@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    //@RequestMapping(value="/{id}",method=RequestMethod.PUT)
    @RequestMapping(value = "/get/{id}",method= RequestMethod.GET)
    public SUser getSuserById(@PathVariable int id){
        //System.out.println(id);
        return sUserService.getSUserById(id);
    }
}
