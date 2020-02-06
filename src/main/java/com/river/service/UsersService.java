package com.river.service;

import com.river.domain.Users;

public interface UsersService {
    String verify(String account, String password);
    Users select(String account);
    void insert(Users users);
    void update(Users users);
    void delete(String account);
}
