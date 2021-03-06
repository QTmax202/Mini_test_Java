import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        ManagePerson managePerson = new ManagePerson(list);
        Scanner input = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm người vào danh sách");
            System.out.println("3. Tìm vị trí một người trong danh sách");
            System.out.println("4. Xoá 1 người trong danh sách theo mã");
            System.out.println("5. Sửa thông tin của 1 người theo mã");
            System.out.println("6. Sắp xếp danh sách theo điểm trung bình");
            System.out.println("7. Tính tổng điểm");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    managePerson.displayPerson();
                    break;
                case 2:
                    int choice1;
                    do {
                        System.out.println("1. Người");
                        System.out.println("2. Sinh viên");
                        System.out.print("Nhập lựa chọn của bạn: ");
                        choice1 = input.nextInt();
                        switch (choice1) {
                            case 1:
                                managePerson.addPerson(choice1);
                                break;
                            case 2:
                                managePerson.addPerson(choice1);
                                break;
                        }
                    } while (choice1 != 0);
                    break;
                case 3:
                    managePerson.findPerson();
                    break;
                case 4:
                    managePerson.deletePerson();
                    break;
                case 5:
                    managePerson.fixperson();
                    break;
                case 6:
                    managePerson.sortTheList();
                    break;
                case 7:
                    managePerson.totalAveragePoint();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while (choice != 0);
    }
}
