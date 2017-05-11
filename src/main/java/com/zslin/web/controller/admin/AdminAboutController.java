package com.zslin.web.controller.admin;

import com.zslin.app.model.About;
import com.zslin.app.service.IAboutService;
import com.zslin.basic.auth.annotations.AdminAuth;
import com.zslin.basic.tools.MyBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zsl-pc on 2016/10/8.
 */
@Controller
@RequestMapping(value = "admin/about")
@AdminAuth(name="关于", orderNum=1, psn="网站管理", pentity=0, porderNum=1)
public class AdminAboutController {

    @Autowired
    private IAboutService aboutService;

    /** 列表 */
    @AdminAuth(name = "关于管理", orderNum = 1, icon="icon-edit")
    @RequestMapping(value="index")
    public String index(Model model, About about, HttpServletRequest request) {
        String method = request.getMethod();
        if("get".equalsIgnoreCase(method)) {
            About a = aboutService.findOne(1);
            if(a==null) {a = new About(); a.setId(1);}
            model.addAttribute("about", a);
            return "admin/about/index";
        } else {
            About a = aboutService.findOne(1);
            if(a==null) {a = new About(); a.setId(1);}
            MyBeanUtils.copyProperties(about, a, new String[]{"id", "readCount"});
            aboutService.save(a);
            return "redirect:/admin/about/index";
        }
    }
}
