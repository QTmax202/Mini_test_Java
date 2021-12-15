package Students;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManager implements Comparator<Student>{
    private Student[] students;
    private static int index = 0;
    private static int id = 1;

    public StudentManager(Student[] students) {
        this.students = students;
    }

    public StudentManager() {
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void addStudent(String name, int age, String sex, String address, double avgPoint) {
        Student student = new Student(name, age, sex, address, avgPoint, id);
        students[index] = student;
        index++;
        id++;
    }

    public void displayStudent(){
        for(Student student : students){
            if (student != null){
                System.out.println(student);
            }
        }
    }
    public void studentPointMax(){
        double maxPoint = students[0].getAvgPoint();
        for (Student student : students){
            if (student != null && maxPoint < student.getAvgPoint()){
                maxPoint = student.getAvgPoint();
            }
        }
        System.out.println("Danh sách sinh viên có điểm cao nhất là: ");
        for(Student student : students){
            if (student != null && maxPoint == student.getAvgPoint()){
                System.out.println(student);
            }
        }
    }

    public void studentPointMin(){
        double minPoint = students[0].getAvgPoint();
        for (Student student : students){
            if (student != null && minPoint > student.getAvgPoint()){
                minPoint = student.getAvgPoint();
            }
        }
        System.out.println("Danh sách sinh viên có điểm thấp nhất là: ");
        for(Student student : students){
            if (student != null && minPoint == student.getAvgPoint()){
                System.out.println(student);
            }
        }
    }

    public void deleteStudent(Scanner input){
        input.nextLine();
        System.out.print("Nhập tên sinh viên cần xóa: ");
        String name = input.nextLine();
        for (int i = 0; i < students.length ; i++) {
            if (students[i] != null && students[i].getName().equals(name)){
                for (int j = i; j < students.length-1; j++) {
                    students[j] = students[i+1];
                }
                students[students.length-1] = null;
            }
        }
    }

    public void displayNameStudent(Scanner input){
        input.nextLine();
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String name = input.nextLine();
        for (int i = 0; i < students.length ; i++) {
            if (students[i] != null && students[i].getName().equals(name)){
                System.out.println(students[i]);
            }
        }
    }

    public void displaySexStudent(Scanner input){
        input.nextLine();
        System.out.print("Nhập giới tính sinh viên: ");
        String sex = input.nextLine();
        for (int i = 0; i < students.length ; i++) {
            if (students[i] != null && students[i].getSex().equals(sex)){
                System.out.println(students[i]);
            }
        }
    }

    @Override
    public int compare(Student o1, Student o2) {
        if(o1 != null && o2 != null){
            if (o1.getAvgPoint() > o2.getAvgPoint()){
                return 1;
            } else if (o1.getAvgPoint() < o2.getAvgPoint()){
                return -1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    public void rangStudentByAvgPoint(){
        StudentManager studentManager = new StudentManager();
        Arrays.sort(students, studentManager);
    }

    public void findStudent(Scanner input){
        System.out.print("Nhập id sinh viên cần sửa thông tin: ");
        int id = input.nextInt();
        for (int i = 0; i < students.length ; i++) {
            if (students[i] != null && students[i].getId() == id){
                input.nextLine();
                System.out.print("Nhập tên: ");
                students[i].setName(input.nextLine());
                System.out.print("Nhập tuổi: ");
                students[i].setAge(input.nextInt());
                input.nextLine();
                System.out.print("Nhập giới tính: ");
                students[i].setSex(input.nextLine());
                System.out.print("Nhập địa chỉ: ");
                students[i].setAddress(input.nextLine());
                System.out.print("Nhập điểm trung bình: ");
                students[i].setAvgPoint(input.nextDouble());
            }
        }
    }
    
}
