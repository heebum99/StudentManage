package studentmanage.model.vo;

import java.io.Serializable;

public class Job implements Serializable {
    //식별자, 이름, 나이, 성별, 주소, 연락처, 키, 몸무게
    private int id;
    private static int numIdx = 0;
    private String name;
    private int age;
    private char gender;
    private String address;
    private String contact;
    private double height;
    private double weight;

    {
        id = ++numIdx;
    }

    public Job() {
    }

    public Job(int id, String address, String contact) {
        this.id = id;
        this.address = address;
        this.contact = contact;
    }

    public Job(String name, int age, char gender, String address, String contact, double height, double weight) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.contact = contact;
        this.height = height;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getNumIdx() {
        return numIdx;
    }

    public static void setNumIdx(int numIdx) {
        Job.numIdx = numIdx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getInfo() {
        return getId() + "\t" + getName() + "\t" + getAge() + "\t" +
                getGender() + "\t" + getAddress() + "\t" + getContact() + "\t" +
                getHeight() + "\t" + getWeight();
    }
}
