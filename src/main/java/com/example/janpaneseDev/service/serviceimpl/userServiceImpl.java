package com.example.janpaneseDev.service.serviceimpl;

import com.example.janpaneseDev.dao.daoimpl.userDaoImpl;
import com.example.janpaneseDev.dto.userDto;
import com.example.janpaneseDev.entity.userEntity;
import com.example.janpaneseDev.formParam.userParams;
import com.example.janpaneseDev.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService {
    @Autowired
    userDaoImpl dao;
    @Override
    public userDto initCheck(userParams param) {
        userEntity entity = dao.initCheck(param);
        userDto dto = new userDto();
        dto.setUserName(entity.getUserName());
        dto.setUserPass(entity.getUserPass());
        return dto;
    }

    @Override
    public userDto logonInit(userParams param) {
        boolean flag = dao.logonInit(param);
        userDto dto = new userDto();
        if (flag) {
            dto.setMessage("恭喜您 "+param.getUsername()+"用户，注册成功");
            dto.setFlag("0");
        } else {
            dto.setMessage("很抱歉由于某种原因未注册成功");
            dto.setFlag("1");
        }
        return dto;
    }
}
