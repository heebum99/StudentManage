package studentmanage.view;


import java.util.Scanner;

import static studentmanage.controller.Controller.getController;


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
        //영속성을 위해 파일에 저장된 객체 불러서 리스트에 담기
//        getController().loadFile();

        //공통 메뉴 출력
        while (true) {
            System.out.println("===== 관리 프로그램 v0.3 =====");
            System.out.println("1.학생 메뉴");
            System.out.println("2.교사 메뉴");
            System.out.println("3.직원 메뉴");
            System.out.println("4.파일에 데이터 저장하기");
            System.out.println("5.파일의 데이터 불러오기");
            System.out.println("0.프로그램 종료");

            System.out.print("메뉴선택 : ");
            int choice = sc.nextInt();
            sc.nextLine();
            String fileName = "";

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
                case 4:
                    System.out.print("저장할 파일명을 입력해주세요 : ");
                    fileName = sc.nextLine();
                    getController().saveFile(fileName);
                    break;
                case 5:
                    System.out.print("불러올 파일 이름을 입력해주세요 : ");
                    fileName = sc.nextLine();
                    getController().loadFile(fileName);
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
//                    getController().saveFile(); //영속성을 위해 종료 시 각 파일에 각 객체들 저장하기
                    return;
                default:
                    System.out.println("잘못 선택하셨습니다. 다시 선택하세요!");
                    break;
            }
        }
    }
}
