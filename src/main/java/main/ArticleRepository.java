package main;

import java.util.ArrayList;

public class ArticleRepository {
    private ArrayList<Article> articles = new ArrayList<>();

    public void makeTestDate(){
        Article test1 = new Article("제목1","내용1");
        Article test2 = new Article("제목2","내용2");
        Article test3 = new Article("제목3","내용3");

        articles.add(test1);
        articles.add(test2);
        articles.add(test3);
    }
    public void addArticle(Article article){
        articles.add(article);
    }

    public Article getAtileOne(int idx){
        if(idx<0 || idx >= articles.size()){
            return null;
        }
        return articles.get(idx);
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

    public void updateArticle(Article article, int idx){
        articles.set(idx, article);
    }

    public void deleteArticle(int idx){
        articles.remove(idx);
    }
}
