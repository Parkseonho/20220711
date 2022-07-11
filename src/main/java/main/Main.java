package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<String> titles = new ArrayList<>();
        ArrayList<String> bodies = new ArrayList<>();

        while(true){
            System.out.print(">> ");
            String cmd = in.nextLine();

            if(cmd.equals("help")){
                System.out.println("add - 게시물 등록");
                System.out.println("list - 게시물 목록");
                System.out.println("exit - 프로그램 종료");
            }else if(cmd.equals("exit")){
                System.out.println("프로그램 종료");
                break;
            }else if(cmd.equals("add")){
                System.out.print("제목 : ");
                String title = in.nextLine();
                titles.add(title);

                System.out.print("내용 : ");
                String body = in.nextLine();
                bodies.add(body);

                System.out.println("게시물 입력 완료");
            } else if (cmd.equals("list")) {
                for(int i = 0; i<titles.size();i++){
                 String title = titles.get(i);
                 String body = bodies.get(i);

                    System.out.printf("번호 : %d\n", i+1);
                    System.out.printf("제목 : %s\n", title);
                    System.out.printf("내용 : %s\n", body);
                    System.out.println("====================");
                }
            }else {
                System.out.println("알 수 없는 명령어");
            }

        }
    }

}
