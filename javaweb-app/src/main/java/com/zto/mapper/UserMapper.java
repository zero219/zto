package com.zto.mapper;

import java.util.List;

import com.zto.entity.User;

public interface UserMapper {
    List<User> selectAll();

    User selectById(int id);
}
