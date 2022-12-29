import java.util.ArrayList;

public class Library {
    // library is composed of many books "composition"
    ArrayList<Book> listOfBooks;

    public Library() {
        listOfBooks = new ArrayList<>(10);
    }

    public void printAllBooks() {
        for (Book b : listOfBooks) {
            System.out.printf("%s - %d\n", b.getTitle(), b.computeShelfLife());
        }
    }

    public void addBook(Book n) {
        listOfBooks.add(n);
    }
}
