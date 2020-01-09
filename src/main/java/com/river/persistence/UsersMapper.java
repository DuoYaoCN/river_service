package com.river.persistence;

import com.river.domain.Users;

public interface UsersMapper {
    Users selectUser(String account);
    void insertUser(Users users);
    void deleteUser(String account);
    void updateUser(Users users);
}
