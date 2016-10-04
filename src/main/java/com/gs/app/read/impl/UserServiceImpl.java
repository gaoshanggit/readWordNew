package com.gs.app.read.impl;

import com.gs.app.read.api.domain.LoginDao;
import com.gs.app.read.api.domain.LoginLog;
import com.gs.app.read.api.domain.User;
import com.gs.app.read.api.domain.UserDao;
import com.gs.app.read.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GaoShan =.=
 * @version 1.0
 * @since 2016/9/30 19:35
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginDao loginDao;

    public boolean hasMatchUser(String userName, String passWord) {
        int matchCount = userDao.getMatchCount(userName, passWord);
        return matchCount > 0;
    }

    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    public void loginSuccess(User user) {
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = getLoginLog(user);
        userDao.updateLoginInfo(user);
        loginDao.insertLogin(loginLog);
    }

    private LoginLog getLoginLog(User user) {
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        return loginLog;
    }

}
