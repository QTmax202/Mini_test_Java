public class Student extends Human{
    private double agePoint;

    public Student(String name, int age, String sex, String address, double agePoint) {
        super(name, age, sex, address);
        this.agePoint = agePoint;
    }

    public double getAgePoint() {
        return agePoint;
    }

    public void setAgePoint(double agePoint) {
        this.agePoint = agePoint;
    }

    @Override
    public String toString() {
        return super.toString()+ ", Student { AvgPoint = "+agePoint+" }";
    }
}
