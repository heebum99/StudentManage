package studentmanage.view;

import studentmanage.model.value.JobValue;
import studentmanage.model.vo.Job;
import studentmanage.model.vo.Teacher;

import java.util.Scanner;

import static studentmanage.controller.Controller.getController;


public class TeacherView implements Viewable {
    private static TeacherView view;
    private Scanner sc = new Scanner(System.in);

    private TeacherView() {

    }

    public static TeacherView getView() {
        if (view == null) {
            view = new TeacherView();
        }
        return view;
    }

    @Override
    public void menu() {
        while (true) {
            System.out.println("===== 교사관리 프로그램 =====");
            System.out.println("1. 교사 등록");
            //수정할 필드 재설정
            System.out.println("2. 교사 수정(경력, 전공, 급여, 전화번호, 주소)");
            System.out.println("3. 교사 삭제");
            System.out.println("4. 전체 조회");
            System.out.println("5. 교사번호로 조회");
            //아래 내용들 수정할 것
            System.out.println("6. 전공으로 조회");
            System.out.println("7. 이름으로 조회");
            System.out.println("0. 이전 메뉴로 돌아가기");

            System.out.print("메뉴선택 : ");
            int choice = sc.nextInt();
            sc.nextLine();
            JobValue job = JobValue.TEACHER;

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
                    getController().searchTeacherByMajor();
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
        System.out.println("== 교사 정보 입력 ==");
        System.out.print("이름을 입력해주세요 : ");
        String name = sc.nextLine();

        System.out.print("나이를 입력해주세요 : ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("경력을 입력해주세요 : ");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.print("전공을 입력해주세요 : ");
        String major = sc.nextLine();

        System.out.print("급여를 입력해주세요 : ");
        int salary = sc.nextInt();

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

        return new Teacher(name, age, gender, address, contact, height, weight, year, major, salary);
    }

    @Override
    public Job update() {
        System.out.println("===== 교사 수정 =====");
        System.out.print("수정할 교사 번호를 입력해주세요 : ");
        int id = sc.nextInt();
        sc.nextLine();

        //경력, 전공, 급여, 주소, 전화번호 변경
        System.out.print("경력을 입력해주세요 : ");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.print("전공을 입력해주세요 : ");
        String major = sc.nextLine();

        System.out.print("급여를 입력해주세요 : ");
        int salary = sc.nextInt();
        sc.nextLine();

        System.out.print("주소를 입력해주세요 : ");
        String address = sc.nextLine();

        System.out.print("연락처를 입력해주세요 : ");
        String contact = sc.nextLine();

        return new Teacher(id, address, contact, year, major, salary);
    }

    @Override
    public int delete() {
        System.out.print("삭제할 교사 번호를 입력해주세요 : ");
        int id = sc.nextInt();
        sc.nextLine();

        return id;
    }

    public String searchByMajor() {
        System.out.print("검색할 교사의 전공을 입력해주세요 : ");
        String major = sc.nextLine();

        return major;
    }
}
