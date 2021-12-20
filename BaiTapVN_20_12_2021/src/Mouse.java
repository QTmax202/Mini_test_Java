public class Mouse extends Animal implements AnimalManager{
    private String address;
    public Mouse(String name, int age, double weight, String address) {
        super(name, age, weight);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int run() {
        return 2;
    }

    @Override
    public String makeSound() {
        return "Chitt...chit..";
    }

    @Override
    public String toString() {
        return super.toString()+ String.format("%-15d%-15s%-15s",run(),makeSound(),getAddress());
    }
}
