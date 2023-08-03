package Lv2.롤케이크_자르기;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class 롤케이크_자르기 {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for (int i : topping) {
            map.put(i, map.getOrDefault(i, 0) + 1 );
        }
        int kind = map.size();
        HashSet<Integer> slice = new HashSet<>();
        for (int i = 0; i < topping.length; i++) {
            slice.add(topping[i]);
            map.put(topping[i], map.get(topping[i]) -1);
            if ( map.get(topping[i]) == 0 ) {
                kind--;
            }
            if (slice.size()  == kind) {
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        롤케이크_자르기 롤케이크_자르기 = new 롤케이크_자르기();
        int solution = 롤케이크_자르기.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2});
        System.out.println(solution);
    }

}
