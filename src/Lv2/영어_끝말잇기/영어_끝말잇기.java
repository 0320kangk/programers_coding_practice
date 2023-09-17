package Lv2.영어_끝말잇기;

import java.util.HashSet;
import java.util.Set;



public class 영어_끝말잇기 {

    public int[] solution(int n, String[] words) {
        int[] answer = {};
        Set<String> set = new HashSet<>();
        int num = 0;
        int order = 1;
        for (int i = 0;  i< words.length; i++) {
            if ( num == n) {
                num %= n;
                order++;
            }
            num++;
            if ( i > 0 && words[i].charAt(0) != words[i - 1].charAt(words[i-1].length() - 1))
                break;
            if (!set.add(words[i]))
                break;
        }
        answer = new int[] {num ,order};
        if (set.size() == words.length)
            answer = new int[] {0, 0};
        return answer;
    }

    public static void main(String[] args) {
        영어_끝말잇기 영어_끝말잇기 = new 영어_끝말잇기();
        영어_끝말잇기.solution(2, new String[] {"hello", "one", "even", "never", "now", "world", "draw"});
    }
}
