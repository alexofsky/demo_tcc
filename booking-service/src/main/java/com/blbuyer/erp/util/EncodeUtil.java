package com.blbuyer.erp.util;

import java.util.Hashtable;

import com.blbuyer.core.logging.Logger;
import com.blbuyer.core.logging.LoggerUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**

 * <p>Title: EncodeUtil</p>
 
 * <p>Description: 二维码工具类</p>

 * @author  Xia Hao

 * @date    2018年2月27日
 */
public class EncodeUtil {
	
	private static final Logger logger = LoggerUtils.getLogger(EncodeUtil.class);

	private static final int width = 430;
	private static final int height = 430;
	
	/**
	
	 * <p>Title: encodeQrCode</p>
	 
	 * <p>Description: 生成带参二维码</p>
	
	 * @author  Xia Hao
	 * @param content
	 * @return base64
	 */
	public static String encodeQrCode(String content) {
		String format = "gif";
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.MARGIN, 1);
		BitMatrix bitMatrix;
		try {
			bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
			return MatrixToImageWriter.writeToFile(bitMatrix, format);
		} catch (Exception e) {
			logger.error("生成二维码错误 ========》", e);
		}
		return null;
	}
}
