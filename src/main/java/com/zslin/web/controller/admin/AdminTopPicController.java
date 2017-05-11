package com.zslin.web.controller.admin;

import com.zslin.app.model.TopPic;
import com.zslin.app.service.ITopPicService;
import com.zslin.basic.auth.annotations.AdminAuth;
import com.zslin.basic.auth.annotations.Token;
import com.zslin.basic.auth.tools.TokenTools;
import com.zslin.basic.tools.MyBeanUtils;
import com.zslin.basic.tools.PageableTools;
import com.zslin.basic.tools.ParamFilterTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 钟述林 393156105@qq.com on 2016/11/11 23:33.
 */
@Controller
@RequestMapping(value = "admin/topPic")
@AdminAuth(name="页头图片管理", orderNum=3, psn="网站管理", pentity=0, porderNum=1)
public class AdminTopPicController {

    @Autowired
    private ITopPicService topPicService;

    /** 列表 */
    @AdminAuth(name = "页头图片列表", orderNum = 1, icon="icon-list")
    @RequestMapping(value="list", method= RequestMethod.GET)
    public String list(Model model, Integer page, HttpServletRequest request) {
        Page<TopPic> datas = topPicService.findAll(new ParamFilterTools<TopPic>().buildSpecification(model, request), PageableTools.basicPage(page, "asc", "orderNo"));
        model.addAttribute("datas", datas);
        return "admin/topPic/list";
    }

    @Token(flag=Token.READY)
    @AdminAuth(name = "添加页头图片", orderNum = 2, icon="icon-plus")
    @RequestMapping(value="add", method=RequestMethod.GET)
    public String add(Model model, HttpServletRequest request) {
        TopPic tp = new TopPic();
        tp.setStatus("1");
        tp.setUrlTarget("1");
        model.addAttribute("topPic", tp);
        return "admin/topPic/add";
    }

    /** 添加POST */
    @Token(flag=Token.CHECK)
    @RequestMapping(value="add", method=RequestMethod.POST)
    public String add(Model model, TopPic topPic, HttpServletRequest request) {
        if(TokenTools.isNoRepeat(request)) {
            topPicService.save(topPic);
        }
        return "redirect:/admin/topPic/list";
    }

    @Token(flag=Token.READY)
    @AdminAuth(name="修改页头图片", orderNum=3, type="2")
    @RequestMapping(value="update/{id}", method=RequestMethod.GET)
    public String update(Model model, @PathVariable Integer id, HttpServletRequest request) {
        TopPic tp = topPicService.findOne(id);

        model.addAttribute("topPic", tp);
        return "admin/topPic/update";
    }

    @Token(flag=Token.CHECK)
    @RequestMapping(value="update/{id}", method=RequestMethod.POST)
    public String update(Model model, @PathVariable Integer id, TopPic topPic, HttpServletRequest request) {
        if(TokenTools.isNoRepeat(request)) {
            TopPic tp = topPicService.findOne(id);
            MyBeanUtils.copyProperties(topPic, tp, new String[]{"id"});

            topPicService.save(tp);
        }
        return "redirect:/admin/topPic/list";
    }

    @AdminAuth(name="删除页头图片", orderNum=4, type="2")
    @RequestMapping(value="delete/{id}", method=RequestMethod.POST)
    public @ResponseBody
    String delete(@PathVariable Integer id) {
        try {
            topPicService.delete(id);
            return "1";
        } catch (Exception e) {
            return "0";
        }
    }
}
