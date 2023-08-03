package Lv2.할인_행사;

import java.util.*;

public class 할인_행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int left = 0;
        int right = 9;

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) map.put(discount[i], map.getOrDefault(discount[i], 0) +1 );
        while (right < discount.length) {
            if (check(map, want, number)) answer++;
            right++;

            if ( right < discount.length){
                map.put( discount[right], map.getOrDefault(discount[right],0) + 1);
                map.put( discount[left], map.get(discount[left]) -1);
                left++;
            }
        }
        return answer;
    }
    private  boolean check(Map<String, Integer> map, String[] want, int[] number) {

        for (int i = 0; i < want.length; i++) {
            if (map.getOrDefault(want[i], 0) != number[i]) return  false;
        }
        return true;
    }


    public static void main(String[] args) {
        할인_행사 할인_행사 = new 할인_행사();
        int solution = 할인_행사.solution(new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});
        System.out.println(solution);


    }
}
