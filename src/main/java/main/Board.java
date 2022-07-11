package main;

import java.util.ArrayList;
import java.util.Scanner;



public class Board {
    /* Article이라는 새로운 java를 만들어 ArrayList에 추가 */
    ArrayList<Article> articles = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public void run(){
        while(true) {
            System.out.print(">> ");
            String cmd = in.nextLine();

            /* if문이 실행될때 나오는 것들도 메서드를 통해 구조화함 */
            if (cmd.equals("help")) {
                printHelp();
            } else if (cmd.equals("exit")) {
                System.out.println("프로그램 종료");
                break;
            } else if (cmd.equals("add")) {
                addArticle();
            } else if (cmd.equals("list")) {
                printArticles();
            } else if (cmd.equals("update")) {
                updateArticle();
            }else {
                System.out.println("알 수 없는 명령어");
            }

        }
    }

    private void updateArticle() {
        System.out.print("수정할 게시물 번호 : ");
        int no = Integer.parseInt(in.nextLine());
        int index = no - 1;

        if(index < 0 || index >= articles.size()){
            System.out.println("없는 게시물입니다.");
            return;
        }

        System.out.print("제목 : ");
        String title = in.nextLine();


        System.out.print("내용 : ");
        String body = in.nextLine();

        Article article = new Article(title, body); // Article이라는 새로운 객체?에 인자값을 넣어준다.
        articles.set(index, article);

        System.out.println("수정 완료");

        printArticles();
    }




    private void addArticle() {
        System.out.print("제목 : ");
        String title = in.nextLine();

        System.out.print("내용 : ");
        String body = in.nextLine();

        Article article = new Article(title, body);
        articles.add(article);

        System.out.println("게시물 입력 완료");
    }

    private void printHelp() {
        System.out.println("add - 게시물 등록");
        System.out.println("list - 게시물 목록");
        System.out.println("update - 게시물 수정");
        System.out.println("exit - 프로그램 종료");
    }

    public void printArticles() {

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);

            System.out.printf("번호 : %d\n", i + 1);// i가 0부터 시작하기에 '+1'이 필요
            System.out.printf("제목 : %s\n", article.title);
            System.out.println("====================");
        }
    }
}
