// Java21-2-Lab1-32184731-√÷√¢»Ø


import java.util.HashMap;
import java.util.StringTokenizer;

// Image Processing(change scale or extension) class
public class ImageProcessor {
	
	private String fileName;
	private IProcessor processor;
	private HashMap<String, FormatConverter> converters = new HashMap<>(); // generate converters map from HashMap.
	
	// getter for maintenance.
	public String getFileName() {
		return fileName;
	}
	
	public IProcessor getProcessor() {
		return processor;
	}
	
	public void setImageProcessor(IProcessor processor) {
		this.processor = processor;
	}
	//
	public HashMap<String, FormatConverter> getConverters() {
		return converters;
	}
	
	protected ImageProcessor() {} // Basic constructor.
	
	// Constructor for reset this.fileName .
	public ImageProcessor(String fileName) {
		this.fileName = fileName;
	}
	
	// add specific Converter in converters Map as elements <key="ext", value=converter>.
	public void addConverter(FormatConverter converter) {
		this.converters.put(converter.getExt(), converter);
	}
	
	// Convert the image to the specific extension what to re-set(ext).
	public void convertTo(String extension) {	
		
		// Do convertTo normally, if there is 'ext'Converter in converters Map.
		if (converters.containsKey(extension)) {
			StringTokenizer tokenizer = new StringTokenizer(this.fileName, "."); // seperate fileName from Extension.
			
			String fileNameWithoutExtension = tokenizer.nextToken(); // put seperated fileName in variable(fileNameWithoutExt).
			
			this.fileName = (fileNameWithoutExtension + "." + extension); // Re-set fileName with new format.
			
			converters.get(extension).save(fileNameWithoutExtension); // print out file format convert Log.
		}
		// Print Error message, if there is no corresponding Extension Name in converters Map.
		else {
			System.out.println("\nThere is No [." + extension + "] converter in Converters Packages."
					+ "\n--Please add the Converter or Check Extension Name!--\n");
		}
		
	}
	
	// Method, execute this.processor's process() 
	// to scaling Image file such 'Blur' or 'Gray scale' and else.
	public void processImage() {
		this.processor.process(this.fileName);
	}
}
