import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    public static ArrayList<Student> students;
    Scanner input = new Scanner(System.in);
    public static final String PATH_NAME = "src/student.csv";

    public Manager() {
        students = readFile(PATH_NAME);
    }

    public static ArrayList<Student> getStudents() {
        return students;
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
        writeFile(students, PATH_NAME);
        return student;
    }

    public int checkAge(int age, Scanner input) {
        while (age < 18 || age > 60) {
            System.out.print("sai khoang tuoi: ");
            age = input.nextInt();
        }
        return age;
    }

    public double checkAPoint(double piont, Scanner input) {
        while (piont < 0 || piont > 10) {
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
                return this.choiceSex(input);
        }
    }

    public void displayStudent() {
        for (Student student : students) {
            System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "", "Tên", "Tuổi", "Giới tính", "Nơi ở", "Điểm trung bình");
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
        writeFile(students, PATH_NAME);
    }

    public void displayStudentByPoint() {
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "", "Tên", "Tuổi", "Giới tính", "Nơi ở", "Điểm trung bình");
        for (Student student : students) {
            if (student.getAgePoint() >= 7.5) {
                System.out.println(student);
            }
        }
    }

    public void displayStudentByFrom() {
        for (Student student : students) {
            if (student.getAgePoint() >= 8) {
                System.out.printf("%s- %.2f- %s\n", student.getName(), student.getAgePoint(), "loai gioi");
            } else if (student.getAgePoint() >= 6) {
                System.out.printf("%s- %.2f- %s\n", student.getName(), student.getAgePoint(), "loai kha");
            } else if (student.getAgePoint() >= 4.5) {
                System.out.printf("%s- %.2f- %s\n", student.getName(), student.getAgePoint(), "loai trung binh");
            } else {
                System.out.printf("%s- %.2f- %s\n", student.getName(), student.getAgePoint(), "loai yeu");
            }
        }
    }

    public void findStudent() {
        boolean check = false;
        input.nextLine();
        System.out.print("Nhap ten sinh vien can sua: ");
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
                check = true;
            }
        }
        if (check) {
            System.out.println("Sửa thành công!");
        } else {
            System.out.println("Sửa không thành công!");
        }
        writeFile(students, PATH_NAME);
    }

    public void writeFile(ArrayList<Student> students, String path) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            for (Student student : students) {
                bufferedWriter.write(student.getName() + "," + student.getAge() + ","
                        + student.getSex() + "," + student.getAddress() + "," + student.getAgePoint() +"\n");
            }
            bufferedWriter.close();
            System.out.println("Write file successfully!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Student> readFile(String path) {
        ArrayList<Student> students = new ArrayList<>();
        File file = new File(PATH_NAME);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
                students.add(new Student(strings[0], Integer.parseInt(strings[1]), strings[2], strings[3], Double.parseDouble(strings[4])));
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return students;
    }
}
