package studentmanage.model.dao;


import studentmanage.common.SearchInterface;
import studentmanage.model.vo.Job;
import studentmanage.model.vo.Student;

import java.util.ArrayList;
import java.util.List;

//학생을 저장관리하는 역할
public class StudentDao implements DaoInterface {
    private final List<Student> studentList = new ArrayList<>();
    private static StudentDao dao;

    private StudentDao() {
    }

    public static StudentDao studentDao() {
        if (dao == null) {
            dao = new StudentDao();
        }
        return dao;
    }

    @Override
    public boolean save(Job student) {
        Student studentInfo = (Student) student;
        if (findEqualJob(studentInfo)) {
            System.out.println("== 중복 학생 ==");
            return false;
        }
        studentList.add(studentInfo);
        return true;
    }

    @Override
    public boolean update(Job existStudentInfo, Job updateStudentInfo) {
        Student existStudent = (Student) existStudentInfo;
        Student updateStudent = (Student) updateStudentInfo;
        if (!findEqualJob(existStudentInfo)) {
            return false;
        }

        existStudent.setGrade(updateStudent.getGrade());
        existStudent.setClassNum(updateStudent.getClassNum());
        existStudent.setAddress(updateStudent.getAddress());
        existStudent.setContact(updateStudent.getContact());
        return true;
    }

    @Override
    public boolean delete(int id) {
        List<Student> students = search(
                job -> {
                    Student student = (Student) job;
                    return student.getId() == id;
                }
        );

        Student student = null;
        if (students.size() == 1) {
            student = students.get(0);
        }

        if (student == null) {
            return false;
        }
        studentList.remove(student);
        return true;
    }

    @Override
    public List<Student> search(SearchInterface search) {
        List<Student> students = new ArrayList<>();

        for (Student student : studentList) {
            if (search.find(student)) {
                students.add(student);
            }
        }
        return students;
    }

    @Override
    public boolean findEqualJob(Job studentInfo) {
        return studentList.contains((Student) studentInfo);
    }
}

