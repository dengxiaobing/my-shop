package com.dxb.my.shop.domain;

import java.io.Serializable;

/**
 * @author:deng
 * @date: 2019/1/29
 * @time: 12:27 AM
 * @email 657563945@qq.com
 */
public class User implements Serializable {
    private String username;
    private String password;
    private String email;
    /**
     * 记住我
     */
    private Boolean isRemember;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getRemember() {
        return isRemember;
    }

    public void setRemember(Boolean remember) {
        isRemember = remember;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
