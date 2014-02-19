package com.newglobe.minutes.web.systemmgr;


import javax.validation.Valid;

import com.newglobe.minutes.model.systemmgr.UserInfo;
import com.newglobe.minutes.web.util.AjaxUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/form")
@SessionAttributes("userInfo")
public class FormController {

    // Invoked on every request

    @ModelAttribute
    public void ajaxAttribute(WebRequest request, Model model) {
        model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
    }

    // Invoked initially to create the "form" attribute
    // Once created the "form" attribute comes from the HTTP session (see @SessionAttributes)

    @ModelAttribute("userInfo")
    public UserInfo createFormBean() {
        return new UserInfo();
    }

    @RequestMapping(method = RequestMethod.GET)
    public void form() {
    }

    /**
     * 下述控制器类中通过DataBinder对象给该类设定了一个用于验证的UserInfoValidator，
     * 这样当我们请求该控制器的时候UserInfoValidator将生效。
     * 参考：http://stackoverflow.com/questions/14533488/addiing-multiple-validators-using-initbinder
     * @param binder
     */
    @InitBinder("userInfo")
    public void initBinder(DataBinder binder) {
        binder.setValidator(new UserInfoValidator());
    }


    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@Valid UserInfo userInfo, BindingResult result,
                                @ModelAttribute("ajaxRequest") boolean ajaxRequest,
                                Model model, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            return null;
        }
        // Typically you would save to a db and clear the "form" attribute from the session
        // via SessionStatus.setCompleted(). For the demo we leave it in the session.
        String message = "Form submitted successfully.  Bound " + userInfo;
        // Success response handling
        if (ajaxRequest) {
            // prepare model for rendering success message in this request
            model.addAttribute("message", message);
            return null;
        } else {
            // store a success message for rendering on the next request after redirect
            // redirect back to the form to render the success message along with newly bound values
            redirectAttrs.addFlashAttribute("message", message);
            return "redirect:/form";
        }
    }

}

