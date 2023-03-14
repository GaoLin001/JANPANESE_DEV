package com.example.janpaneseDev.mapper;

import com.example.janpaneseDev.entity.userEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface userMapper {
    userEntity selectUser(@Param("userName") String userName,
                                @Param("userPass") String userPass);

    void insertUser(@Param("userName") String userName,
                    @Param("userPass") String userPass,
                    @Param("userTel") String userTel,
                    @Param("userEmail") String userEmail);


    int allSelect();

    List<userEntity> allNameSelect();
}
