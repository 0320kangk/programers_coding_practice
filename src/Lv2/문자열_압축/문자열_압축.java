package Lv2.문자열_압축;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class 문자열_압축 {
    public int solution(String s) {
        int min = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            //0 2 4 6 8
            int length = 0;
            for (int j = 0; j + i <=  s.length();) {
                String piece = s.substring(j, j + i);
                int h = j + i;
                int count = 1;
                while( h + i <= s.length() && s.substring(h, h + i).equals(piece)){
                    h += i;
                    count++;
                }
                if (count == 1)
                    length += i;
                else
                    length += i + String.valueOf(count).length();
                j = h;
            }
            length += s.length() % i;
            min = Math.min(length, min);

        }
        int answer = min;
        return answer;
    }


    public static void main(String[] args) {
        문자열_압축 문자열_압축 = new 문자열_압축();
        int aabbaccc = 문자열_압축.solution("aabbaccc");

        System.out.println(aabbaccc);
    }
}
