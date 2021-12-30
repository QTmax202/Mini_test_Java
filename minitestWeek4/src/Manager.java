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
                students.add(new Student(Integer.parseInt(strings[0]), strings[1], Integer.parseInt(strings[2]), Double.parseDouble(strings[3]), Double.parseDouble(strings[4]), Double.parseDouble(strings[5])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void writeFile(ArrayList<Student> students, String path) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            for (Student student : students) {
                bufferedWriter.write(student.getId()+ "," + student.getName() + "," + student.getAge() + ","
                        +student.getMathPoint()+ "," +student.getPhysicaPoint()+ "," +student.getChemistryPoint() +"\n");
            }
            bufferedWriter.close();
            System.out.println("Write file successfully!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public Student createStudent() {
        System.out.print("Nhap ID: ");
        int id = input.nextInt();
        id = checkId(id,input);
        input.nextLine();
        System.out.print("Nhap ten: ");
        String name = input.nextLine();
        System.out.print("Nhap tuoi: ");
        int age = checkAge(input.nextInt(),input);
        System.out.print("Nhap diem Toan: ");
        double point1 = input.nextDouble();
        point1 = checkAPoint(point1, input);
        System.out.print("Nhap diem Ly: ");
        double point2 = input.nextDouble();
        point2 = checkAPoint(point2, input);
        System.out.print("Nhap diem Hoa: ");
        double point3 = input.nextDouble();
        point3 = checkAPoint(point3, input);
        Student student = new Student(id,name, age, point1, point2, point3);
        students.add(student);
        writeFile(students, PATH_NAME);
        return student;
    }

    public double checkAPoint(double piont, Scanner input) {
        while (piont < 0 || piont > 10) {
            System.out.print("sai khoang diem: ");
            piont = input.nextInt();
        }
        return piont;
    }

    public int checkAge(int age, Scanner input) {
        while (age < 0) {
            System.out.print("Nhap sai sai tuoi: ");
            age = input.nextInt();
        }
        return age;
    }

    public int checkId(int id, Scanner input){
        for (Student student : students) {
            while (student.getId() == id){
                System.out.print("ID bi trung, nhap lai ID: ");
                id = input.nextInt();
            }
        }
        return id;
    }

    public void deleteStudent() {
        System.out.print("Nhap ID sinh vien can xoa: ");
        int id1 = input.nextInt();
        Student student0 = null;
        for (Student student : students) {
            if (student.getId() == id1) {
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

    public void fixStudent() {
        boolean check = false;
        System.out.print("Nhap ID sinh vien can sua: ");
        int id2 = input.nextInt();
        for (Student student : students) {
            if (student.getId() == id2) {
                input.nextLine();
                System.out.print("Nhap ten: ");
                String name1 = input.nextLine();
                if (name1.equals("")){
                    student.setName(student.getName());
                } else {
                    student.setName(name1);
                }
                System.out.print("Nhap tuoi: ");
                student.setAge(checkAge(input.nextInt(),input));
                System.out.print("Nhap diem Toan: ");
                student.setMathPoint(checkAPoint(input.nextDouble(),input));
                System.out.print("Nhap diem Ly: ");
                student.setPhysicaPoint(checkAPoint(input.nextDouble(),input));
                System.out.print("Nhap diem Hoa: ");
                student.setChemistryPoint(checkAPoint(input.nextDouble(),input));
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

    public void listStudentByPoint(){
        students.sort((o1,o2) -> Double.compare(o2.getAvgPoint(), o1.getAvgPoint()));
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n", "", "ID", "Tên", "Tuổi", "Điểm Toán", "Điểm lý", "Điểm Hóa");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public ArrayList<Student> listStudentByPoint1(){
        students.sort((o1,o2) -> Double.compare(o1.getAvgPoint(), o2.getAvgPoint()));
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.addAll(students);
        return studentList;
    }

    public ArrayList<Student> studentByPointMax(){
        ArrayList<Student> stu = new ArrayList<>();
        stu.clear();
        double max = students.get(0).getAvgPoint();
        for (Student student : students) {
            if (student.getAvgPoint() > max){
                max = student.getAvgPoint();
            }
        }
        for (Student student : students){
            if (student.getAvgPoint() == max){
                stu.add(student);
            }
        }
        return stu;
    }

    public Student findStudent(){
        System.out.print("Nhap ID sinh vien can tim : ");
        int id = input.nextInt();
        for(Student student : students){
            if (student.getId() == id){
                return student;
            }
        }
        return null;
    }

}
