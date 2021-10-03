// Java21-2-Lab2-32184731-√÷√¢»Ø

import java.awt.image.ConvolveOp;
import java.awt.image.BufferedImage;
import java.awt.image.Kernel;


public class ImageEdgeDetect implements IProcessor{
	@Override
	public String name() {
		return "ImageEdgeDetect";
	}
	@Override
	public BufferedImage process(BufferedImage image) {
		return edgeDetect(image);
	}
	public static BufferedImage edgeDetect(BufferedImage image) {
		if(image == null) return null;
		float roberts[] = {1, 1, -1, -1};

		ConvolveOp robertsOperation = new ConvolveOp(new Kernel(2, 2, roberts), ConvolveOp.EDGE_NO_OP, null);
		BufferedImage  outImage = robertsOperation.filter(image, null);
		return outImage;
	}
}
