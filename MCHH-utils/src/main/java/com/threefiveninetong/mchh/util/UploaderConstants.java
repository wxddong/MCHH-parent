package com.threefiveninetong.mchh.util;
public class UploaderConstants {

	public static int UPLOAD_IMAGE_WIDTH = 600; // wap上传图片，宽最大为此值，
	public static int UPLOAD_IMAGE_HEIGHT = 600; // wap上传图片，高最大为此值，
	public static String PATH = "/ueditorImages/";
	private static String UPLOAD_PATH;

	/**
	 * 获取上传路径
	 * 
	 * @return
	 */
	public static String getUploadPath() {
		if (!StringUtil.isNullOrBlank(UPLOAD_PATH)) {
			return UPLOAD_PATH;
		}
		UPLOAD_PATH = ConfigUtils.getStringByKey("sys.upload.path.ueditorImages");
		return UPLOAD_PATH;
	}
	
}
