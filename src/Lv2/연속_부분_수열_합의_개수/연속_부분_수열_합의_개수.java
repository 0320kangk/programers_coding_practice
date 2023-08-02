package Lv2.java.연속_부분_수열_합의_개수;

import java.util.HashSet;

public class 연속_부분_수열_합의_개수 {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        //길이
        for (int i = 1; i <= elements.length; i++) {
            //조합
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                int count = i;
                for (int k = j; count > 0; count--) {
                    sum += elements[ k++ % elements.length ];
                }
                set.add(sum);
            }
        }
        int answer = set.size();
        return answer;
    }

    public static void main(String[] args) {
        연속_부분_수열_합의_개수 연속_부분_수열_합의_개수 = new 연속_부분_수열_합의_개수();
        연속_부분_수열_합의_개수.solution(new int[] {7, 9,1,1,4});
    }
}
