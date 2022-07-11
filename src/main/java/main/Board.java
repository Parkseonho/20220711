package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    

     ArticleView articleView = new ArticleView();
     ArticleRepository articleRepository = new ArticleRepository();
    Scanner in = new Scanner(System.in);

    public void run(){

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
                articleView.printArticle(articleRepository.getArticles());
            } else if (cmd.equals("update")) {
                updateArticle();
                articleView.printArticle(articleRepository.getArticles());
            }else if(cmd.equals("search")){
                searchArticle();
            } else if (cmd.equals("detail")) { // 상세보기
                readDetailArticle();
            } else if (cmd.equals("delete")) {
                deleteArticle();
            } else {
                System.out.println("알 수 없는 명령어");
            }

        }
    }

    /* 게시물 삭제 관련 메서드 */
    private void deleteArticle() {
        System.out.print("삭제할 게시물 번호 : ");
        int targetId = Integer.parseInt(in.nextLine());

        Article article = articleRepository.getAtileOne(targetId);
        articleRepository.deleteArticle(article);

        System.out.println("삭제 완료");
    }

    private void readDetailArticle() {
        System.out.print("상세보기 할 게시물 번호 : ");
        int targetId = Integer.parseInt(in.nextLine());

        Article article = articleRepository.getAtileOne(targetId);

        if(article == null){
            System.out.println("없는 게시물입니다.");
        }else{
            articleRepository.increaseReadCnt(article); //게시물을 조회할때 조회수 상승하게함
            articleView.printArtileDetail(article);

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
        int targetId = Integer.parseInt(in.nextLine());

        Article article = articleRepository.getAtileOne(targetId);
        if(article == null){
            System.out.println("없는 게시물입니다.");
        }else {
            System.out.print("제목 : ");
            String title = in.nextLine();


            System.out.print("내용 : ");
            String body = in.nextLine();

            articleRepository.updateArticle(article, title, body);

            System.out.println("수정 완료");
        }
    }
    private void addArticle() {
        System.out.print("제목 : ");
        String title = in.nextLine();

        System.out.print("내용 : ");
        String body = in.nextLine();

        articleRepository.addArticle(title, body);

        System.out.println("게시물 입력 완료");
    }
}
