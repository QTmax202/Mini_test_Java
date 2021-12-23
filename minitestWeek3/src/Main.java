import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ManagerStudent manager = new ManagerStudent();

        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Nhập thêm sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Sửa sinh viên theo mã");
            System.out.println("4. Xóa sinh viên theo mã");
            System.out.println("5. Hiển thị sinh viên theo mã");
            System.out.println("6. Hiển thị danh sách sinh viên theo điểm trung bình");
            System.out.println("7. Hiển thị sinh viên có điểm trung bình cao nhất");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println(manager.createStudent());
                    break;
                case 2:
                    manager.displayStudent();
                    break;
                case 3:
                    manager.editStudent();
                    break;
                case 4:
                    manager.deleteStudent();
                    break;
                case 5:
                    manager.displayStudentByID();
                    break;
                case 6:
                    manager.rankStudent();
                    break;
                case 7:
                    manager.dispalyStudentByPointMax();
                    break;
            }
        } while (choice != 0);
    }
}
