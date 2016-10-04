package com.gs.app.read.web;

/**
 * @author GaoShan =.=
 * @version 1.0
 * @since 2016/10/5 0:12
 */
public class LoginCommand {
    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
