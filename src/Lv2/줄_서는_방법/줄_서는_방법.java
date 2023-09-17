package Lv2.줄_서는_방법;

import java.util.ArrayList;
import java.util.List;

public class 줄_서는_방법 {
    public int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>();
        long total=1;
        for(int i=1; i <= n; i++){
            list.add(i);
            total *= i;
        }
        int[] answer = new int[n];
        int i = 0;
        k--;
        while(i < answer.length) {
            total/= n--;
            answer[i++] = list.remove((int)(k / total));
            k %= total;
        }
        return answer;
    }
}
