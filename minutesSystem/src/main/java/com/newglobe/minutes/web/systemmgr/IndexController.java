package com.newglobe.minutes.web.systemmgr;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class IndexController {
    private Logger logger = Logger.getLogger(getClass().getName());

	@RequestMapping(method = RequestMethod.GET)
	public String welcomePage(ModelMap model) {
        // 如果不加任何参数，则在请求/时，便默认执行该方法
        logger.info("进入登录页面");
        model.addAttribute("message", "Hello world!");
		return "login";
	}
}