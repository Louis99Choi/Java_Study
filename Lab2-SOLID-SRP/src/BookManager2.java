import java.util.ArrayList;
import java.util.List;

public class BookManager2 {
	private List<Book2> books = null;
	private BookDataLoader2 loader = null;
	private BookDataViewer2 viewer = null;
	
	public BookManager2() {
		this(null);
	}
	
	public BookManager2(List<Book2> books) {
		this.books = books;
	}
/*	
	public void loadFromFile() {
		System.out.println("read books info from a file");
		Book2 b1 = new Book2("Eric et al", 200, 100, "1234");
		Book2 b2 = new Book2("Park et al", 2021, 200, "5678");
		books = new ArrayList<>();
		books.add(b1);
		books.add(b2);
	}

	public void loadFromDB() {
		System.out.println("read books info from a DB");
		Book2 b1 = new Book2("Kim et al", 300, 5000, "abc");
		Book2 b2 = new Book2("Lee et al", 4021, 6000, "def");
		books = new ArrayList<>();
		books.add(b1);
		books.add(b2);
	}
*/
	public BookDataLoader2 getLoader() {
		return loader;
	}

	public void setLoader(BookDataLoader2 loader) {
		this.loader = loader;
	}

	public BookDataViewer2 getViewer() {
		return viewer;
	}

	public void setViewer(BookDataViewer2 viewer) {
		this.viewer = viewer;
	}

	public void load() {
		books = this.loader.load();
	}	

	public void show() {
		this.viewer.show(books);
	}
}
