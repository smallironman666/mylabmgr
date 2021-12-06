package com.quercus.service;

import com.quercus.pojo.User;

public interface UserService {
    void pay();
    User login(String uname, String pwd);
}
