package New.Week1to3;

public abstract class Employee {
    private String name;
    private Double birthday;

    public String getName() {
        return name;
    }

    public Double getBirthday() {
        return birthday;
    }

    public Employee(String name, double birthday){
        this.name = name;
        this.birthday = birthday;
    }

    abstract public double getSalary(int month);//2000￥>3000$
}

