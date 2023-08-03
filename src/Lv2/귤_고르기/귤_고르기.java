package Lv2.귤_고르기;

import java.util.*;

public class 귤_고르기 {

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        for (Integer i : list) {
            if (k > 0 ){
                answer++;
            }
            k -= i;
        }

        return answer;
    }
}
