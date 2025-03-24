package studentmanage.model.vo;

import java.util.Objects;

public class Teacher extends Job {
    private int year; //경력
    private String major; //전공
    private int salary; //급여

    public Teacher() {
    }

    public Teacher(int year, String major, int salary) {
        this.year = year;
        this.major = major;
        this.salary = salary;
    }

    public Teacher(int id, String address, String contact, int year, String major, int salary) {
        super(id, address, contact);
        this.year = year;
        this.major = major;
        this.salary = salary;
    }

    public Teacher(String name, int age, char gender, String address, String contact, double height, double weight, int year, String major, int salary) {
        super(name, age, gender, address, contact, height, weight);
        this.year = year;
        this.major = major;
        this.salary = salary;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\t" + getMajor() + "\t" + getYear() + "\t" + getSalary();
    }

    @Override
    public boolean equals(Object object) {
        Teacher teacher = (Teacher) object;
        return getGender() == teacher.getGender() &&
                teacher.getHeight() == getHeight() &&
                teacher.getWeight() == getWeight() &&
                getName().equals(teacher.getName()) &&
                getAddress().equals(teacher.getAddress()) &&
                getContact().equals(teacher.getContact()) &&
                getYear() == teacher.getYear() &&
                getSalary() == teacher.getSalary() &&
                getMajor().equals(teacher.getMajor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getMajor(), getSalary());
    }
}
