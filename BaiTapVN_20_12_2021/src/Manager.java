import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Manager {
    static Set<Animal> animals;
    Scanner input = new Scanner(System.in);

    public Manager() {
        this.animals = new HashSet<Animal>();
    }

    public static Animal createAnimal(Scanner input, int choice) {
        input.nextLine();
        System.out.print("Nhập tên : ");
        String name = input.nextLine();
        name = checkName(name, input);
        System.out.print("Nhập tuổi: ");
        int age = input.nextInt();
        System.out.print("Nhập cân nặng: ");
        double weight = input.nextDouble();
        switch (choice) {
            case 1:
                return new Animal(name, age, weight);
            case 2:
                input.nextLine();
                System.out.print("Nhập địa điểm sinh sống: ");
                String address = input.nextLine();
                return new Dog(name, age, weight, address);
            case 3:
                input.nextLine();
                System.out.print("Nhập địa điểm sinh sống: ");
                String address1 = input.nextLine();
                return new Cat(name, age, weight, address1);
            case 4:
                input.nextLine();
                System.out.print("Nhập địa điểm sinh sống: ");
                String address2 = input.nextLine();
                return new Mouse(name, age, weight, address2);
            default:
                return null;
        }
    }

    public static String checkName(String name, Scanner input){
        for (Animal animal : animals) {
            while (animal.getName().equals(name)) {
                System.out.print("Nhập lại tên: ");
                name = input.nextLine();
            }
        }
        return name;
    }

    public void addAnimal(int choice) {
        animals.add(createAnimal(input, choice));
    }

    public void deleteByName() {
        input.nextLine();
        System.out.print("Nhập tên muốn xóa: ");
        String name = input.nextLine();
        animals.removeIf(animal -> animal.getName().equals(name));
    }

    public void displayAnimal() {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", "Tên", "Tuổi", "Cân nặng", "Tốc độ", "Tiếng kêu", "Nơi ở");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public void displayAnimalByName(){
        input.nextLine();
        System.out.print("Nhập tên muốn hiển thị: ");
        String name = input.nextLine();
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", "Tên", "Tuổi", "Cân nặng", "Tốc độ", "Tiếng kêu", "Nơi ở");
                System.out.println(animal);
            } else {
                System.out.println("Không có con vật nào thỏa mãn!");
            }
        }
    }

    public void findAnimal(){
        input.nextLine();
        System.out.print("Nhập tên muốn sửa: ");
        String name = input.nextLine();
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                input.nextLine();
                System.out.print("Nhập tên mới: ");
                String name1 = input.nextLine();
                if (name1.equals("")){
                    animal.setName(animal.getName());
                } else {
                    animal.setName(name1);
                }
                System.out.print("Nhập tuổi mới: ");
                animal.setAge(input.nextInt());
                System.out.print("Nhập cân nặng mới: ");
                animal.setWeight(input.nextDouble());
                if (animal instanceof Dog){
                    input.nextLine();
                    System.out.print("Nhập địa điểm sinh sống mới: ");
                    Dog dog = (Dog)animal;
                    dog.setAddress(input.nextLine());
                } else if (animal instanceof Cat){
                    input.nextLine();
                    System.out.print("Nhập địa điểm sinh sống mới: ");
                    Cat cat = (Cat)animal;
                    cat.setAddress(input.nextLine());
                } else if (animal instanceof Mouse){
                    input.nextLine();
                    System.out.print("Nhập địa điểm sinh sống mới: ");
                    Mouse mouse = (Mouse) animal;
                    mouse.setAddress(input.nextLine());
                }
            }
        }
    }

    public void displayAnimalOfDog(){
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", "Tên", "Tuổi", "Cân nặng", "Tốc độ", "Tiếng kêu", "Nơi ở");
        for (Animal animal : animals) {
            if (animal instanceof Dog){
                System.out.println(animal);
            }
        }
    }

    public void displayAnimalByWeightRange(){
        System.out.println("Nhập cân nặng dưới: ");
        int minWeight = input.nextInt();
        System.out.println("Nhập cân nặng trên: ");
        int maxWeight = input.nextInt();
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", "Tên", "Tuổi", "Cân nặng", "Tốc độ", "Tiếng kêu", "Nơi ở");
        for (Animal animal : animals){
            if (animal.getWeight() >= minWeight & animal.getWeight() <= maxWeight){
                System.out.println(animal);
            }
        }
    }
}
