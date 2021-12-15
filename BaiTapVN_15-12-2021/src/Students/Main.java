package Students;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số lượng danh sách sinh viên: ");
        int size = input.nextInt();

        Student[] students = new Student[size];
        StudentManager studentManager = new StudentManager(students);

        System.out.print("Số sinh viên cần nhập: ");
        int size1 = input.nextInt();
        if (size > size1){
            for (int i = 0; i < size1; i++){
                students(input, studentManager);
            }
        } else {
            System.out.println("Đùa!:))");
        }

        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Hiển thị sinh viên có điểm cao nhất");
            System.out.println("3. Hiển thị sinh viên có điểm thấp nhất");
            System.out.println("4. Thêm sinh viên vào danh sách");
            System.out.println("5. Xóa sinh viên khỏi danh sách(theo tên)");
            System.out.println("6. Hiển thị danh sách(theo tên)");
            System.out.println("7. Hiển thị danh sách(theo giới tính)");
            System.out.println("8. Sắp xếp danh sách(theo điểm trung bình)");
            System.out.println("9. Sửa thông tin sinh viên(theo id)");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    studentManager.displayStudent();
                    break;
                case 2:
                    studentManager.studentPointMax();
                    break;
                case 3:
                    studentManager.studentPointMin();
                    break;
                case 4:
                    students(input, studentManager);
                    break;
                case 5:
                    studentManager.deleteStudent(input);
                    break;
                case 6:
                    studentManager.displayNameStudent(input);
                    break;
                case 7:
                    studentManager.displaySexStudent(input);
                    break;
                case 8:
                    studentManager.rangStudentByAvgPoint();
                    break;
                case 9:
                    studentManager.findStudent(input);
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while (choice != 0);

    }

    public static void students(Scanner input, StudentManager StudentManager) {
        input.nextLine();
        System.out.print("Nhập tên: ");
        String name = input.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = input.nextInt();
        input.nextLine();
        System.out.print("Nhập giới tính: ");
        String sex = input.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String address = input.nextLine();
        System.out.print("Nhập điểm trung bình: ");
        double avgPoint = input.nextDouble();
        StudentManager.addStudent(name, age, sex, address, avgPoint);
    }
}
