// Java21-2-Lab1-32184731-ÃÖÃ¢È¯

// abstract class for file extension format converting (ex_ bmp > png)
public abstract class FormatConverter {
	private String ext; // extension of File
	
	public FormatConverter(String ext) {
		this.ext = ext; // Constructor
	}

	public String getExt() {
		return ext; // getter of extension
	}

	public abstract void save(String fileNameWithoutExt); // save file as child class extension.
}
