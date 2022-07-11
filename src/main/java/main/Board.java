package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    
    /* 
     - 기존에 사용하던 Article을 보이는곳(a)과 기능적인 부분(b)을 나눔
     - a, b를 사용하기 위해 run 돌기 전에 선언해줌
     */
     ArticleView articleView = new ArticleView();
     ArticleRepository articleRepository = new ArticleRepository();
    Scanner in = new Scanner(System.in);

    public void run(){

        /* a,b를 사용하기 위해 사용하려는 기능 앞에 변수명과 온점을 붙여준다. */
        articleRepository.makeTestDate();

        while(true) {
            System.out.print(">> ");
            String cmd = in.nextLine();

            if (cmd.equals("help")) {
                articleView.printHelp();
            } else if (cmd.equals("exit")) {
                System.out.println("프로그램 종료");
                break;
            } else if (cmd.equals("add")) {
                addArticle();
            } else if (cmd.equals("list")) {
                // list는 repository에 있는 getArticles을 가져와 view에서 보여줘야해서 아래와 같은 형식이 됨
                articleView.printArticle(articleRepository.getArticles());
            } else if (cmd.equals("update")) {
                updateArticle();
                articleView.printArticle(articleRepository.getArticles());
            }else if(cmd.equals("search")){
                searchArticle();
            } else if (cmd.equals("detail")) { // 상세보기
                readDetailArticle();
            } else {
                System.out.println("알 수 없는 명령어");
            }

        }
    }

    private void readDetailArticle() {
        System.out.print("상세보기 할 게시물 번호 : ");
        int targetIdx = Integer.parseInt(in.nextLine());
        targetIdx--;
        Article article = articleRepository.getAtileOne(targetIdx);
        // 리포지터리에서 입력값에 해당하는 게시물을 가져와 article에 저장 

        if(article == null){
            System.out.println("없는 게시물입니다.");
        }else{
            articleView.printArtileDetail(article, targetIdx);
            // 게시물 중 입력값에 해당하는 게시물 출력
        }
    }

    private void searchArticle(){
        System.out.print("검색 키워드 : ");
        String keyword = in.nextLine();

        ArrayList<Article> searchedList = articleRepository.getSearchArticleList(keyword);

        articleView.printArticle(searchedList);
    }

    private void updateArticle() {
        System.out.print("수정할 게시물 번호 : ");
        int no = Integer.parseInt(in.nextLine());
        int index = no - 1;

        Article article = articleRepository.getAtileOne(index);
        if(article == null){
            System.out.println("없는 게시물입니다.");
        }else {
            System.out.print("제목 : ");
            String title = in.nextLine();


            System.out.print("내용 : ");
            String body = in.nextLine();

            Article newarticle = new Article(title, body);
            articleRepository.updateArticle(newarticle, index);

            System.out.println("수정 완료");
        }
    }
    private void addArticle() {
        System.out.print("제목 : ");
        String title = in.nextLine();

        System.out.print("내용 : ");
        String body = in.nextLine();

        Article article = new Article(title, body);
        articleRepository.addArticle(article);

        System.out.println("게시물 입력 완료");
    }
}
