package Lv2.JadenCase_문자열만들기;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JadenCase_문자열만들기_Pattern {
    public String solution(String s) {
        String answer = "";
        Matcher matcher = Pattern.compile("(\\s*)([\\w])([\\w]*)").matcher(s);
        StringBuilder sb = new StringBuilder();
        while(matcher.find()){
            sb.append(matcher.group(1));
            sb.append(matcher.group(2).toUpperCase());
            sb.append(matcher.group(3).toLowerCase());
        }
        sb.append(s.substring(sb.length()));
        return answer = sb.toString();
    }

    public static void main(String[] args) {
        JadenCase_문자열만들기_Pattern jadenCase_문자열만들기 = new JadenCase_문자열만들기_Pattern();
        String solution = jadenCase_문자열만들기.solution("3people Unfollowed Me  ");

    }

}
