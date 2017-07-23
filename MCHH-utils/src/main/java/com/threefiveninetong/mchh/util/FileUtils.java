package com.threefiveninetong.mchh.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件读写工具
 * @author guoyy
 *
 */
public final class FileUtils {
	private static Logger logger = LoggerFactory.getLogger(FileUtils.class);
	/**
	 * 把内容写到文件
	 * @param filePathName
	 * 文件名
	 * @param List
	 * <String> 文件内容
	 */
	public static boolean writerFile(String filePathName, String content) {
		boolean flag = false;
		OutputStreamWriter osw = null;
		try {
			if (filePathName != null && !"".equals(filePathName)) {
				osw = new OutputStreamWriter(new FileOutputStream(filePathName),"UTF-8");
			}
		} catch (Exception e1) {
			flag = false;
			logger.error("write error", e1);
		}
		if (osw != null) {
			BufferedWriter bw = new BufferedWriter(osw);
			try {
				if (content != null && !"".equals(content)) {
					bw.write(content);
					flag = true;
				}
			} catch (IOException e) {
				flag = false;
				logger.error("write error", e);
			} finally {
				try {
					bw.close();
					osw.close();
				} catch (IOException e) {
					flag = false;
				}
			}
		}
		return flag;
	}

}
