package main;
/* 조회수, 사용자 정보 추가 위해 변수 및 메서드 추가 */

public class Article {

    private int id;
    private String title;
    private String body;
    private String regDate;
    private String nickname;
    private int hit;

    public Article(int id, String title, String body, String regDate, String nickname, int hit){
        super(); // 부모 클래스의 생성자를 호출할때 사용
        this.id = id;
        this.title = title;
        this.body = body;
        this.regDate = regDate;
        this.nickname = nickname;
        this.hit = hit;
    }

    public int getHit(){
        return hit;
    }

    public void setHit(int hit){
        this.hit = hit;
    }
    public String getNickname(){
        return nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    public String getRegDate(){
        return regDate;
    }

    public void setRegDate(String regDate){
        this.regDate = regDate;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
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
