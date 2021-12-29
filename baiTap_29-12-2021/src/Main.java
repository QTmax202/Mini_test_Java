import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Manager manager = new Manager();

        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Nhập thêm sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Sửa sinh viên theo tên sinh viên");
            System.out.println("4. Xóa sinh viên theo tên sinh viên");
            System.out.println("5. Hiển thị danh sách sinh viên có điểm trung bình trên 7.5");
            System.out.println("6. Hiển thị danh sách sinh viên theo cú pháp(tên- điểm trung binh- xếp loại");
            System.out.println("7. Ghi danh sách sinh viên ra file");
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
                    manager.findStudent();
                    break;
                case 4:
                    manager.deleteStudent();
                    break;
                case 5:
                    manager.displayStudentByPoint();
                    break;
                case 6:
                    manager.displayStudentByFrom();
                    break;
                case 7:
                    manager.export();
                    break;
            }
        } while (choice != 0);
    }
}
