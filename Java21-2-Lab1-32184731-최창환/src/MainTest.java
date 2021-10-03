// Java21-2-Lab1-32184731-최창환

public class MainTest {

	public static void main(String[] args) {
		System.out.println("Java21-2-Lab1-32184731-최창환 \n===== Imagae Processor & File Format Converter=====\n");
		
		// Load Image File to File Path using file searcher instance.
		FileSearcher fileSearcher = new FileSearcher("C:/user/desktop/dog.bmp");
		
		// Search File name to use file Searcher and Generate iProcessor Instance.
		ImageProcessor iProcessor = new ImageProcessor(fileSearcher.getFileName());
		
		// Set Image Processor to Gray scale and Process Gray scaling.
		iProcessor.setImageProcessor(new Grayscale());
		iProcessor.processImage();

		// Set Image Processor to Blur and Process Blur.
		iProcessor.setImageProcessor(new Blur());
		iProcessor.processImage();
		
		// add Gif, Png, Jpg Converter at converters Map, instance of iProcessor.
		iProcessor.addConverter(new GifConverter());
		iProcessor.addConverter(new PngConverter());
		iProcessor.addConverter(new JpgConverter());
		
		// Try convert to specific Extension.
		iProcessor.convertTo("bmp");
		iProcessor.convertTo("jpg");
		iProcessor.convertTo("gif");
		iProcessor.convertTo("png");
		
	}

}

