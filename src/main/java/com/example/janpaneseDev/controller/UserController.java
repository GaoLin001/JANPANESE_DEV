package com.example.janpaneseDev.controller;

import com.example.janpaneseDev.dto.userDto;
import com.example.janpaneseDev.formParam.userParams;
import com.example.janpaneseDev.service.serviceimpl.userServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    userServiceImpl service;

    @PostMapping("/init")
    public userDto listInit(@RequestBody userParams param) {
        return service.initCheck(param);}

    @PostMapping("/logon/init")
    public userDto logonListInit(@RequestBody userParams params){
        return service.logonInit(params);
    }

}