public class Student extends Person {
    private double mathPoint;
    private double physicaPoint;
    private double chemistryPoint;

    public Student(int id, String name, int age, double mathPoint, double physicaPoint, double chemistryPoint) {
        super(id, name, age);
        this.mathPoint = mathPoint;
        this.physicaPoint = physicaPoint;
        this.chemistryPoint = chemistryPoint;
    }

    public double getMathPoint() {
        return mathPoint;
    }

    public void setMathPoint(double mathPoint) {
        this.mathPoint = mathPoint;
    }

    public double getPhysicaPoint() {
        return physicaPoint;
    }

    public void setPhysicaPoint(double physicaPoint) {
        this.physicaPoint = physicaPoint;
    }

    public double getChemistryPoint() {
        return chemistryPoint;
    }

    public void setChemistryPoint(double chemistryPoint) {
        this.chemistryPoint = chemistryPoint;
    }

    public double getAvgPoint() {
        return (this.mathPoint + this.physicaPoint + this.chemistryPoint) / 3;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-15.2f%-15.2f%-15.2f%-15.2f", mathPoint, physicaPoint, chemistryPoint, getAvgPoint());
    }
}
