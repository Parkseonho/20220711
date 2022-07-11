package main;

import java.util.ArrayList;
/* 이름 및 조회수 추가 */
public class ArticleRepository {
    private ArrayList<Article> articles = new ArrayList<>();

    private int articleId = 4;
    public void makeTestDate(){ //등록일 추가
        Article test1 = new Article(1, "제목1","내용1", Util.getCurrentDate(),"사람1", 20);
        Article test2 = new Article(2, "제목2","내용2", Util.getCurrentDate(), "사람2", 10);
        Article test3 = new Article(3, "제목3","내용3", Util.getCurrentDate(), "사람3", 50);

        articles.add(test1);
        articles.add(test2);
        articles.add(test3);
    }
     
    public void addArticle(String title, String body){
        Article article = new Article(articleId, title, body, Util.getCurrentDate(), "익명", 70);
        articles.add(article);
        articleId++;
    }


    public Article getAtileOne(int id){
        for(int i = 0 ; i < articles.size(); i++){
            if(articles.get(i).getId() == id){
                return articles.get(i);
            }
        }
        return null;
    }

    public ArrayList<Article> getSearchArticleList(String keyword){

        ArrayList<Article> searchArticleList = new ArrayList<>();

        for(int i = 0; i < articles.size(); i++){
            if(articles.get(i).getTitle().contains(keyword)){
                searchArticleList.add(articles.get(i));
            }
        }
        return searchArticleList;
    }

    public ArrayList<Article> getArticles(){
        return this.articles;
    }

    public void updateArticle(Article article, String title, String body){
        article.setTitle(title);
        article.setBody(body);
    }

    public void deleteArticle(Article article){
        articles.remove(article);
     
    }
    public void increaseReadCnt(Article article){
        article.setHit(article.getHit()+1);
    }// 조회수 증가
}
