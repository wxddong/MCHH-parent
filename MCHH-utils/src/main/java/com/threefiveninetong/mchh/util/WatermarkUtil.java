package com.threefiveninetong.mchh.util;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class WatermarkUtil {
	public  static String  png = ConfigUtils.getStringByKey("sys.upload.path")+"/watermark.png";
	
	/**
	 * 加水印
	 * @param imagePath
	 * @param compressPath
	 */
	public static void compressImage(String imagePath, String compressPath) {
		try {
			BufferedImage image = ImageIO.read(new File(imagePath));
			int width = image.getWidth();
			int height = image.getHeight();
			Thumbnails.of(imagePath).size(width, height).watermark(
					Positions.BOTTOM_RIGHT,
					ImageIO.read(new File(png)), 0.5f)
					.outputQuality(1).toFile(compressPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void compressImage(String imagePath, float scale,String compressPath) {
		try {
			Thumbnails.of(imagePath).scale(scale).toFile(compressPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
