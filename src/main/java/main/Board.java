package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    ArrayList<Article> articles = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public void run(){

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
                printArticles(articles);
            } else if (cmd.equals("update")) {
                updateArticle();
                printArticles(articles);
            }else if(cmd.equals("search")){
                searchArticle();
            }else {
                System.out.println("알 수 없는 명령어");
            }

        }
    }

    private void searchArticle() {
        /*
         - 입력한 키워드가 들어간 게시물을 찾는것임
         - Article을 가지는 searchArticleList라는 ArrayList 생성
         - 게시물 0부터 articles 개수만큼 반복하면서
           n번째 article의 제목에 keyword가 포함되어 있으면
           searchArticleList에 n번째 articles 게시물 더하기
           * contains(문자열) : 이 문자열 내에서 지정한 문자가 포함되어 있는지 여부 확인
         - printArticles에 searchArticleList를 넣어 원하는것만 출력할수 있게 함
         */
        System.out.print("검색 키워드를 입력해주세요 : ");
        String keyword = in.nextLine();

        ArrayList<Article> searchArticleList = new ArrayList<>();
        for(int i = 0; i < articles.size(); i++){
            if(articles.get(i).title.contains(keyword)){
                searchArticleList.add(articles.get(i));
            }
        }
        printArticles(searchArticleList);
    }


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
        System.out.println("search - 검색");
        System.out.println("exit - 프로그램 종료");
    }

        /*
        - search가 있을때는 searchArticleList에 있는 articles를 출력
        - search가 없을때는 articles 전부 출력
        */
    public void printArticles(ArrayList<Article> articles) {

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);

            System.out.printf("번호 : %d\n", i + 1);
            System.out.printf("제목 : %s\n", article.title);
            System.out.printf("내용 : %s\n", article.body);
            System.out.println("====================");
        }
    }
}
