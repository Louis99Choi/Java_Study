// Java21-2-Lab1-32184731-√÷√¢»Ø

// change file extension to Gif.
public class GifConverter extends FormatConverter {

	public GifConverter() {
		super("gif"); // basic constructor, reset the super class' extension "gif".
	}

	// Noticing annotation to Compiler,
	// Override(be implemented) super class' abstract method.
	@Override
	public void save(String fileNameWithoutExt) {
		System.out.println("Save image converted to " + fileNameWithoutExt 
				+ "." + getExt());
	}
}
