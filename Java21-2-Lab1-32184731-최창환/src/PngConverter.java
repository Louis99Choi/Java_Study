// Java21-2-Lab1-32184731-√÷√¢»Ø

// change file extension to Png.
public class PngConverter extends FormatConverter {

	public PngConverter() {
		super("png"); // basic constructor, reset the super class' extension "png".
	}

	// Noticing annotation to Compiler,
	// Override(be implemented) super class' abstract method.
	@Override
	public void save(String fileNameWithoutExt) {
		System.out.println("Save image converted to " + fileNameWithoutExt 
				+ "." + getExt() + "\n");
	}
}
