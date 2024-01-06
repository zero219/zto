package com.zto.service;

import com.zto.entity.User;
import com.zto.mapper.UserMapper;
import com.zto.common.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<User> selectAll() {
        List<User> users = new ArrayList<>();
        try {
            SqlSession sqlSession = factory.openSession();
            //获取UserMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            //调用方法
            users = mapper.selectAll();
            // 关闭
            sqlSession.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return users;
    }
}
