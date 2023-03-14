package com.example.janpaneseDev.dao;

import com.example.janpaneseDev.entity.userEntity;
import com.example.janpaneseDev.formParam.userParams;

public interface userDao {

    userEntity initCheck(userParams param);

    boolean logonInit(userParams params);
}
