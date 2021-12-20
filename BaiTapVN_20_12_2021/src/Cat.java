public class Cat extends Animal implements AnimalManager{
    private String address;

    public Cat(String name, int age, double weight, String address) {
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
        return 3;
    }

    @Override
    public String makeSound() {
        return "Meoww...meow..";
    }

    @Override
    public String toString() {
        return super.toString()+ String.format("%-15d%-15s%-15s",run(),makeSound(),getAddress());
    }
}
