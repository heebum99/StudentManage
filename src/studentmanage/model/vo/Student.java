package studentmanage.model.vo;

import java.util.Objects;

public class Student extends Job {
    //학년, 반
    private int grade;
    private int classNum;

    public Student() {
    }

    public Student(int id, int grade, int classNum, String address, String contact) {
        super(id, address, contact);
        this.grade = grade;
        this.classNum = classNum;
    }

    public Student(String name, int age, char gender, String address, String contact, double height, double weight, int grade, int classNum) {
        super(name, age, gender, address, contact, height, weight);
        this.grade = grade;
        this.classNum = classNum;
    }


    public int getGrade() {
        return grade;
    }

    public int getClassNum() {
        return classNum;
    }


    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\t" + getGrade() + "\t" + getClassNum();
    }

    @Override
    public boolean equals(Object object) {
        Student student = (Student) object;
        return getGrade() == student.getGrade() &&
                getClassNum() == student.getClassNum() &&
                getGender() == student.getGender() &&
                student.getHeight() == getHeight() &&
                student.getWeight() == getWeight() &&
                getName().equals(student.getName()) &&
                getAddress().equals(student.getAddress()) &&
                getContact().equals(student.getContact());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getGrade(), getClassNum(), getAddress(), getContact(), getGender(), getHeight(), getWeight());
    }
}
