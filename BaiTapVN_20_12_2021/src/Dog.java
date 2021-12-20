public class Dog extends Animal implements AnimalManager{
    public String address;

    public Dog(String name, int age, double weight, String address) {
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
        return 4;
    }

    @Override
    public String makeSound() {
        return "gaooo...Gao..";
    }

    @Override
    public String toString() {
        return super.toString()+ String.format("%-15d%-15s%-15s",run(),makeSound(),getAddress());
    }

}
