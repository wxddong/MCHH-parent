/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: MemberService.java 
 * @Prject: MyUniversity-service
 * @Package: cn.com.devsource.myuniversity.file.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-01-06 15:46:14 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.app.service;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.threefiveninetong.mchh.util.PictureUtil;
import com.threefiveninetong.mchh.util.UploadFileReq;

/**
 * @ClassName: FileService
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-01-06 15:46:14
 */
@PropertySources({@PropertySource("classpath:/system.properties"),@PropertySource("classpath:/validation_zh.properties")})
@Service
public class FileService {

    private static final Logger log = LoggerFactory.getLogger(FileService.class);
    
    //公告存放地址
    @Value("${sys.upload.path.advertImages}")
    private String advertImages;
    
    /**
     * 1.后台上传图片(接口-订单评价图片上传)
     * @param file
     * @return
     */
    public String uploadImageUrl(MultipartFile file,String type) {
        UploadFileReq req = new UploadFileReq();
        String name = file.getOriginalFilename();
        req.setName(name);
        req.setSize(file.getSize());
        req.setType(name.substring(name.lastIndexOf('.') + 1));
        //公告图片路径
        if(type.equals("advertImages")){
        	 req.setServerPath(advertImages);
        }
        Map<String, Object> picServerUrls = null;
        try {
            req.setInput(file.getInputStream());
            picServerUrls = PictureUtil.uploadFtp(req);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(picServerUrls.get(name));
    }
    

}