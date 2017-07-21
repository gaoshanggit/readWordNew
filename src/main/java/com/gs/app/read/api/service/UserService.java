package com.gs.app.read.api.service;

import com.gs.app.read.api.domain.User;

/**
 * @author GaoShan =.=
 * @version 1.0
 * @since 2016/10/4 22:43
 */
public interface UserService {

    /**
     * 根据
     * @param userName
     * @param passWord
     * @return
     */
    boolean hasMatchUser(String userName, String passWord);

    /**
     *
     * @param userName
     * @return
     */
    User findUserByUserName(String userName);

    /**
     *
     * @param user
     */
    void loginSuccess(User user);


    void demo(String str);

}
