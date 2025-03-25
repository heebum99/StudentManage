package studentmanage.controller;

import studentmanage.model.dao.DaoInterface;
import studentmanage.model.value.JobValue;
import studentmanage.model.vo.Employee;
import studentmanage.model.vo.Job;
import studentmanage.model.vo.Student;
import studentmanage.model.vo.Teacher;
import studentmanage.view.EmployeeView;
import studentmanage.view.StudentView;
import studentmanage.view.TeacherView;
import studentmanage.view.Viewable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static studentmanage.model.dao.EmployeeDao.employeeDao;
import static studentmanage.model.dao.StudentDao.studentDao;
import static studentmanage.model.dao.TeacherDao.teacherDao;
import static studentmanage.view.MainView.mainView;


//프로그램에서 서비스를 진행시키는 역할
public class Controller {
    private static Controller controller;
    private DaoInterface dao;
    private Viewable view;
    private static final String JOB_FILE_NAME = "job.dat";
    private static final String TEACHER_FILE_NAME = "teacher.dat";
    private static final String EMPLOYEE_FILE_NAME = "employee.dat";


    private Controller() {
    }

    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    private Viewable getView(JobValue job) {
        if (job.equals(JobValue.STUDENT)) {
            return StudentView.getView();
        } else if (job.equals(JobValue.TEACHER)) {
            return TeacherView.getView();
        } else if (job.equals(JobValue.EMPLOYEE)) {
            return EmployeeView.getView();
        }
        return null;
    }

    private DaoInterface getDao(Job j) {
        DaoInterface dao = null;
        if (j instanceof Student) {
            dao = studentDao();
        } else if (j instanceof Teacher) {
            dao = teacherDao();
        } else if (j instanceof Employee) {
            dao = employeeDao();
        }
        return dao;
    }

    public void menu() {
        mainView().mainMenu();
    }

    public void insert(JobValue job) {
        Viewable view = getView(job);
        Job j = view.insert();
        boolean result = false;

        dao = getDao(j);
        result = dao.save(j);

        view.printMessage(result ? job.getValue() + " 등록 성공" : job.getValue() + " 등록 실패");
    }

    public void update(JobValue job) {
        Viewable view = getView(job);
        Job newJob = view.update();
        boolean result = false;

        dao = getDao(newJob);
        if (newJob instanceof Student) {
            dao = studentDao();
            List<Student> students = (List<Student>) dao.search(
                    j -> {
                        Student student = (Student) j;
                        return student.getId() == newJob.getId();
                    }
            );
            Student existJob = null;
            if (students.size() == 1) {
                existJob = students.get(0);
            }
            result = dao.update(existJob, newJob);
        } else if (newJob instanceof Teacher) {
            dao = teacherDao();
            List<Teacher> teachers = (List<Teacher>) dao.search(
                    j -> {
                        Teacher teacher = (Teacher) j;
                        return teacher.getId() == newJob.getId();
                    }
            );
            Teacher existJob = null;
            if (teachers.size() == 1) {
                existJob = teachers.get(0);
            }
            result = dao.update(existJob, newJob);
        } else if (newJob instanceof Employee) {
            dao = employeeDao();
            List<Employee> employees = (List<Employee>) dao.search(
                    j -> {
                        Employee employee = (Employee) j;
                        return employee.getId() == newJob.getId();
                    });
            Employee existJob = null;
            if (employees.size() == 1) {
                existJob = employees.get(0);
            }
            result = dao.update(existJob, newJob);
        }
        view.printMessage(result ? newJob.getId() + "번 수정 성공" : newJob.getId() + "번 수정 실패");
    }

    public void delete(JobValue job) {
        Viewable view = getView(job);
        int id = view.delete();
        boolean result = false;

        if (job.equals(JobValue.STUDENT)) {
            dao = studentDao();
            result = dao.delete(id);
        } else if (job.equals(JobValue.TEACHER)) {
            dao = teacherDao();
            result = dao.delete(id);
        } else if (job.equals(JobValue.EMPLOYEE)) {
            dao = employeeDao();
            result = dao.delete(id);
        }
        view.printMessage(result ? id + "번 " + job.getValue() + "삭제 완료" : id + "번 " + job.getValue() + "삭제 실패");
    }

    public void searchAll(JobValue job) {
        Viewable view = getView(job);
        List<Job> list = null;
        if (job.equals(JobValue.STUDENT)) {
            dao = studentDao();
            list = (List<Job>) dao.search(
                    student -> student != null
            );
        } else if (job.equals(JobValue.TEACHER)) {
            dao = teacherDao();
            list = (List<Job>) dao.search(
                    teacher -> teacher != null
            );
        } else if (job.equals(JobValue.EMPLOYEE)) {
            dao = employeeDao();
            list = (List<Job>) dao.search(
                    employee -> employee != null
            );
        }
        view.printJob(list, job);
    }

    public void searchByNo(JobValue job) {
        Viewable view = getView(job);
        int id = view.searchByNo(job);
        List<Job> list = null;
        if (job.equals(JobValue.STUDENT)) {
            dao = studentDao();
            List<Job> students = (List<Job>) dao.search(
                    j -> {
                        Student student = (Student) j;
                        return student.getId() == id;
                    }
            );
            if (students.size() == 1) {
                list = students;
            }
        } else if (job.equals(JobValue.TEACHER)) {
            dao = teacherDao();
            List<Job> teachers = (List<Job>) dao.search(
                    j -> {
                        Teacher teacher = (Teacher) j;
                        return teacher.getId() == id;
                    }
            );
            if (teachers.size() == 1) {
                list = teachers;
            }
        } else if (job.equals(JobValue.EMPLOYEE)) {
            dao = employeeDao();
            List<Job> employees = (List<Job>) dao.search(
                    j -> {
                        Employee employee = (Employee) j;
                        return employee.getId() == id;
                    });
            if (employees.size() == 1) {
                list = employees;
            }
        }
        view.printJob(list, job);
    }

    public void searchByName(JobValue job) {
        Viewable view = getView(job);
        String name = view.searchByName(job);

        List<Job> list = null;
        if (job.equals(JobValue.STUDENT)) {
            dao = studentDao();
            list = (List<Job>) dao.search(
                    student -> student.getName().equals(name)
            );
        } else if (job.equals(JobValue.TEACHER)) {
            dao = teacherDao();
            list = (List<Job>) dao.search(
                    teacher -> teacher.getName().equals(name)
            );
        } else if (job.equals(JobValue.EMPLOYEE)) {
            dao = employeeDao();
            list = (List<Job>) dao.search(
                    employee -> employee.getName().equals(name)
            );
        }
        view.printJob(list, job);
    }

    public void searchStudentByGrade() {
        view = StudentView.getView();
        dao = studentDao();
        int grade = ((StudentView) view).searchByGrade();
        List<Job> list = (List<Job>) dao.search(
                student -> ((Student) student).getGrade() == grade
        );
        view.printJob(list, JobValue.STUDENT);
    }

    public void searchTeacherByMajor() {
        view = TeacherView.getView();
        dao = teacherDao();
        String major = ((TeacherView) view).searchByMajor();
        List<Job> list = (List<Job>) dao.search(
                teacher -> ((Teacher) teacher).getMajor().equals(major)
        );
        view.printJob(list, JobValue.TEACHER);
    }

    public void searchEmployeeByDepartment() {
        view = EmployeeView.getView();
        dao = employeeDao();
        String department = ((EmployeeView) view).searchByDepartment();
        List<Job> list = (List<Job>) dao.search(
                employee -> ((Employee) employee).getDepartment().equals(department)
        );
        view.printJob(list, JobValue.EMPLOYEE);
    }

    public void saveFile() {
        //파일 한 개로 관리하기
        List<Job> jobList = new ArrayList<>();
        try (FileOutputStream fos = new FileOutputStream(JOB_FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            //학생 정보 List에 저장
            dao = studentDao();
            List<Student> students = (List<Student>) dao.search(
                    student -> student != null
            );
            if (students != null && students.size() != 0) {
                jobList.addAll(students);
            }

            //교사 정보 List에 저장
            dao = teacherDao();
            List<Teacher> teachers = (List<Teacher>) dao.search(
                    teacher -> teacher != null
            );
            if (teachers != null && teachers.size() != 0) {
                jobList.addAll(teachers);
            }

            //직원 정보 List에 저장
            dao = employeeDao();
            List<Employee> employees = (List<Employee>) dao.search(
                    employee -> employee != null
            );
            if (employees != null && employees.size() != 0) {
                jobList.addAll(employees);
            }

            oos.writeObject(jobList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFile() {
        createFile(JOB_FILE_NAME);

        try (FileInputStream fis = new FileInputStream(JOB_FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            List<Job> list = (List<Job>) ois.readObject();
            for (Job job : list) {
                if (job instanceof Student) {
                    dao = studentDao();
                } else if (job instanceof Teacher) {
                    dao = teacherDao();
                } else if (job instanceof Employee) {
                    dao = employeeDao();
                }
                dao.save(job);
            }
        } catch (EOFException e) {
            System.out.println(JOB_FILE_NAME + " 파일 읽기 완료");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void createFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
