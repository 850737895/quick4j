package com.hnnd.databinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 测试文件上传
 * Created by Administrator on 2018/4/26.
 */
@Controller
@RequestMapping("/FileOperation")
public class TestFileUpload {

    @ResponseBody
    @RequestMapping(value = "/fileUpload")
    public String testFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String retStr = "";
        if(file.isEmpty()) {
            retStr =  "上传文件为null";
        }
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String realPath = request.getRealPath("/images/");
        String fileName = file.getOriginalFilename();
        String filePath = realPath+"\\"+fileName;

        try {
            File targetFile = new File(fileName);
            if (!targetFile.exists()) {
                targetFile.createNewFile();
            }
            file.transferTo(targetFile);
            retStr = "上传文件成功";
        } catch (IOException e) {
            retStr = "上传文件失败";
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(realPath);
        return retStr;
    }
}
