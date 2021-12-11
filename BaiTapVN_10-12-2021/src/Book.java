import java.time.LocalDate;

public class Book {
    private String name;
    private double price;
    private int quantity;
    private LocalDate publicationDate;
    public static double sum = 0;

    public Book(String name, double price, int quantity, LocalDate input) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.publicationDate = input;
        sum += price* quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "Book {" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
