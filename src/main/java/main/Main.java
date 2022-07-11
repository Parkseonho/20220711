package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /* main뿐 아니라 새로운 메서드에 titles의 ArrayList가 필요하기에 static을 붙임 */

   static ArrayList<String> titles = new ArrayList<>();
   static ArrayList<String> bodies = new ArrayList<>();


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while(true) { // break가 될때까지 반복

            /* 첫번째 명령어 입력 */
            System.out.print(">> ");
            String cmd = in.nextLine();

            /* 명령어에 따른 능력 구현 */
            if (cmd.equals("help")) {
                System.out.println("add - 게시물 등록");
                System.out.println("list - 게시물 목록");
                System.out.println("update - 게시물 수정");
                System.out.println("exit - 프로그램 종료");
            } else if (cmd.equals("exit")) {
                System.out.println("프로그램 종료");
                break;
            } else if (cmd.equals("add")) {

                /* titles라는 Array list에 입력한 title을 넣는다. */
                System.out.print("제목 : ");
                String title = in.nextLine();
                titles.add(title);

                System.out.print("내용 : ");
                String body = in.nextLine();
                bodies.add(body);

                System.out.println("게시물 입력 완료");
            } else if (cmd.equals("list")) {
                
                /* list를 확인하는 메서드 */
                printArticles();
            } else if (cmd.equals("update")) {
                
                /* 게시물 수정 
                - 수정할 게시물 번호를 입력받는다.
                - 이때 입력받은 번호에서 -1을 해준다.
                 * 앞서 list에 번호를 표기하는 과정에서 +1을 해주었기 때문
                - index의 값이 0보다 작거나 ArrayList size를 초과하였다면 해당 if문을 종료
                - 수정한 게시물은 set을통해 titles의 index번에 title을 넣는다.
                - 제대로 수정이 되었는지 확인하기 위해 리스트를 확인해준다.
                */
                System.out.print("수정할 게시물 번호 : ");
                int no = Integer.parseInt(in.nextLine());
                int index = no - 1;

                if(index < 0 || index >= titles.size()){
                    System.out.println("없는 게시물입니다.");
                    continue;
                }

                System.out.print("내용 : ");
                String title = in.nextLine();


                System.out.print("내용 : ");
                String body = in.nextLine();

                titles.set(index,title);
                bodies.set(index, body);

                System.out.println("수정 완료");

                printArticles();

            }else {
                System.out.println("알 수 없는 명령어");
            }

        }
    }
    public static void printArticles() {
        /* for문을 이용하여 titles의 길이만큼 반복 */
        for (int i = 0; i < titles.size(); i++) {
            String title = titles.get(i);
            String body = bodies.get(i);

            System.out.printf("번호 : %d\n", i + 1);// i가 0부터 시작하기에 '+1'이 필요
            System.out.printf("제목 : %s\n", title);
            System.out.printf("내용 : %s\n", body);
            System.out.println("====================");
        }
    }

}
