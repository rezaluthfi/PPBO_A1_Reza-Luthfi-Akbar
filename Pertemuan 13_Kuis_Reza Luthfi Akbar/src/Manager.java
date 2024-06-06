public class Manager extends Employee {
    public Manager(String name, String birthDate, String department) {
        super(name, birthDate, "Manager", department);
    }

    @Override
    public int getSalary() {
        return 20000000;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
