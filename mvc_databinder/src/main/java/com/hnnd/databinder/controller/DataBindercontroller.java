package com.hnnd.databinder.controller;

import com.hnnd.databinder.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 数据绑定controller
 * Created by Administrator on 2018/4/11.
 */
@Controller
@RequestMapping("/binder")
public class DataBindercontroller {

    @RequestMapping("/test")
    @ResponseBody
    public String testStartUp() {
        return "ideal";
    }

    @RequestMapping("/bindingSimpleObj")
    @ResponseBody
    public String bindingSimpleObj(UserDto userDto, HttpServletRequest request) {
        System.out.println("UserDto:"+userDto.toString());
        System.out.println(request.getRealPath("/images/"));
        return userDto.toString();
    }

    @RequestMapping("/userConverter")
    @ResponseBody
    public String myConverter(UserDto userDto) {
        System.out.println("UserDto:"+userDto.toString());
        return userDto.toString();
    }

    public DataBindercontroller() {
        System.out.println("启动  DataBindercontroller......................");
    }
}
