package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(true){
            System.out.print(">> ");
            String cmd = in.nextLine();

            if(cmd.equals("help")){
                System.out.println("도움말");
            }else if(cmd.equals("exit")){
                System.out.println("프로그램 종료");
                break;
            }else {
                System.out.println("명령어를 알 수 없습니다.");
            }
        }
    }

}
