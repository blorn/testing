public class Book {

    protected String title;
    protected String author;

    public Book() {
        this.title = "unknown";
        this.author = "unknown";
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String a) {
        this.author = a;
    }

    public int computeShelfLife() {
        return 5;
    }
}
