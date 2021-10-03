// Java21-2-Lab1-32184731-√÷√¢»Ø


// change file extension to Jpg.
public class JpgConverter extends FormatConverter {

	public JpgConverter() {
		super("jpg"); // basic constructor, reset the super class' extension "jpg".

	}

	// Noticing annotation to Compiler,
	// Override(be implemented) super class' abstract method.
	@Override
	public void save(String fileNameWithoutExt) {
		System.out.println("Save image converted to " + fileNameWithoutExt 
				+ "." + getExt());
	}
}
