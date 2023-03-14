package com.example.janpaneseDev.dao.daoimpl;

import com.example.janpaneseDev.dao.userDao;
import com.example.janpaneseDev.entity.userEntity;
import com.example.janpaneseDev.formParam.userParams;
import com.example.janpaneseDev.mapper.userMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class userDaoImpl implements userDao {
    @Autowired
    private userMapper mapper;
    @Override
    public userEntity initCheck(userParams param) {
        return mapper.selectUser(param.getUsername(),param.getUserPass());
    }

    @Override
    public boolean logonInit(userParams params) {
        int count = mapper.allSelect();
        boolean flag = false;
        boolean flag2 = true;
        List<userEntity> userList = mapper.allNameSelect();
        for (int index = 0 ;index < userList.size();index++) {
            if(params.getUsername().equals(userList.get(index).getUserName())){
                return false;
            }
        }
        if (flag2) {
            mapper.insertUser(params.getUsername(), params.getUserPass(), params.getUserTel(), params.getUserEmail());
            int count1 = mapper.allSelect();
            if(count == count1) {
                flag = false;
            } else {
                flag = true;
            }
        }


        return flag;
    }
}
