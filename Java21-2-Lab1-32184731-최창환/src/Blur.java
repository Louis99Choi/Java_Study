// Java21-2-Lab1-32184731-√÷√¢»Ø

// make file to Blur and print out complete message.
public class Blur implements IProcessor{

	// Noticing annotation to Compiler,
	// Override(be implemented) super class' abstract method.
	@Override
	public void process(String fileName) {
		System.out.println("Convert " + fileName + " to Blur");		
	}

}
