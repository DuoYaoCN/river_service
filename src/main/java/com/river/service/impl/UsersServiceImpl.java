package com.river.service.impl;

import com.river.domain.Users;
import com.river.persistence.UsersMapper;
import com.river.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

@Service
public class UsersServiceImpl implements UsersService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UsersMapper usersMapper;

    /**
     * 404 --- 不存在用户
     * 400 --- 用户密码错误
     * 200 --- 用户存在且密码正确
     * @param account
     * @param password
     * @return
     */
    @Override
    public String verify(String account, String password) {
        Users users = usersMapper.selectUser(account);
        if (users == null){
            logger.warn("user does not exist");
            return "404";
        }
        String pass = null;
        try{
            pass = Base64.getMimeEncoder().encodeToString(password.getBytes("utf-8"));
        }catch (Exception e){
            e.printStackTrace();
        }
        if(users.getPassword().equals(pass)) {
            logger.info("get user success");
            return "200";
        }
        else return "400";
    }

    @Override
    public Users select(String account) {
        if (account.equals("") || account == null){
            logger.warn("enter undefined account");
            return null;
        }
        Users users = usersMapper.selectUser(account);
        logger.info("func success");
        return users == null ? null :usersMapper.selectUser(account);
    }

    @Override
    public String insert(Users users) {
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
        logger.info("insert success");
        users.setPassword(password);
        usersMapper.insertUser(users);
        return users.getId();
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
