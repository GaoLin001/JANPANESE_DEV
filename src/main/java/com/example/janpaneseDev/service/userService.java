package com.example.janpaneseDev.service;

import com.example.janpaneseDev.dto.userDto;
import com.example.janpaneseDev.formParam.userParams;

public interface userService {

    userDto initCheck(userParams param);

    userDto logonInit(userParams param);
}
