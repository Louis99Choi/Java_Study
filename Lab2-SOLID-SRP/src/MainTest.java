
public class MainTest {

	public static void main(String[] args) {
		// SRP violation
		BookManager manager = new BookManager();
		manager.loadFromFile(); // SRP violation
		manager.show();
		manager.loadFromDB(); // SRP violation
		manager.show();

		// SRP 
		BookManager2 manager2 = new BookManager2();
		manager2.setLoader(new BookDataLoaderFromFile2());
		manager2.setViewer(new BookDataViewerConsole2());
		manager2.load();
		manager2.show();
		manager2.setLoader(new BookDataLoaderFromDB2());
		manager2.load();
		manager2.show();
	}

}
