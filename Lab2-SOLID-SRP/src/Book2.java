
public class Book2 {
	String author;
	int publishedYear;
	double price;
	String isbn;
	
	public Book2(String author, int publishedYear, double price, String isbn) {
		this.author = author;
		this.publishedYear = publishedYear;
		this.price = price;
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book2 [author=" + author + ", publishedYear=" + publishedYear + ", price=" + price + ", isbn=" + isbn
				+ "]";
	}
}
