package com.quercus.service.impl;

import com.quercus.mapper.UserMapper;
import com.quercus.pojo.User;
import com.quercus.service.UserService;
import com.quercus.util.SqlsessionUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {

    @Override
    public void pay() {
        /*下订单操作
            A 订单表——insert
            B 订单明细表 ——insert
            C 库存表——update
            D历史记录表——insert
        */
    }

    @Override
    public User login(String uname, String pwd) {
        SqlSession sqlSession = SqlsessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectOne(uname, pwd);
        sqlSession.close();
        return user;
    }
}
