
public class Book {
	
	String author;
	int publishedYear;
	double price;
	String isbn;
	
	public Book(String author, int publishedYear, double price, String isbn) {
		super();
		this.author = author;
		this.publishedYear = publishedYear;
		this.price = price;
		this.isbn = isbn;
	}
	
	public void load() {
		System.out.println("read book ");
	}

	public void show() {
		System.out.println("show the book info: " + this);
	}

	@Override
	public String toString() {
		return "Book [author=" + author + 
				", publishedYear=" + 
				publishedYear + ", price="	+ 
				price + ", isbn=" + isbn
				+ "]";
	}
	
	
}
