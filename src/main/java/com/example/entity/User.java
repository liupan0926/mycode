package com.example.entity;

import java.io.Serializable;

/**
 * 类User.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Jul 4, 2021 10:20:34 AM
 */
public class User implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 6206753857748608243L;
    private Integer           id;
    private String            userName;
    private String            passWord;
    private String            realName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName='" + userName + '\'' + ", passWord='" + passWord + '\''
                + ", realName='" + realName + '\'' + '}';
    }
}
