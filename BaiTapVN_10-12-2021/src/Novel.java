import java.time.LocalDate;

public class Novel extends Book {
    private String author;

//    public Novel() {
//    }

    public Novel(String name, double price, int quantity, LocalDate input, String author) {
        super(name, price, quantity, input);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Novel book{ " +
                "Author=" + author +
                " }"
                ;
    }
}
