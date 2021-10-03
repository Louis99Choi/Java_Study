import java.util.ArrayList;
import java.util.List;

public class BookManager {
	private List<Book> books = null;
	
	public BookManager() {
		this(null);
	}

	public BookManager(List<Book> books) {
		this.books = books;
	}
	
	public void loadFromFile() {
		System.out.println("read books info from a file");
		Book b1 = new Book("Eric et al", 200, 100, "1234");
		Book b2 = new Book("Park et al", 2021, 200, "5678");
		books = new ArrayList<>();
		books.add(b1);
		books.add(b2);
	}
	
	public void show() {
		for (Book book: books) {
			System.out.println("show the book info: " + book);
		}
	}
	
}
