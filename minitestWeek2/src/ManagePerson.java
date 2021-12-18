import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Scanner;

public class ManagePerson implements Manage, Comparator<Student> {
    Scanner input = new Scanner(System.in);
    private ArrayList<Person> list;
    private static int id = 1;

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
    public void addPerson(int choice) {
        list.add(createPerson(input, id, choice));
        id++;
    }


    @Override
    public void findPerson() {
        System.out.print("Nhập id người cần tìm: ");
        int id = input.nextInt();
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).getId()) {
                System.out.println(list.get(i));
            }
        }
    }

    @Override
    public void deletePerson() {
        System.out.print("Nhập id người cần xóa: ");
        int id = input.nextInt();
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).getId()) {
               list.remove(i);
                System.out.printf("Đã xóa người có id = %d",id);
            }
        }
    }

    @Override
    public Person fixperson() {
        Person PersonUpdate = null;
        Student studentUpdate = null;
        System.out.print("Nhập id người cần tìm: ");
        int id = input.nextInt();
        for (Person Person : list) {
            if (Person.getId() == id && Person instanceof Student) {
                studentUpdate = (Student) Person;
            } else if (Person.getId() == id) {
                PersonUpdate = Person;
            }
        }
        if (PersonUpdate != null) {
            input.nextLine();
            System.out.print("Nhập tên mới: ");
            String name = input.nextLine();
            if (name.equals("")) {
                PersonUpdate.setName(PersonUpdate.getName());
            } else {
                PersonUpdate.setName(name);
            }
            System.out.print("Nhập tuổi mới: ");
            PersonUpdate.setAge(input.nextInt());
            input.nextLine();
            return PersonUpdate;
        } else if (studentUpdate != null) {
            input.nextLine();
            System.out.print("Nhập tên mới: ");
            studentUpdate.setName(input.nextLine());
            System.out.print("Nhập tuổi mới: ");
            studentUpdate.setAge(input.nextInt());
            System.out.print("Nhập điểm mới: ");
            studentUpdate.setAvgPoint(input.nextDouble());
            return studentUpdate;
        }
        return null;
    }


    @Override
    public void sortTheList() {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Person> Persons1 = new ArrayList<>();
        for (Person Person : list) {
            if (Person instanceof Student) {
                students.add((Student) Person);
            } else {
                Persons1.add(Person);
            }
        }

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAvgPoint() > o2.getAvgPoint()) {
                    return 1;
                } else if (o1.getAvgPoint() < o2.getAvgPoint()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        Persons1.addAll(students);
        list = Persons1;
        System.out.println("Sắp xếp thành công!!!");
    }

    @Override
    public double totalAveragePoint() {
        double totalPoint = 0;
        for (Person Person : list) {
            if (Person instanceof Student) {
                totalPoint += ((Student) Person).getAvgPoint();
            }
        }
        return totalPoint;
    }

    public static Person createPerson(Scanner scanner,int id, int choice){
        scanner.nextLine();
        System.out.print("Nhập tên : ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = scanner.nextInt();
        if (choice == 1) {
            return new Person(name, age, id);
        } else if (choice == 2) {
            System.out.print("Nhập vào điểm trung bình: ");
            double avgPoint = scanner.nextDouble();
            return (Student) new Student(name, age, avgPoint, id);
        }
        return null;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }
}
