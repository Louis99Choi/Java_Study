// Java21-2-Lab2-32184731-√÷√¢»Ø


import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageGrayscale implements IProcessor {

	@Override
	public String name() {
		return "Grayscale";
	}
	@Override
	public BufferedImage process(BufferedImage image){
		return grayscale(image);
	}


	public static BufferedImage grayscale(BufferedImage	image) {
		//if (image == null) return null;
		
		BufferedImage outImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
		
		for (int y = 0; y < image.getHeight(); y++) {
			
			for (int x = 0; x < image.getWidth(); x++) {
				
				Color c = new Color(image.getRGB(x, y));
				
				// NTSC brightness formula
				int b = (int) (c.getRed() * 0.299) + (int)(c.getGreen() * 0.587) 
						+ (int) (c.getBlue() * 0.114);
				
				Color grayColor = new Color(b,b,b);
				
				outImage.setRGB(x, y, grayColor.getRGB());
			}
		}
		return outImage;
	}
	
}
