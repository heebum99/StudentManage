package studentmanage.view;


import studentmanage.model.vo.Student;

import java.util.Scanner;


//프로그래에서 화면을 출력해주는 역할
public class MainView {
    private Scanner sc = new Scanner(System.in);
    private static MainView view;
    private Viewable customView;

    private MainView() {
    }

    //싱글톤패턴
    public static MainView mainView() {
        if (view == null) {
            view = new MainView();
        }
        return view;
    }

    //1.메뉴 화면 출력
    public void mainMenu() {
        //공통 메뉴 출력
        while (true) {
            System.out.println("===== 관리 프로그램 v0.3 =====");
            System.out.println("1.학생 메뉴");
            System.out.println("2.교사 메뉴");
            System.out.println("3.직원 메뉴");
            System.out.println("0. 프로그램 종료");

            System.out.print("메뉴선택 : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    customView = StudentView.getView();
                    customView.menu();
                    break;
                case 2:
                    customView = TeacherView.getView();
                    customView.menu();
                    break;
                case 3:
                    customView = EmployeeView.getView();
                    customView.menu();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못 선택하셨습니다. 다시 선택하세요!");
                    break;
            }
        }
    }

    public String inputFindStudentName() {
        System.out.print("조회할 학생의 이름을 입력해주세요 : ");
        String name = sc.nextLine();

        return name;
    }

    public int inputFindStudentGrade() {
        int grade;
        while (true) {
            System.out.print("조회할 학생의 학년을 입력해주세요(1 ~ 3) : ");
            grade = sc.nextInt();
            sc.nextLine();
            if (grade >= 1 && grade <= 3) {
                break;
            }
            System.out.println("1 ~ 3 사이의 수자를 입력해주세요");
        }
        return grade;
    }


    public void printStudents(String content) {
        System.out.println("==== 학생 조회 결과 ====");
        System.out.println(content);
        System.out.println("======================");
    }

    public void printStudentByNo(Student student, int studentNum) {
        System.out.println("==== " + studentNum + "번 학생 조회 =====");
        if (student == null) {
            System.out.println(studentNum + "번인 학생이 없습니다.");
            return;
        }
        System.out.println(student.getInfo());
    }

    public void printStudentsByGrade(String content, int grade) {
        System.out.println("==== " + grade + "학년인 학생 조회 결과 ====");
        System.out.println(content);
        System.out.println("=========================================");
    }

    public void printStudentsByName(String content, String name) {
        System.out.println("==== 이름이 " + name + "인 학생 조회 결과 ====");
        System.out.println(content);
        System.out.println("=========================================");
    }
}
