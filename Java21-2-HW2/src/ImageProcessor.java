// Java21-2-Lab2-32184731-√÷√¢»Ø


import java.awt.image.BufferedImage;


public class ImageProcessor {
	private IProcessor processor = null;

	public ImageProcessor(IProcessor processor) {
		this.processor = processor;
	}

	public IProcessor getProcessor() {
		return processor;
	}

	public void setProcessor(IProcessor processor) {
		this.processor = processor;
	}



	// processing image process as one file
	public void process(String filename) {
		BufferedImage image = ImageUtil.load(filename);

		BufferedImage oImage = processor.process(image);

		String format = ImageUtil.getExtension(filename);
		String oFile =
				ImageUtil.getFullpathWithoutExt(filename)
				+ processor.name() + "."
				+ ImageUtil.getExtension(filename);
		ImageUtil.save(oImage, format, oFile);
	}


	// processing image process as array of files.
	public void process(String[] filenames) {
		for(var filename : filenames) {
			process(filename);
		}


	}
	
	
}
