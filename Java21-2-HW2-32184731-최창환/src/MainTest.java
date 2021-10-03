// Java21-2-HW2-32184731-최창환

public class MainTest {
	static IProcessor[] processors = {
			new ImageGrayscale(),
			new ImageNegative(),
			new ImageBlur(),
			new ImageEdgeDetect()
	};
	
	static String[] imageFiles = {
			"C:/images/bird.jpg", 
			"C:/images/dog.jpg", 
			"C:/images/lake.jpg", 
			"C:/images/tiger.jpg"
	};

	public static void main(String[] args) {
		System.out.println("Java21-2-Lab2-32184731-최창환\n");
		System.out.println("This is Image Processing Program");
		for (IProcessor processor : processors) {
			ImageProcessor ip = new ImageProcessor(processor);
			
			ip.process(imageFiles);
		}
		
		
	}
}