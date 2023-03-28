package New;

public class HourEmployee extends Employee {
    public HourEmployee(String name, double birthday) {
        super(name, birthday);
    }

    @Override
    public double getSalary(int month) {
        return 2000;
    }

    public double getSalary(int perHour, int workHour) {
        return perHour * workHour;
    }
}
