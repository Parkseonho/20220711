package main;

import java.util.ArrayList;
import java.util.Scanner;



public class Board {
    ArrayList<Article> articles = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public void run(){

        /* test date를 제작하여 여러개의 list를 확인해보자 */
        makeTestDate();

        while(true) {
            System.out.print(">> ");
            String cmd = in.nextLine();

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

    /* test date 제작 후 articles ArrayList에 추가 */
    private void makeTestDate() {
        Article test1 = new Article("제목1","내용1");
        Article test2 = new Article("제목2","내용2");
        Article test3 = new Article("제목3","내용3");

        articles.add(test1);
        articles.add(test2);
        articles.add(test3);

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

        Article article = new Article(title, body);
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

            System.out.printf("번호 : %d\n", i + 1);
            System.out.printf("제목 : %s\n", article.title);
            System.out.printf("내용 : %s\n", article.body);
            System.out.println("====================");
        }
    }
}
