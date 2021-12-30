import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Manager manager =new Manager();
        int choice;
        do {
            System.out.println();
            System.out.println("❀________________꧁☆☬ⓂⒺⓃⓊ☬☆꧂___________________❀");
            System.out.println("| 1. Nhập thêm sinh viên                             |");
            System.out.println("| 2. Sửa sinh viên theo mã sinh viên                 |");
            System.out.println("| 3. Xóa sinh viên theo mã sinh viên                 |");
            System.out.println("| 4. Hiển thị sinh viên theo mã sinh viên            |");
            System.out.println("| 5. Hiển thị danh sách sinh viên theo điểm tăng dần |");
            System.out.println("| 6. Hiển thị sinh viên có điểm cao nhất             |");
            System.out.println("| 7. Ghi danh sách sinh viên ra file                 |");
            System.out.println("| 8. Đọc/ Hiển thị danh sách sinh viên (từ file)     |");
            System.out.println("| 0. Thoát                                           |");
            System.out.println("+----------------------------------------------------+");
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
                    manager.fixStudent();
                    break;
                case 3:
                    manager.deleteStudent();
                    break;
                case 4:
                    Student student = manager.findStudent();
                    if (student != null){
                        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n", "", "ID", "Tên", "Tuổi", "Điểm Toán", "Điểm lý", "Điểm Hóa");
                        System.out.println(student.toString());
                    } else {
                        System.out.println("Không tìm thấy ID trùng");
                    }
                    break;
                case 5:
                    ArrayList<Student> studentsList = manager.listStudentByPoint1();
                    System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n", "", "ID", "Tên", "Tuổi", "Điểm Toán", "Điểm lý", "Điểm Hóa");
                    studentsList.forEach(System.out::println);
                    break;
                case 6:
                    ArrayList<Student> studentsMaxPoint = manager.studentByPointMax();
                    System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n", "", "ID", "Tên", "Tuổi", "Điểm Toán", "Điểm lý", "Điểm Hóa");
                    studentsMaxPoint.forEach(System.out::println);
                    break;
                case 7:
                    manager.writeFile(Manager.getStudents(), Manager.PATH_NAME);
                    break;
                case 8:
                    ArrayList<Student> students = manager.readFile(Manager.PATH_NAME);
                    System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n", "", "ID", "Tên", "Tuổi", "Điểm Toán", "Điểm lý", "Điểm Hóa");
                    students.forEach(System.out::println);
                    break;
            }
        } while (true);
    }
}
