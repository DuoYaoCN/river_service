package com.river.service;

import com.river.domain.Users;

public interface UsersService {
    String verify(String account, String password);
    Users select(String account);
    String insert(Users users);
    String update(Users users);
    String delete(String account);
}
