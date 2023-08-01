package Lv2.java.순위검색;

import java.util.*;

/*
이 코드는 프로그래머스 체점 결과 효율성 검사를 통과하지 못했다.
 */
public class 순위검색 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        HashMap<String, Map> map = new HashMap<>();
        for (int i = 0; i < info.length; i++) {
            String[] split = info[i].split(" ");
            save(map, split, 0);
        }
        for (int i = 0; i < query.length; i++) {
            String[] split = query[i].split(" and ");
            answer[i] = find(map, split, 0);
        }
        return answer;
    }
    void save(Map<String, Map> map, String[] info, int length) {
        if (!map.containsKey(info[length]) && length < 3) {
            HashMap<String, Map> valueMap = new HashMap<>();
            map.put(info[length], valueMap);
        }
        if (length == 3) {
            if (!map.containsKey(info[length])) {
                TreeMap<Integer, Integer> valueMap = new TreeMap<>();
                valueMap.put(Integer.valueOf(info[length + 1]), 1);
                map.put(info[length], valueMap);
            } else {
                Map<Integer, Integer> valueMap = map.get(info[length]);
                valueMap.put(Integer.valueOf(info[length + 1]), valueMap.getOrDefault (Integer.valueOf(info[length + 1]),0) + 1);
            }
        }
        if (length < 3)
            save(map.get(info[length]), info, length + 1);
    }
    int find(Map<String, Map> map, String[] query, int length){
        int count = 0;
        if (length < 3) {
            if (!map.containsKey(query[length]) && !query[length].equals("-"))
                return count;
            if ( !query[length].equals("-"))
                count = find(map.get(query[length]), query, length + 1);
            else {
                for (Map valueMap : map.values())
                    count += find(valueMap, query, length + 1);
            }
        }
        else {
            String[] foodAndScore = query[length].split(" ");
            if (map.containsKey(foodAndScore[0]) ){
                Map<Integer, Integer> scoreMap = map.get(foodAndScore[0]);
                int left = getCount(count, foodAndScore, scoreMap);
                int index= 0;
                for (Integer integer : scoreMap.keySet()) {
                    if ( index++ >= left) {
                        count += scoreMap.get(integer);
                    }
                }
            } else if( foodAndScore[0].equals("-") ) {
                for (Map<Integer, Integer> scoreMap : map.values()) {
                    int left = getCount(count, foodAndScore, scoreMap);
                    int index= 0;
                    for (Integer integer : scoreMap.keySet()) {
                        if ( index++ >= left) {
                            count += scoreMap.get(integer);
                        }
                    }
                }
            }
        }
        return count;
    }
    int getCount(int count, String[] foodAndScore, Map<Integer, Integer> scoreMap) {
        count = binarySearch(scoreMap, Integer.valueOf(foodAndScore[1]));
        return count;
    }
    int binarySearch(Map<Integer, Integer> scoreMap, int minScore) {
        Set<Integer> score = scoreMap.keySet();
        Integer[] array = score.toArray(new Integer[0]);

        int left = 0;
        int right = array.length - 1;
        while( left <= right ) {

            int mid = (left + right) / 2; // 20 -> 41
            // minScore 120
            if (array[mid] >= minScore ) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        순위검색 순위검색 = new 순위검색();
        int[] solution = 순위검색.solution(new String[]{"java backend junior pizza 150",
                        "python frontend senior chicken 210",
                        "python frontend senior chicken 150" ,
                        "cpp backend senior pizza 260" ,
                        "java backend junior chicken 80",
                        "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100",
                        "cpp and - and senior and pizza 250",
                        "- and backend and senior and - 150",
                        "- and - and - and - 150"});
        System.out.println(Arrays.toString(solution));

    }
}
