abstract class Employee {

    private String name;
    private String birthDate;
    private String position;
    private String department;

    public Employee(String name, String birthDate, String position, String department) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
        this.department = department;
    }

    public static String[] getDepartment() {
        return new String[]{"Product", "Human Resources"};
    }

    public abstract int getSalary();

    @Override
    public String toString() {
        return "Name: " + name + ", Birth Date: " + birthDate + ", Position: " + position + ", Department: " + department;
    }
}
