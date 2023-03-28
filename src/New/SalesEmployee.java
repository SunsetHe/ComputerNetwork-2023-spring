package New;

public class SalesEmployee extends Employee {
    public SalesEmployee(String name, double birthday) {
        super(name, birthday);
    }

    @Override
    public double getSalary(int month) {
        return 2000;
    }

    public double getSalary(int monthSale, double rate) {
        return monthSale * rate + 2000;
    }
}
