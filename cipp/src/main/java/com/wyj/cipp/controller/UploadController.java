package com.wyj.cipp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/v1/private")
public class UploadController {

    // 单个图片上传
    @PostMapping(value = "/uploadFile")
    // 使用HttpServletRequest需导入javax.servlet-api-4.0.1.jar
    // 上传的文件自动绑定到MultipartFile中
    public Map uploadFile(@RequestParam("uploadFile") MultipartFile uploadFile , HttpServletRequest request) throws IOException {
        // 判断文件是否成功上传
        HashMap map = new HashMap();
        if(uploadFile!=null){
            // 指定上传图片的保存路径
            //String path = System.getProperty("user.dir")+"/uploads/";
            String path = "/www/wwwroot/http/uploads";
            System.out.println(path);
            // 获取上传的文件名全称
            String fileName=uploadFile.getOriginalFilename();
            // 获取上传文件的后缀名
            String suffix=fileName.substring(fileName.lastIndexOf("."));
            // 给文件定义一个新的名称,杜绝文件重名覆盖现象
            String newFileName= UUID.randomUUID().toString()+suffix;
            // 创建File对象,注意这里不是创建一个目录或一个文件,你可以理解为是 获取指定目录中文件的管理权限(增改删除判断等 . . .)
            File tempFile=new File(path);
            // 判断File对象对应的目录是否存在
            if(!tempFile.exists()){
                // 创建以此抽象路径名命名的目录,注意mkdir()只能创建一级目录,所以它的父级目录必须存在
                tempFile.mkdir();
            }
            // 在指定路径中创建一个文件(该文件是空的)
            File file=new File(path + newFileName);
            // 将上传的文件写入指定文件
            uploadFile.transferTo(file);
            //map.put("dizhi","http://localhost:9999/uploads/"+newFileName);

            //将文件上传至服务器目录，并将此文件映射出来使其可以外部访问
            //也可以使用OSS等存储
            map.put("dizhi","http://106.15.197.17/uploads/"+newFileName);
        }
        return map;
    }


}
