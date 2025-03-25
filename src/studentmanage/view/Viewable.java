package studentmanage.view;

import studentmanage.model.value.JobValue;
import studentmanage.model.vo.Job;

import java.util.List;
import java.util.Scanner;

public interface Viewable {
    Scanner sc = new Scanner(System.in);

    void menu();

    Job insert();

    Job update();

    int delete();

    default int searchByNo(JobValue job) {
        System.out.print("조회할 " + job.getValue() + " 번호를 입력해주세요 : ");
        int id = sc.nextInt();
        sc.nextLine();

        return id;
    }

    default String searchByName(JobValue job) {
        System.out.print("조회할 " + job.getValue() + " 이름을 입력해주세요 : ");
        String name = sc.nextLine();

        return name;
    }

    default void printJob(List<Job> jobs, JobValue job) {
        if (jobs == null || jobs.size() == 0) {
            System.out.println("등록된 " + job.getValue() + " 정보가 없습니다.");
            return;
        }
        for (Job j : jobs) {
            System.out.println(j.getInfo());
        }
    }

    default void printMessage(String msg) {
        System.out.println("==== 알림 메세지 ====");
        System.out.println(msg);
        System.out.println("===================");
    }


}
