// Java21-2-Lab1-32184731-√÷√¢»Ø

// make file to gray scale.
public class Grayscale implements IProcessor {

	// Noticing annotation to Compiler,
	// Override(be implemented) super class' abstract method.
	@Override
	public void process(String fileName) {
		System.out.println("Convert " + fileName + " to Grayscale");
	}
	

}
