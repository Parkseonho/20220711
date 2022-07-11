package main;

import java.util.ArrayList;

public class ArticleRepository {
    private ArrayList<Article> articles = new ArrayList<>();

    private int articleId = 4; //testdate에서 번호를3까지 사용, 4부터 시작(add~ 에서 ++해줌)
    public void makeTestDate(){
        Article test1 = new Article(1, "제목1","내용1");
        Article test2 = new Article(2, "제목2","내용2");
        Article test3 = new Article(3, "제목3","내용3");

        articles.add(test1);
        articles.add(test2);
        articles.add(test3);
    }
    /* 
    본래 article에 title과 body만 들어가서 Article article로해도 괜찮았지만, 
    id가 추가됨에 따라 각각입력해야함
      */
    public void addArticle(String title, String body){
        Article article = new Article(articleId, title, body);
        articles.add(article);
        articleId++;
    }

    /* id와 for문에서의 i와 일치하는 경우에만 articles return */
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
    }// update : 수정할 게시물, 수정된 제목, 수정된 내용

    public void deleteArticle(Article article){
        articles.remove(article);
        // 삭제(remove)
    }
}
