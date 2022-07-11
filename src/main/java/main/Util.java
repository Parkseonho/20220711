package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/* 
    - 날짜 표시를 위한 class
    - localDate.now -> 현재 인터넷에 표시되는 일자
    - DateTimeFormatter.ofPattern -> 일자 표시 방법
    - now.format(formatter) -> 현재 일자를 위에서 표시한 일자 표시방법으로 표시한다.
 */
public class Util {
    public static String getCurrentDate(){
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        String formatedNow = now.format(formatter);

        return formatedNow;
    }
}
