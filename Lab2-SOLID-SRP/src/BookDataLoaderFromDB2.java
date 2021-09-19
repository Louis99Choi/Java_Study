import java.util.ArrayList;
import java.util.List;

public class BookDataLoaderFromDB2 extends BookDataLoader2 {

	@Override
	public List<Book2> load() {
		System.out.println("read books info from a DB");
		Book2 b1 = new Book2("Kim et al", 300, 5000, "abc");
		Book2 b2 = new Book2("Lee et al", 4021, 6000, "def");
		List<Book2> books = new ArrayList<>();
		books.add(b1);
		books.add(b2);
		return books;
	}

}
