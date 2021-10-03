import java.util.StringTokenizer;

// Java21-2-Lab1-32184731-√÷√¢»Ø

// Seperate FileName and Folder Path at FilePath class.
public class FileSearcher {
	private String filePath;
	private String folderPath = "";
	private String fileName = "";
	
	public String getFilePath() {
		return filePath;
	}
	public String getFolderPath() {
		return folderPath;
	}
	public String getFileName() {
		return fileName;
	}
	
	public FileSearcher() {} // Basic Constructor.
	
	// Constructor, set filePath, folderPath and fileName using Tokenizer.
	public FileSearcher(String filePath) {
		this.filePath = filePath;
		
		StringTokenizer token_Path = new StringTokenizer(this.filePath, "/");
		
		int num_token = token_Path.countTokens();
		
		for (int i = 0; i < num_token; i++) {
			if(i < (num_token-1)) {
				this.folderPath += (token_Path.nextToken()+"/");
			}else {
				// System.out.println(this.folderPath);  // checking Point
				this.fileName = token_Path.nextToken();
				// System.out.println(this.fileName);  // checking Point
			}
		}
	}
	
	
	
	
}
