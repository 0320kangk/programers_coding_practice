package Lv2.JadenCase_문자열만들기;

import java.util.Stack;

public class JadenCase_문자열만들기 {

    public String solution(String s) {
        String answer = "";
        String[] split = s.toLowerCase().split("");
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for (String string : split) {
            if (flag)
                sb.append(string.toUpperCase());
            else
                sb.append(string);
            flag = string.equals(" ");
        }
        return answer = sb.toString();
    }

    public static void main(String[] args) {
        JadenCase_문자열만들기 jadenCase_문자열만들기 = new JadenCase_문자열만들기();
        jadenCase_문자열만들기.solution("for the last   week   ");
    }
}
