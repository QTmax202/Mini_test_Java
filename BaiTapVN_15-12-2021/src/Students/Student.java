package Students;

public class Student {
    private String name;
    private int age;
    private String sex;
    private String address;
    private double avgPoint;
    private int id;

    public Student() {
    }

    public Student(String name, int age, String sex, String address, double avgPoint, int id) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.avgPoint = avgPoint;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(double avgPoint) {
        this.avgPoint = avgPoint;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Students.Student {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", avgPoint=" + avgPoint +
                '}';
    }
}
