package Lv2.연속_부분_수열_합의_개수;

import java.util.HashSet;

public class 연속_부분_수열_합의_개수2 {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        //길이
        int[] dp = new int[elements.length];
        for (int len = 1; len <= elements.length; len++) {
            //조합
            for (int j = 0; j < elements.length; j++) {
                dp[j] +=  elements[((len + j -1) % elements.length)];
                set.add(dp[j]);
            }
        }
        int answer = set.size();
        return answer;
    }
}
