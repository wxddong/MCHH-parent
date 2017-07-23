package com.threefiveninetong.mchh.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class FileUtil {

    private static final String prodectName = "lCDTimeTaskTwo";

    private static final String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    public static String copyDirectory(String path, String targetPath) {
        return null;
    }

    public static String copyFile(String path, String targetPath) {
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            FileInputStream in;
            try {
                in = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
            return copyFile(in, targetPath, null);
        }
        return null;
    }

    public static String copyFile(InputStream in, String targetPath, String targetNewName) {
        targetPath += File.separator;
        File targetFile = new File(targetPath);
        createDirectory(targetFile);
        try {
            FileOutputStream out = new FileOutputStream(targetPath + targetNewName);
            copyFile(in, out);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return targetPath + targetNewName;
    }

    public static void copyFile(InputStream in, OutputStream out) {
        try {
            byte[] buffer = new byte[1024 * 1024];
            int bytesum = 0;
            int byteread = 0;
            while ((byteread = in.read(buffer)) != -1) {
                bytesum += byteread;
                out.write(buffer, 0, byteread);
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void cut(String oldPath, String newPath) {
        File dir = new File(oldPath);
        if (!dir.exists()) {
            throw new IllegalArgumentException("找不到文件：" + oldPath);
        }
        // 目标
        File moveDir = new File(newPath);
        if (!moveDir.exists()) {
            moveDir.mkdirs();
        }
        if (dir.isDirectory()) {
            // 文件一览
            File[] files = dir.listFiles();
            if (files == null)
                return;
            // 文件移动
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    cut(files[i].getPath(), newPath + File.separator + files[i].getName());
                }
                File moveFile = new File(moveDir.getPath() + File.separator + files[i].getName());
                // 目标文件夹下存在的话，删除
                if (moveFile.exists()) {
                    moveFile.delete();
                }
                files[i].renameTo(moveFile);
            }
            // 成功，删除原文件
            dir.delete();
        } else {
            if (moveDir.exists()) {
                moveDir.delete();
            }
            dir.renameTo(moveDir);
        }
    }

    public static void rename(String path, String newName) {
        File file = new File(path);
        if (file.exists()) {
            File newFile = new File(file.getParent() + File.separator + newName);
            file.renameTo(newFile);
        } else {
            throw new IllegalArgumentException("找不到文件：" + path);
        }
    }

    // 创建文件夹
    public static void createDirectory(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static boolean delete(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        } else {
            if (file.isFile()) {
                return deleteFile(path);
            } else {
                return deleteDirectory(path);
            }
        }
    }

    public static boolean deleteFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            flag = file.delete();
        }
        return flag;
    }

    public static boolean deleteDirectory(String path) {
        // 补全文件分隔符
        path += File.separator;
        File dirFile = new File(path);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        boolean flag = true;
        // 删除文件夹下的所有文件(包括子目录)
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag)
                    break;
            } // 删除子目录
            else {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag)
                    break;
            }
        }
        if (!flag)
            return false;
        // 删除当前目录
        if (dirFile.delete()) {
            return true;
        } else {
            return false;
        }
    }

    public static String getRootPath() {
        int index = rootPath.indexOf(prodectName);
        if (index != -1) {
            return rootPath.substring(0, index + prodectName.length());
        } else {
            throw new RuntimeException("Prodect name in the FileUtil is wrong.");
        }
    }

    public static String getClassesPath() {
        return FileUtil.class.getResource("/").getPath();
    }

    public static String getParentPath(String path) {
        if (path != null) {
            File file = new File(path);
            if (file.exists()) {
                return file.getParent();
            }
        }
        return null;
    }

    public static String parsePath(String path) {
        if (path != null) {
            File file = new File(path);
            if (file.exists()) {
                return file.getPath();
            }
        }
        return null;
    }

}
