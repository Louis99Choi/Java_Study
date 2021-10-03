// Java21-2-Lab2-32184731-��âȯ

import java.awt.image.BufferedImage;
import java.awt.image.Kernel;
import java.awt.image.ConvolveOp;

//��ó���ϱ�
public class ImageBlur implements IProcessor{
	@Override
	public String name() {
		return "Blur";
	}
	@Override
	public BufferedImage process(BufferedImage image) {
		return blur(image);
	}
	public static BufferedImage blur(BufferedImage image) {
		if(image==null) return null;//�̹��������ٸ� null����
		
		int radius = 100;
		int size = radius *2 +1;
		float[] data = new float[size*size];
		float sigma = radius;
		float twoSigmaSquare = 2.0f * sigma * sigma;
		float sigmaRoot = (float)Math.sqrt(twoSigmaSquare * Math.PI);
		float total = 0.0f;
		for(int i= -radius; i<= radius; i++) {
			float distance = i*i;
			int index = i + radius;
			data[index]=(float)Math.exp(-distance/ twoSigmaSquare)/sigmaRoot;
			total+=data[index];
		}
		for(int i = 0 ; i < data.length; i ++) {
			data[i] /= total;
		}
		Kernel kernel = new Kernel(1,size,data);
		ConvolveOp convolveOp = new ConvolveOp(kernel,ConvolveOp.EDGE_NO_OP,null);
		image = convolveOp.filter(image, null);
		kernel = new Kernel(size, 1,data);
		convolveOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP,null);
		BufferedImage outImage = convolveOp.filter(image,null);
		
		return outImage;
	}
}

