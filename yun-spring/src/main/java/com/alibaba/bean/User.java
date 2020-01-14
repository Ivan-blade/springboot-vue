package com.alibaba.bean;

/**
 * 用户信息
 */
public class User {
    private Long id;
    private String username;
    private String password;
    private Long UserPhone;
    
    public Long getUserphone() {
        return UserPhone;
    }

    public void setUserphone(Long UserPhone) {
        this.UserPhone = UserPhone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
