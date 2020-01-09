package com.river.service.impl;

import com.river.domain.Users;
import com.river.persistence.UsersMapper;
import com.river.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersMapper usersMapper;

    @Override
    public boolean verify(String account, String password) {
        String pass = null;
        try{
            pass = Base64.getMimeEncoder().encodeToString(password.getBytes("utf-8"));
        }catch (Exception e){
            e.printStackTrace();
        }

        if(usersMapper.selectUser(account).getPassword().equals(pass)) {
            return true;
        }
        else return false;
    }

    @Override
    public Users select(String account) {
        return usersMapper.selectUser(account);
    }

    @Override
    public void insert(Users users) {
        long random = System.currentTimeMillis();
        int r1 = Math.abs((int) random%1000);
        String r2 = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        users.setId(r1+r2);
        String password = null;
        try{
            password = Base64.getEncoder().encodeToString(users.getPassword().getBytes("utf-8"));

        }catch (Exception e){
            e.printStackTrace();
        }
        users.setPassword(password);
        usersMapper.insertUser(users);
    }

    @Override
    public void update(Users users) {
        String pass = null;
        try{
            pass = Base64.getMimeEncoder().encodeToString(users.getPassword().getBytes("utf-8"));
        }catch (Exception e){
            e.printStackTrace();
        }
        users.setPassword(pass);
        usersMapper.updateUser(users);
    }

    @Override
    public void delete(String account) {
        usersMapper.deleteUser(account);
    }

}
