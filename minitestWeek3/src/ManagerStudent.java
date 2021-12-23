import java.util.ArrayList;
import java.util.Scanner;

public class ManagerStudent {
    Scanner input = new Scanner(System.in);
    public static ArrayList<Student> students;

    public ManagerStudent() {
        students = new ArrayList<>();
    }

    public Student createStudent() {
        System.out.print("Nhap ID: ");
        int id = input.nextInt();
        id = checkID(id, input);
        input.nextLine();
        System.out.print("Nhap ten: ");
        String name = input.nextLine();
        System.out.print("Nhap tuoi: ");
        int age = input.nextInt();
        System.out.print("Nhap diem toan: ");
        double math = input.nextDouble();
        math = checkPoint(math, input);
        System.out.print("Nhap diem ly: ");
        double physical = input.nextDouble();
        physical = checkPoint(physical, input);
        System.out.print("Nhap diem hoa: ");
        double chemistry = input.nextDouble();
        chemistry = checkPoint(chemistry, input);
        Student student = new Student(id, name, age, math, physical, chemistry);
        students.add(student);
        return student;
    }

    public static int checkID(int id, Scanner input) {
        for (Student student : students) {
            while (student.getId() == id) {
                System.out.print("ID bị trùng, nhập lại ID: ");
                id = input.nextInt();
            }
        }
        return id;
    }

    public static double checkPoint(double point, Scanner input) {
        while (point < 0 || point > 10) {
            System.out.print("Nhap lai diem: ");
            point = input.nextDouble();
        }
        return point;
    }

    public void deleteStudent() {
        System.out.print("Nhap ID can xoa: ");
        int id = input.nextInt();
        Student student0 = null;
        for (Student student : students) {
            if (student.getId() == id) {
                student0 = student;
            }
        }
        boolean check = students.remove(student0);
        if (check) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Xóa không thành công!");
        }
    }

    public void displayStudent() {
        System.err.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Ten", "Tuoi", "diem Toan", "diem Ly", "diem Hoa", "diem trung binh");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void dispalyStudentByPointMax() {
        double max = 0;
        for (Student student : students) {
            if (student.getAvgPoint() > max) {
                max = student.getAvgPoint();
            }
        }
        System.err.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Ten", "Tuoi", "diem Toan", "diem Ly", "diem Hoa", "diem trung binh");
        for (Student student : students) {
            if (student.getAvgPoint() == max) {
                System.out.println(student);
            }
        }
    }

    public void editStudent (){
        boolean check = false;
        System.out.print("Nhập ID muốn sửa : ");
        int id = input.nextInt();
        for (Student student : students){
            if (student.getId() == id){
                check = true;
                input.nextLine();
                System.out.print("Nhập tên mới : ");
                student.setName(input.nextLine());
                System.out.print("Nhập tuổi mới : ");
                student.setAge(input.nextInt());
                System.out.print("Nhập điểm toán mới : ");
                student.setMathPoint(input.nextDouble());
                System.out.print("Nhập điểm lý mới : ");
                student.setPhysicaPoint(input.nextDouble());
                System.out.print("Nhập điểm hóa mới : ");
                student.setChemistryPoint(input.nextDouble());
                System.out.print("Sửa thành công !!!");
            }
        }
        if (!check) System.out.println("Không có ID nào phù hợp");
    }

    public void rankStudent(){
        System.err.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Ten", "Tuoi", "diem Toan", "diem Ly", "diem Hoa", "diem trung binh");
        students.sort(((o1, o2) -> (int) (o1.getAvgPoint() - o2.getAvgPoint())));
        for (Student student : students){
            System.out.println(student);
        }
    }
    public void displayStudentByID(){
        System.out.print("Nhap ID can xoa: ");
        int id = input.nextInt();
        boolean check = false;
        for (Student student : students){
            if (student.getId() == id){
                check = true;
            }
        }
        System.err.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Ten", "Tuoi", "diem Toan", "diem Ly", "diem Hoa", "diem trung binh");
        if (check){
            for (Student student : students){
                if (student.getId() == id){
                    System.out.println(student);
                }
            }
        } else {
            System.out.println("Không có ID nào phù hợp");
        }
    }
}
