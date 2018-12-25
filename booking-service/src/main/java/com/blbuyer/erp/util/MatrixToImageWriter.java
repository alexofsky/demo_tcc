package com.blbuyer.erp.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.common.BitMatrix;
import com.thoughtworks.xstream.core.util.Base64Encoder;

public class MatrixToImageWriter {
	private static final int BLACK = 0xFF000000; // 用于设置图案的颜色
	private static final int WHITE = 0xFFFFFFFF; // 用于背景色
	public MatrixToImageWriter() {
		super();
	}
	
	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y,  (matrix.get(x, y) ? BLACK : WHITE));
//				image.setRGB(x, y,  (matrix.get(x, y) ? Color.YELLOW.getRGB() : Color.CYAN.getRGB()));
			}
		}
		return image;
	}
	
	/**
	
	 * <p>Title: writeToFile</p>
	 
	 * <p>Description: image --> base64</p>
	
	 * @author  Xia Hao
	 * @param matrix
	 * @param format
	 * @return
	 * @throws IOException
	 */
	public static String writeToFile(BitMatrix matrix, String format) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();  
		ImageIO.write(image, format, outputStream);
		Base64Encoder encoder = new Base64Encoder();
		String base64 = "data:image/png;base64," + encoder.encode(outputStream.toByteArray());
		return base64;
	}
}
