package com.threewater.template.background.controller;

import com.threewater.template.background.utils.JsonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class FileUploadController {
    @Value("${custom.upload.path:C:\\Users\\CH\\IdeaProjects\\bootproject\\src\\main\\resources\\upload\\}")
    private String filePath;

    @RequestMapping(path = "/api/vi/upload")
    @ResponseBody
    public JsonData upload(@RequestParam("upload_file") List<MultipartFile> files, HttpServletRequest request) {

        //file.isEmpty(); 判断图片是否为空
        //file.getSize(); 图片大小进行判断
        List<String> fileNames = new ArrayList<>();
        int fileSize = files.size();

        for(MultipartFile file: files) {
            String name = request.getParameter("name");
            System.out.println("用户名：" + name);

            // 获取文件名
            String fileName = file.getOriginalFilename();
            System.out.println("上传的文件名为：" + fileName);

            // 获取文件的后缀名,比如图片的jpeg,png
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            System.out.println("上传的后缀名为：" + suffixName);

            // 文件上传后的路径
            fileName = UUID.randomUUID() + suffixName;
            System.out.println("转换后的名称:" + fileName);

            File dest = new File(filePath + fileName);

            try {
                file.transferTo(dest);
                fileNames.add(fileName);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(fileNames.size() != fileSize) {
            return  new JsonData(-1, null, "failed to save ");
        }
        return new JsonData(0, fileNames);
    }

}
