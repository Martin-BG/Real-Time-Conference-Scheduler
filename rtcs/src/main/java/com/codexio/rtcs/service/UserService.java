package com.codexio.rtcs.service;

import com.codexio.rtcs.entities.User;

public interface UserService {

    void create(User user);

    User findUserByEmail(String email);

}
