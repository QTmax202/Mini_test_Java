import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Scanner;

public class ManagePerson implements Manage, Comparator<Student> {
    Scanner input = new Scanner(System.in);
    private ArrayList<Person> list;
    private static int id = 1;
    private Comparator<? super Person> Student;

    public ManagePerson(ArrayList<Person> list) {
        this.list = list;
    }

    @Override
    public void displayPerson() {
        ListIterator<Person> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println((Person) iterator.next());
        }
    }

    @Override
    public void addPerson() {
        list.add(createPerson(input,id));
        id++;
    }

    @Override
    public void addStudent() {
        list.add(createStudent(input,id));
        id++;
    }

    @Override
    public void findPerson() {
        System.out.print("Nhập id người cần tìm: ");
        int id = input.nextInt();
        System.out.println(list.indexOf(id));;
    }

    @Override
    public void deletePerson() {
        System.out.print("Nhập id người cần xóa: ");
        int id = input.nextInt();
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).getId()) {
               list.remove(i);
            }
        }
    }

    @Override
    public void fixperson() {
        System.out.print("Nhập id người cần sửa: ");
        int id = input.nextInt();
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).getId()) {
                if (list.get(i) instanceof Student){
                    list.set(i,editPerson(input));
                } else if (list.get(i) instanceof Person){
                    list.set(i,editPerson(input));
                }
            }
        }
    }


    @Override
    public void sortTheList() {
        list.sort(Student);
    }

    public static Person createPerson(Scanner scanner,int id){
        scanner.nextLine();
        System.out.print("Nhập tên : ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = scanner.nextInt();
        return new Person(name, age, id);
    }

    public static Student createStudent(Scanner scanner,int id){
        scanner.nextLine();
        System.out.print("Nhập tên : ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = scanner.nextInt();
        System.out.print("Nhập điểm trung bình: ");
        int avgPoint = scanner.nextInt();
        return (Student) new Student(name, age, avgPoint, id);
    }

    public static Person editPerson(Scanner scanner){
        scanner.nextLine();
        System.out.print("Nhập tên : ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = scanner.nextInt();
        return new Person(name, age);
    }

    public static Student editStudent(Scanner scanner){
        scanner.nextLine();
        System.out.print("Nhập tên : ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = scanner.nextInt();
        System.out.print("Nhập điểm trung bình: ");
        int avgPoint = scanner.nextInt();
        return (Student) new Student(name, age, avgPoint);
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
}
