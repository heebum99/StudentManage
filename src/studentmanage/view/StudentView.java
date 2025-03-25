package studentmanage.view;

import studentmanage.model.value.JobValue;
import studentmanage.model.vo.Job;
import studentmanage.model.vo.Student;

import java.util.Scanner;

import static studentmanage.controller.Controller.getController;

public class StudentView implements Viewable {
    private static StudentView view;
    private Scanner sc = new Scanner(System.in);

    private StudentView() {

    }

    public static StudentView getView() {
        if (view == null) {
            view = new StudentView();
        }
        return view;
    }

    @Override
    public void menu() {
        while (true) {
            System.out.println("===== 학생관리 프로그램 =====");
            System.out.println("1. 학생 등록");
            System.out.println("2. 학생 수정(학년, 반, 전화번호, 주소)");
            System.out.println("3. 학생 삭제");
            System.out.println("4. 전체 조회");
            System.out.println("5. 학생 번호로 조회");
            System.out.println("6. 학년으로 조회");
            System.out.println("7. 이름으로 조회");
            System.out.println("0. 이전 메뉴로 돌아가기");

            System.out.print("메뉴선택 : ");
            int choice = sc.nextInt();
            sc.nextLine();
            JobValue job = JobValue.STUDENT;

            switch (choice) {
                case 1:
                    getController().insert(job);
                    break;
                case 2:
                    getController().update(job);
                    break;
                case 3:
                    getController().delete(job);
                    break;
                case 4:
                    getController().searchAll(job);
                    break;
                case 5:
                    getController().searchByNo(job);
                    break;
                case 6:
                    getController().searchStudentByGrade();
                    break;
                case 7:
                    getController().searchByName(job);
                    break;
                case 0:
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못 선택하셨습니다. 다시 선택하세요!");
                    break;
            }
        }
    }

    @Override
    public Job insert() {
        System.out.println("== 학생 정보 입력 ==");
        System.out.print("이름을 입력해주세요 : ");
        String name = sc.nextLine();

        System.out.print("나이를 입력해주세요 : ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("학년을 입력해주세요 : ");
        int grade = sc.nextInt();

        System.out.print("반을 입력해주세요 : ");
        int classNum = sc.nextInt();

        sc.nextLine();
        System.out.print("주소를 입력해주세요 : ");
        String address = sc.nextLine();

        System.out.print("전화번호를 입력해주세요 : ");
        String contact = sc.nextLine();

        char gender;
        while (true) {
            System.out.print("성별을 입력해주세요(남/여) : ");
            gender = sc.nextLine().charAt(0);
            if (gender == '남' || gender == '여') {
                break;
            }
            System.out.println("'남' 또는 '여'를 입력해주세요");
        }

        System.out.print("키를 입력해주세요 : ");
        double height = sc.nextDouble();

        System.out.print("몸무게를 입력해주세요 : ");
        double weight = sc.nextDouble();

        return new Student(name, age, gender, address, contact, height, weight, grade, classNum);
    }

    @Override
    public Job update() {
        System.out.println("===== 학생 수정 =====");
        System.out.print("수정할 학생 번호를 입력해주세요 : ");
        int id = sc.nextInt();
        sc.nextLine();

        //학년, 반, 주소, 전화번호 변경
        System.out.print("학년을 입력해주세요 : ");
        int grade = sc.nextInt();
        sc.nextLine();

        System.out.print("반을 입력해주세요 : ");
        int classNum = sc.nextInt();
        sc.nextLine();

        System.out.print("주소를 입력해주세요 : ");
        String address = sc.nextLine();

        System.out.print("연락처를 입력해주세요 : ");
        String contact = sc.nextLine();

        return new Student(id, grade, classNum, address, contact);
    }

    @Override
    public int delete() {
        System.out.print("삭제할 학생 번호를 입력해주세요 : ");
        int id = sc.nextInt();
        sc.nextLine();

        return id;
    }

    public int searchByGrade() {
        System.out.print("검색할 학생의 학년을 입력해주세요 : ");
        int grade = sc.nextInt();
        sc.nextLine();

        return grade;
    }

}
