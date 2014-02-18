package com.newglobe.minutes.web.systemmgr;

import com.newglobe.minutes.model.systemmgr.UserInfo;
import com.newglobe.minutes.service.systemmgr.IUserInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/sysuser")
public class UserController {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private IUserInfoService userInfoService;

    @RequestMapping(params = "method=login", method=RequestMethod.POST)
    public String login(String username, String password,ModelMap model) {
        // 依据params的参数method的值来区分不同的调用方法
        // 可以指定页面请求方式的类型，默认为get请求
        try {
            UserInfo userinfo = userInfoService.getUser(username);
            if( null != userinfo){
               logger.debug("get userinfo by username succcess  "+userinfo.getUserPassword());
               if(password.equals(userinfo.getUserPassword())){
                   return "main";
               }else {
                   model.addAttribute("message", "用户密码不正确!");
               }
            } else {
               logger.debug("get userinfo by username fail  ");
                model.addAttribute("message", "用户不存在!");
            }
        } catch (Exception e) {
            logger.error("get userinfo by username error"+ e.getMessage(),e);
            model.addAttribute("message", "登录失败");
        }
        return "loginError";
    }
}