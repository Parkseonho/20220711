package main;

/*
title과 body를 private로 바꾸면서 
다른 public을 제작하여 세부항목별로 가져갈수 있게됨
 */
public class Article {
    private String title;
    private String body;

    public Article(String title, String body){
        this.title = title;
        this.body = body;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getBody(){
        return body;
    }
    public void setBody(String body){
        this.body = body;
    }
}
