/**
 * Project Name:credit-sdk
 * File Name:ImageUtil.java
 * Package Name:com.huarong.credit.sdk.utils
 * Date:2020年10月16日下午4:16:17
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.utils;

import java.io.File;

import cn.hutool.core.io.FileUtil;
import net.coobird.thumbnailator.Thumbnails;

/**
 * ClassName:图片处理工具类 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年10月16日 下午4:16:17 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
public class ImageUtil {

	public static void main(String[] args) throws Exception {
		ImageUtil.scaleImages(FileUtil.file("D:\\certs\\test\\002.jpg"), FileUtil.file("D:\\certs\\test\\003.jpg"));
	}

	/**
	 * 图片缩放(300KB以内)
	 * 
	 * @Title: scaleImages
	 * @Description: 图片缩放，处理分辨率级大小过大问题
	 * @param imageFile
	 * @param outFile
	 * @throws Exception
	 */
	public static void scaleImages(File imageFile, File outFile) throws Exception {
		long size = FileUtil.size(imageFile);
		double scale = 1.0d;
		if (size >= 300 * 1024) {
			if (size > 0) {
				scale = (300 * 1024f) / size;
			}
		}
		try {
			if (size < 300 * 1024) {
				Thumbnails.of(imageFile).size(1080, 1080).outputFormat("jpg").toFile(outFile);
			} else {
				Thumbnails.of(imageFile).size(1080, 1080).outputQuality(scale).outputFormat("jpg")
						.toFile(outFile);
			}

		} catch (Exception e) {
			throw new Exception("图片尺寸转换失败", e);
		}
	}
}
