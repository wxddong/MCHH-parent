package com.threefiveninetong.mchh.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public class PictureUtil {
	
	  /* *//**
     * Fpt上传文件图片--生产环境
     * @param file
     * @return
     */
	/*public static Map<String, Object> uploadFtp(UploadFileReq file) {
        Map<String, Object> fileMap = new HashMap<String, Object>();
        // 验证服务器路径
        String uploadPath = file.getServerPath();
        // 拉到图片名称
        String  fileName = file.getName();
        if (!StringUtil.isNullOrBlank(fileName)) {
            // 拿到图片名称
            String newName = IdUtil.uuid() + fileName.substring(fileName.lastIndexOf('.'));
            FtpUtil.uploadFile(uploadPath, newName, file.getInput());
            fileMap.put(fileName, newName);
        }
        return fileMap;
    }*/
	
	
    /**
     * 上传图片--测试环境
     * @param file
     * @return
     */
   public static Map<String, Object> uploadFtp(UploadFileReq file) {
        Map<String, Object> fileMap = new HashMap<String, Object>();
        String fileName = null;
        // TODO: 必要的数据校验
        // 验证服务器路径
        String uploadPath = file.getServerPath();
        // 创建唯一临时目录,防止文件冲突
        String tmpPath = uploadPath + File.separator + "temp" + File.separator + IdUtil.uuid();
        // 将文件下载到临时目录中
        FileUtil.copyFile(file.getInput(), tmpPath, file.getName());
        // 拉到图片名称
        fileName = file.getName();
        if (!StringUtil.isNullOrBlank(fileName)) {
            // 拿到图片名称
            String newName = IdUtil.uuid() + fileName.substring(fileName.lastIndexOf('.'));
            String oldPath = tmpPath + File.separator + fileName;
            String newPath = uploadPath + File.separator + newName;
            String realFileUrl = newName;
            // 将临时图片剪切到共享目录，并重命名文件名
            FileUtil.cut(oldPath, newPath);
            fileMap.put(fileName, realFileUrl);
            FileUtil.delete(tmpPath);
        }
        return fileMap;
    }

    /**
     * 上传图片
     * 
     * @param file
     * @return 数据库存放的地址
     */
    public static String updateImage(MultipartFile file) {
        String imagePath = "";
        if (file != null) {
            UploadFileReq uploadFileReq = new UploadFileReq();
            String name = file.getOriginalFilename();
            uploadFileReq.setName(name);
            uploadFileReq.setSize(file.getSize());
            uploadFileReq.setType(name.substring(name.lastIndexOf('.') + 1));
            String uploadPath = uploadPath();
            int random = (int) (Math.random() * 10000); // 随机数
            imagePath = String.valueOf(System.currentTimeMillis()) + String.valueOf(random) + "."
                    + uploadFileReq.getType();

            try {
                // 用户像
                FileUtil.copyFile(file.getInputStream(), uploadPath, imagePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imagePath;
    }

    /**
     * 上传图片
     * 
     * @param file
     * @return
     */
    public static Map<String, Object> upload(UploadFileReq file) {
        Map<String, Object> fileMap = new HashMap<String, Object>();
        String fileName = null;
        // TODO: 必要的数据校验
        // 验证服务器路径
        String uploadPath = file.getServerPath();
        // 创建唯一临时目录,防止文件冲突
        String tmpPath = uploadPath + File.separator + "temp" + File.separator + IdUtil.uuid();
        // 将文件下载到临时目录中
        FileUtil.copyFile(file.getInput(), tmpPath, file.getName());
        // 拉到图片名称
        fileName = file.getName();
        if (!StringUtil.isNullOrBlank(fileName)) {
            // 拿到图片名称
            String newName = IdUtil.uuid() + fileName.substring(fileName.lastIndexOf('.'));
            String oldPath = tmpPath + File.separator + fileName;
            String newPath = uploadPath + File.separator + newName;
            String realFileUrl = newName;
            // 将临时图片剪切到共享目录，并重命名文件名
            FileUtil.cut(oldPath, newPath);
            fileMap.put(fileName, realFileUrl);
            FileUtil.delete(tmpPath);
        }
        return fileMap;
    }

    /**
     * 上传压缩包文件
     * 
     * @param file
     * @return
     */
    public static Map<String, Object> uploadZip(UploadFileReq file) {
        Map<String, Object> fileMap = new HashMap<String, Object>();
        String[] fileNames = null;
        // TODO: 必要的数据校验
        String uploadPath = file.getServerPath();
        if (StringUtil.isNullOrBlank(uploadPath)) {
            uploadPath = ConfigUtils.getStringByKey("sys.upload.path.htmlUrl");
        }
        // 创建唯一临时目录,防止文件冲突
        String tmpPath = uploadPath + File.separator + "temp" + File.separator + IdUtil.uuid();
        String mingName = "";
        try {
            // 将文件下载到临时目录中
            FileUtil.copyFile(file.getInput(), tmpPath, file.getName());
            // fileNames = FileUtil.decompress(tmpPath + File.separator +
            // file.getName(), tmpPath);

            mingName = Long.toString(System.currentTimeMillis());
        } catch (Exception e) {
            throw new SystemException(e);
        }
        if (!ArrayUtil.isNullOrEmpty(fileNames)) {
            int length = fileNames.length;
            for (int i = 0; i < length; i++) {
                String oldName = fileNames[i];

                // 文件名不变
                String oldPath = tmpPath + File.separator + oldName;
                // 文件名不变
                String newPath = uploadPath + File.separator + oldName;

                // 生成新的文件
                newPath = uploadPath + File.separator + mingName + File.separator + oldName;

                // 将临时解压后的图片剪切到共享目录，并重命名文件名
                FileUtil.cut(oldPath, newPath);

                String newName = oldName.substring(oldName.lastIndexOf('.'));
                // 生成文件名
                if (newName.toUpperCase().equals(".HTML") || newName.toUpperCase().equals(".html")) {
                    String realFileUrl = mingName + "/" + oldName;

                    fileMap.put(file.getName(), realFileUrl);
                }
            }
            FileUtil.delete(tmpPath);
        }
        return fileMap;

    }

    /**
     * 二维码图片部署地址
     * 
     * @return
     */
    public static String uploadPath() {
        String uploadPath = ConfigUtils.getStringByKey("sys.upload.path");
        return uploadPath;
    }

    /**
     * 二维码接口图片访问地址
     * 
     * @return
     */
    public static String imageBaseUrl() {
        String imageBaseUrl = ConfigUtils.getStringByKey("sys.imageserver.url");
        return imageBaseUrl;
    }

    // textUrl二维码访问地址
    // public static String textUrl
    // ="http://101.200.172.219/html/register.html?recommendPhone=";
    public static String textUrl = "http://m.leifengdai.com/html/register.html?recommendPhone=";

}
