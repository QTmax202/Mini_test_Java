public class Student extends Person{
    private double avgPoint;

    public Student(String name, int age, double avgPoint, int id) {
        super(name, age, id);
        this.avgPoint = avgPoint;
    }

    public double getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(double avgPoint) {
        this.avgPoint = avgPoint;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", Student: {"+
                " AvgPoint= " + avgPoint +
                '}';
    }
}
