package com.gs.app.read.api.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author GaoShan =.=
 * @version 1.0
 * @since 2016/9/30 21:44
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    public void hasMathUser(){
        boolean b1 = userService.hasMatchUser("admin","123145");

    }


}
