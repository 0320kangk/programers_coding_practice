package Lv2.튜플;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
// [참고 링크](https://school.programmers.co.kr/learn/courses/30/lessons/64065/solution_groups?language=java)

public class 튜플2 {
    public int[] solution(String s) {
        String[] split = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        System.out.println(s.replaceAll("[{]", " ").replaceAll("[}]", " "));
        Arrays.sort(split, (a, b) -> a.length() -b.length());
        int[] answer = new int[split.length];
        Set<String> set = new HashSet<>();
        int index = 0;
        for (String s1 : split) {
            for (String s2 : s1.split(",")) {
                if(set.add(s2)) answer[index++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        튜플2 튜플2 = new 튜플2();
        튜플2.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }
}
