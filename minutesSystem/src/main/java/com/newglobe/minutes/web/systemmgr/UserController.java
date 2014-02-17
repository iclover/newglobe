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

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
        // 如果不加任何参数，则在请求/sysuser时，便默认执行该方法
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

    @RequestMapping(params = "method=login", method=RequestMethod.POST)
    public String login(String username, String password) {
        // 依据params的参数method的值来区分不同的调用方法
        // 可以指定页面请求方式的类型，默认为get请求

        try {
            UserInfo userinfo = userInfoService.getUser("admin");
            if( null != userinfo){
               logger.debug("get userinfo by username succcess  "+userinfo.getUserPassword());
            } else {
               logger.debug("get userinfo by username fail  ");
            }
        } catch (Exception e) {
            logger.error("get userinfo by username error"+ e.getMessage(),e);
            return "loginError";
        }

//        if (!"admin".equals(username) || !"admin".equals(password)) {
//            return "loginError";
//        }
        return "loginSuccess";
    }
}