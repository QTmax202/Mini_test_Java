public class Student extends Person{
    private double avgPoint;
    public static double sumAvg = 0;

    public Student(String name, int age, int avgPoint) {
        super(name, age);
        this.avgPoint = this.avgPoint;
        sumAvg += avgPoint;
    }

    public Student(String name, int age, double avgPoint, int id) {
        super(name, age, id);
        this.avgPoint = avgPoint;
        sumAvg += avgPoint;
    }

    public double getAvgPoint() {
        return avgPoint;
    }

    public static double getSumAvg() {
        return sumAvg;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", Student: {"+
                ", AvgPoint=" + avgPoint +
                '}';
    }
}
