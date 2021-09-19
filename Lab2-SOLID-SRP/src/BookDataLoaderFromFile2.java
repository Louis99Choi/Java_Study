import java.util.ArrayList;
import java.util.List;

public class BookDataLoaderFromFile2 extends BookDataLoader2 {

	@Override
	public List<Book2> load() {
		System.out.println("read books info from a file");
		Book2 b1 = new Book2("Eric et al", 200, 100, "1234");
		Book2 b2 = new Book2("Park et al", 2021, 200, "5678");
		List<Book2> books = new ArrayList<>();
		books.add(b1);
		books.add(b2);
		return books;
	}

}
