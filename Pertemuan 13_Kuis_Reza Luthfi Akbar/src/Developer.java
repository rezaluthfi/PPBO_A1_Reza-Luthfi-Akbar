public class Developer extends Employee {
    public Developer(String name, String birthDate, String department) {
        super(name, birthDate, "Developer", department);
    }

    @Override
    public int getSalary() {
        return 10000000;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
