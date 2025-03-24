package studentmanage.model.vo;

import java.util.Objects;

public class Employee extends Job {
    private int year; //경력
    private String rank; //직급
    private String department; //부서

    public Employee() {
    }

    public Employee(int year, String rank, String department) {
        this.year = year;
        this.rank = rank;
        this.department = department;
    }

    public Employee(int id, String address, String contact, int year, String rank, String department) {
        super(id, address, contact);
        this.year = year;
        this.rank = rank;
        this.department = department;
    }

    public Employee(String name, int age, char gender, String address, String contact, double height, double weight, int year, String rank, String department) {
        super(name, age, gender, address, contact, height, weight);
        this.year = year;
        this.rank = rank;
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\t" + getYear() + "\t" + getRank() + "\t" + getDepartment();
    }

    @Override
    public boolean equals(Object object) {

        Employee employee = (Employee) object;
        return getGender() == employee.getGender() &&
                employee.getHeight() == getHeight() &&
                employee.getWeight() == getWeight() &&
                getName().equals(employee.getName()) &&
                getAddress().equals(employee.getAddress()) &&
                getContact().equals(employee.getContact()) &&
                getYear() == employee.getYear() &&
                getRank().equals(employee.getRank()) &&
                getDepartment().equals(employee.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getRank(), getDepartment());
    }
}
