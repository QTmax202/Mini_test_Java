import java.time.LocalDate;

public class ScienceBook extends Book{
    private String category;

    public ScienceBook(String name, double price, int quantity, LocalDate input, String category) {
        super(name, price, quantity, input);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", Science book { "+
                "Caregory=" + category +
                " }"
                ;
    }
}
