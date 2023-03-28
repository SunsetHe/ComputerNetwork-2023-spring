package New;

public class SalariedEmployee extends Employee {
    public SalariedEmployee(String name, double birthday) {
        super(name, birthday);
    }

    @Override
    public double getSalary(int month) {
        if (getBirthday() > month & getBirthday() < month + 1) {
            return 3000 + 100;
        } else {
            return 3000;
        }
    }
}
