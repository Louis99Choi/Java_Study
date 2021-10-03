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
	
	public void load() {
		books = loader.load();
	}
	public void show() {
		this.viewer.show(books);
	}
	
	public void setLoader(BookDataLoader2 loader) {
		this.loader = loader;
	}

	public void setViewer(BookDataViewer2 viewer) {
		this.viewer = viewer;
	}
	
	public BookDataLoader2 getLoader() {
		return loader;
	}

	public BookDataViewer2 getViewer() {
		return viewer;
	}

	
	
	
	
}
