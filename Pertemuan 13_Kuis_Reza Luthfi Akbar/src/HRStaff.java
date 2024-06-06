public class HRStaff extends Employee {
    public HRStaff(String name, String birthDate, String department) {
        super(name, birthDate, "HR Staff", department);
    }

    @Override
    public int getSalary() {
        return 5000000;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
