package com.springboot.demo.myabtis;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user")
    Object selectByAll();
}
