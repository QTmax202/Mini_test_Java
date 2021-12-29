import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    public static ArrayList<Student> students;
    Scanner input = new Scanner(System.in);

    public Manager() {
        students = new ArrayList<>();
    }

    public Student createStudent() {
        input.nextLine();
        System.out.print("Nhap ten: ");
        String name = input.nextLine();
        System.out.print("Nhap tuoi: ");
        int age = input.nextInt();
        age = checkAge(age, input);
        String sex = choiceSex(input);
        input.nextLine();
        System.out.print("Nhap noi o: ");
        String address = input.nextLine();
        System.out.print("Nhap diem : ");
        double point = input.nextDouble();
        point = checkAPoint(point, input);
        Student student = new Student(name, age, sex, address, point);
        students.add(student);
        return student;
    }

    public int checkAge(int age, Scanner input) {
        while (age >= 18 && age <= 60) {
            System.out.print("sai khoang tuoi: ");
            age = input.nextInt();
        }
        return age;
    }

    public double checkAPoint(double piont, Scanner input) {
        while (piont >= 0 && piont <= 10) {
            System.out.print("sai khoang diem: ");
            piont = input.nextInt();
        }
        return piont;
    }

    public String choiceSex(Scanner input) {
        System.out.println("-Chon gioi tinh-");
        System.out.println("1. Nam");
        System.out.println("2. Nu");
        System.out.println("3. Orther");
        System.out.print("Nhap lua chon: ");
        int choiceSex = input.nextInt();
        switch (choiceSex) {
            case 1:
                return "Nam";
            case 2:
                return "Nu";
            case 3:
                return "Orther";
            default:
                return null;
        }
    }

    public void displayStudent() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void deleteStudent() {
        input.nextLine();
        System.out.print("Nhap ten sinh vien can xoa: ");
        String name = input.nextLine();
        Student student0 = null;
        for (Student student : students) {
            if (student.getName().equals(name)) {
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

    public void displayStudentByPoint() {
        for (Student student : students) {
            if (student.getAgePoint() >= 7.5) {
                System.out.println(student);
            }
        }
    }

    public void displayStudentByFrom() {
        for (Student student : students) {
            if (student.getAgePoint() >= 8) {
                System.out.printf("%s- %.2f- %s", student.getName(), student.getAgePoint(), "loai gioi");
            } else if (student.getAgePoint() >= 6) {
                System.out.printf("%s- %.2f- %s", student.getName(), student.getAgePoint(), "loai kha");
            } else if (student.getAgePoint() >= 4.5) {
                System.out.printf("%s- %.2f- %s", student.getName(), student.getAgePoint(), "loai trung binh");
            } else {
                System.out.printf("%s- %.2f- %s", student.getName(), student.getAgePoint(), "loai yeu");
            }
        }
    }

    public void findStudent() {
        input.nextLine();
        System.out.print("Nhap ten sinh vien can xoa: ");
        String name = input.nextLine();
        for (Student student : students) {
            if (student.getName().equals(name)) {
                input.nextLine();
                System.out.print("Nhap ten: ");
                String name1 = input.nextLine();
                if (name1.equals("")){
                    student.setName(student.getName());
                } else {
                    student.setName(name1);
                }
                System.out.print("Nhap tuoi: ");
                int age = input.nextInt();
                student.setAge(checkAge(age, input));
                student.setSex(choiceSex(input));
                input.nextLine();
                System.out.print("Nhap noi o: ");
                student.setAddress(input.nextLine());
                System.out.print("Nhap diem : ");
                double point = input.nextDouble();
                student.setAgePoint(checkAPoint(point, input));
                System.out.println("Sửa thành công!");
            }
        }
    }
    public void export(){
        try {
            BufferedWriter buff = new BufferedWriter(new FileWriter("src/student.csv"));

            StringBuilder strb = new StringBuilder();
            strb.append("Tên,");
            strb.append("Tuổi,");
            strb.append("Giới tính,");
            strb.append("Nơi ở,");
            strb.append("Điểm trung bình,");
            strb.append('\n');

            if (students.size() > 0){
                for (Student student : students) {
                    strb.append(student.getName());
                    strb.append(',');
                    strb.append(student.getAge());
                    strb.append(',');
                    strb.append(student.getSex());
                    strb.append(',');
                    strb.append(student.getAddress());
                    strb.append(',');
                    strb.append(student.getAgePoint());
                    strb.append('\n');
                }
            }
            buff.write(strb.toString());
            System.out.println("Xuất file thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
