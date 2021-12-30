public class Student extends Human{
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

    public double getAvgPoint(){
        return (mathPoint + physicaPoint + chemistryPoint)/3;
    }

    @Override
    public String toString() {
        return String.format("%-10s%s%-10.2f%-10.2f%-10.2f","Student", super.toString(), mathPoint, physicaPoint, chemistryPoint);
    }
}
