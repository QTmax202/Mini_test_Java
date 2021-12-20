import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Manager manager = new Manager();

        int choice;
        do {
            System.out.println("menu");
            System.out.println("1. Thêm 1 con vật vào tập hợp");
            System.out.println("2. Xóa 1 con vật vào tập hợp theo tên");
            System.out.println("3. Sửa 1 con vật theo tên");
            System.out.println("4. Hiển thị thông tin 1 con vật theo tên nhập vào");
            System.out.println("5. Hiển thị tất cả các con vật trong tập hợp");
            System.out.println("6. Trả về tất cả các con Dog trong tập hợp");
            System.out.println("7. Trả về tất cả các con vật trong khoảng cân nặng được nhập vào");
            System.out.print("Nhập lựa chọn: ");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    int choice1;
                    do {
                        System.out.println("1. Dộng vật");
                        System.out.println("2. Chó");
                        System.out.println("3. Mèo");
                        System.out.println("4. Chuột");
                        System.out.print("Nhập lựa chon: ");
                        choice1 = input.nextInt();
                        if (choice1 != 0){
                            manager.addAnimal(choice1);
                        }
                    } while (choice1 != 0);
                    break;
                case 2:
                    manager.deleteByName();
                    break;
                case 3:
                    manager.findAnimal();
                    break;
                case 4:
                    manager.displayAnimalByName();
                    break;
                case 5:
                    manager.displayAnimal();
                    System.out.println();
                    break;
                case 6:
                    manager.displayAnimalOfDog();
                    break;
                case 7:
                    manager.displayAnimalByWeightRange();
                    break;
            }
        } while (choice != 0);
    }
}
