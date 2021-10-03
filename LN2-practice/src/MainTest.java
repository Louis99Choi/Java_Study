
public class MainTest {

	public static void main(String[] args) {
		BookManager manager = new BookManager();
		manager.loadFromFile(); //SRP violation
		manager.show();
		manager.loadFromFile(); // SRP violation
		manager.show();
		
		
		BookManager2 manager2 = new BookManager2();
		manager2.setLoader(new BookDataLoaderFromFile2());
		manager2.setViewer(new BookDataViewerConsole2());
		manager2.load();
		manager2.show();
		System.out.println("================================");
		
		manager2.setLoader(new BookDataLoaderFromDB2());
		manager2.load();
		manager2.show();
		
		
	}

}
