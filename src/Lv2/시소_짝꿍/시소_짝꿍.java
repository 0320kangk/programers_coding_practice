package Lv2.java.시소_짝꿍;

import java.util.HashMap;
import java.util.Set;

public class 시소_짝꿍 {
    public long solution(int[] weights) {
        long answer = 0;
        HashMap<Double, Long> map = new HashMap<>();
        for (double weight : weights) {
            map.put(weight, map.getOrDefault(weight,0L) + 1);
        }
        Set<Double> keys = map.keySet();
        double[] ratio = {3/2.0, 4/3.0, 2};
        for (double key : keys) {
            Long value = map.get(key);
            answer += (value * (value -1))/2 ;
            for (double i : ratio) {
                double pairKey =  (key * i);
                if ( map.containsKey(pairKey)) {
                    Long pairValue = map.get(pairKey);
                    answer += value * pairValue;
                }
            }
        }
        return answer;
    }
}
