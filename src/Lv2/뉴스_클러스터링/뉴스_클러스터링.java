package skillCheck;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 문제1 {
    public int solution(String str1, String str2) {
        int answer = 0;

        String s1 = str1.toLowerCase();
        String s2 = str2.toLowerCase();
        String s1_1 = s1.replaceAll("[^a-z]", " ");
        String s2_1 = s2.replaceAll("[^a-z]", " ");
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        findSet(s1_1, map1);
        findSet(s2_1, map2);
        if (map1.isEmpty() && map2.isEmpty())
            return 65536;
        int intersection = 0;
        int unionSet = 0 ;
        for (String s : map1.keySet()) {
            if (map2.containsKey(s)) {
                intersection += Math.min(map1.get(s), map2.get(s));
                unionSet += Math.max(map1.get(s), map2.get(s));
            } else {
                unionSet += map1.get(s);
            }
        }
        for (String s : map2.keySet()) {
            if(!map1.containsKey(s))
                unionSet += map2.get(s);
        }

        answer = (int) (1.0 * intersection/unionSet * 65536);

        return answer;
    }

    private static void findSet(String s1_1, HashMap<String, Integer> map) {
        for (int i = 0; i < s1_1.length() - 1; i++) {
            String substring = s1_1.substring(i, i + 2);
            if (substring.charAt(0) == ' ' || substring.charAt(1) == ' ')
                continue;
            map.put(substring, map.getOrDefault(substring, 0) + 1 );
        }
    }

    public static void main(String[] args) {
        문제1 문제1 = new 문제1();
        int solution = 문제1.solution("E=M*C^2", "e=m*c^2");
        System.out.println(solution);
    }
}
