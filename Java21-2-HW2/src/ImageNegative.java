// Java21-2-Lab2-32184731-√÷√¢»Ø


import java.awt.*;
import java.awt.image.BufferedImage;


public class ImageNegative implements IProcessor{

	@Override
	public BufferedImage process(BufferedImage image) {
		return negative(image);
	}

	@Override
	public String name() {
		return "Negative";
	}


	public static BufferedImage negative(BufferedImage image) {
		//if (image == null) return null;

		BufferedImage outImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

		// generate new image from Inverted color.
		for (int y = 0; y < image.getHeight(); y++) {
			
			for (int x = 0; x < image.getWidth(); x++) {

				Color c = new Color(image.getRGB(x, y));

				// Invert Algorithm.
				int r = (int) (255 - c.getRed());
				int g = (int) (255 - c.getGreen());
				int b = (int) (255 - c.getBlue());

				
				Color invertColor = new Color(r,g,b);

				outImage.setRGB(x, y, invertColor.getRGB());
			}

		}
		
		return outImage;

	}
}