package com.river.domain;

public class Users implements java.io.Serializable {
    private String username;
    private String password;
    private String status;
    private String account;
    private String id;  //随机生成的用户唯一标示

    public Users(){
    }


    public Users(String account, String username, String password, String status){
        this.account = account;
        this.username = username;
        this.password = password;
        this.status = status;
        this.id = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
