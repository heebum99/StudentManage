package studentmanage.model.dao;

import studentmanage.common.SearchInterface;
import studentmanage.model.vo.Job;
import studentmanage.model.vo.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherDao implements DaoInterface {
    private final List<Teacher> teacherList = new ArrayList<>();
    private static TeacherDao dao;

    private TeacherDao() {

    }

    public static TeacherDao teacherDao() {
        if (dao == null) {
            dao = new TeacherDao();
        }
        return dao;
    }

    @Override
    public boolean save(Job teacher) {
        Teacher teacherInfo = (Teacher) teacher;
        if (findEqualJob(teacherInfo)) {
            System.out.println("== 중복 교사 ==");
            return false;
        }
        teacherList.add(teacherInfo);
        return true;
    }

    @Override
    public List<Teacher> search(SearchInterface search) {
        List<Teacher> teachers = new ArrayList<>();

        for (Teacher teacher : teacherList) {
            if (search.find(teacher)) {
                teachers.add(teacher);
            }
        }
        return teachers;
    }

    @Override
    public boolean update(Job existTeacherInfo, Job updateTeacherInfo) {
        Teacher exsistTeacher = (Teacher) existTeacherInfo;
        Teacher updateTeacher = (Teacher) updateTeacherInfo;
        if (!findEqualJob(exsistTeacher)) {
            return false;
        }

        //나중에 추가
        exsistTeacher.setMajor(updateTeacher.getMajor());
        exsistTeacher.setYear(updateTeacher.getYear());
        exsistTeacher.setSalary(updateTeacher.getSalary());

        return true;
    }

    @Override
    public boolean delete(int id) {
        Job job = findById(id);
        if (job == null) {
            return false;
        }

        Teacher teacher = (Teacher) job;
        teacherList.remove(teacher);
        return true;
    }

    @Override
    public boolean findEqualJob(Job teacher) {
        return teacherList.contains((Teacher) teacher);
    }

    @Override
    public Job findById(int id) {
        List<Teacher> teachers = search(
                job -> {
                    Teacher teacher = (Teacher) job;
                    return teacher.getId() == id;
                }
        );

        if (teachers.size() == 1) {
            return teachers.get(0);
        }
        return null;
    }
}
