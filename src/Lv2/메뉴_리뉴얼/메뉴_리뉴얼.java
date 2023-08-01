package Lv2.java.메뉴_리뉴얼;

import java.util.*;
import java.util.stream.Collectors;

public class 메뉴_리뉴얼 {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        ArrayList<String> answerList = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < orders.length; j++) {
                int length = orders[j].length();
                boolean[] used = new boolean[length];
                char[] chars = orders[j].toCharArray();
                Arrays.sort(chars);
                makeSet(map,  new String(chars), used, 0,course[i]);
            }
            if (!map.isEmpty()){
                int maxValue = Collections.max(map.values());
                //value가 가장 큰 key를 찾아야 함
                List<String> maxKey = map.entrySet()
                        .stream()
                        .filter(entry -> (entry.getValue() == maxValue &&
                                entry.getValue() > 1))
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());
                for (String key : maxKey)
                    answerList.add(key);
            }

        }
        answer = answerList.stream()
                .sorted()
                .toArray(String[]::new);
        return answer;
    }

    static void makeSet(Map<String, Integer> map, String array, boolean[] used ,int start, int size) {
        if (size == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < used.length; i++) {
                if (used[i])
                    sb.append(array.charAt(i));
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        for (int i = start; i < array.length(); i++) {
            used[i] = true;
            makeSet(map, array, used, i + 1, size - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        메뉴_리뉴얼 메뉴_리뉴얼 = new 메뉴_리뉴얼();
        메뉴_리뉴얼.solution(new String[] {"XYZ", "XWY", "WXA"} ,
                new int[]{2,3,4});
    }
}
