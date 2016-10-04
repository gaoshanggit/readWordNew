package com.gs.app.read.web;

import com.gs.app.read.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 负责处理请求
 *
 * @author GaoShan =.=
 * @version 1.0
 * @since 2016/10/4 23:12
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    // 负责处理/index.html 请求
    @RequestMapping(value = "/index.html")
    public String loginPage() {
        return "login";
    }

    //负责处理/loginCheck.html
  /*  @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand){

    }*/


}
