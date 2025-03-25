package studentmanage.view;


import studentmanage.model.value.JobValue;
import studentmanage.model.vo.Employee;
import studentmanage.model.vo.Job;

import java.util.Scanner;

import static studentmanage.controller.Controller.getController;


public class EmployeeView implements Viewable {
    private static EmployeeView view;
    private Scanner sc = new Scanner(System.in);

    private EmployeeView() {

    }

    public static EmployeeView getView() {
        if (view == null) {
            view = new EmployeeView();
        }
        return view;
    }

    @Override
    public void menu() {
        while (true) {
            System.out.println("===== 직원관리 프로그램 =====");
            System.out.println("1. 직원 등록");
            System.out.println("2. 직원 수정(경력, 직급, 부서, 전화번호, 주소)");
            System.out.println("3. 직원 삭제");
            System.out.println("4. 전체 조회");
            System.out.println("5. 직원 번호로 조회");
            System.out.println("6. 부서로 조회");
            System.out.println("7. 이름으로 조회");
            System.out.println("0. 이전 메뉴로 돌아가기");

            System.out.print("메뉴선택 : ");
            int choice = sc.nextInt();
            sc.nextLine();
            JobValue job = JobValue.EMPLOYEE;

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
                    getController().searchEmployeeByDepartment();
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
        System.out.println("== 직원 정보 입력 ==");
        System.out.print("이름을 입력해주세요 : ");
        String name = sc.nextLine();

        System.out.print("나이를 입력해주세요 : ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("경력을 입력해주세요 : ");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.print("직급을 입력해주세요 : ");
        String rank = sc.nextLine();

        System.out.print("부서를 입력해주세요 : ");
        String department = sc.nextLine();

        System.out.print("주소를 입력해주세요 : ");
        String address = sc.nextLine();

        System.out.print("전화번호를 입력해주세요 : ");
        String contact = sc.nextLine();

        char gender;
        while (true) {
            System.out.print("성별을 입력해주세요(남/녀) : ");
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

        return new Employee(name, age, gender, address, contact, height, weight, year, rank, department);
    }

    @Override
    public Job update() {
        System.out.println("===== 직원 수정 =====");
        System.out.print("수정할 직원 번호를 입력해주세요 : ");
        int id = sc.nextInt();
        sc.nextLine();

        //경력, 직급, 부서, 주소, 전화번호 변경
        System.out.print("경력을 입력해주세요 : ");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.print("직급을 입력해주세요 : ");
        String rank = sc.nextLine();

        System.out.print("부서를 입력해주세요 : ");
        String department = sc.nextLine();

        System.out.print("주소를 입력해주세요 : ");
        String address = sc.nextLine();

        System.out.print("연락처를 입력해주세요 : ");
        String contact = sc.nextLine();

        return new Employee(id, address, contact, year, rank, department);
    }

    @Override
    public int delete() {
        System.out.print("삭제할 직원 번호를 입력해주세요 : ");
        int id = sc.nextInt();
        sc.nextLine();

        return id;
    }

    public String searchByDepartment() {
        System.out.print("검색할 직원의 부서를 입력해주세요 : ");
        String department = sc.nextLine();

        return department;
    }
}
