package Lv2.java.순위검색;

import java.util.*;

public class 순위검색2 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        HashMap<String, List> map = new HashMap<>();
        for (String s : info)
            getProcessInfo(map, s.split(" "), "",0);
        for (String s : map.keySet())
            Collections.sort(map.get(s));

        for (int i = 0; i < query.length; i++) {
            String replaceQuery = query[i].replaceAll(" and ", "");
            String[] splitQuery = replaceQuery.split(" ");
            if (map.containsKey(splitQuery[0]))
                answer[i] = binarySearch(map.get(splitQuery[0]), Integer.parseInt(splitQuery[1]));
        }
        return answer;
    }
    void getProcessInfo(Map<String, List> map , String[] splitInfo, String unionInfo,  int length) {
        if (length == 4) {
            if (!map.containsKey(unionInfo)) {
                ArrayList<Integer> list = new ArrayList<>();
                map.put(unionInfo, list);
            }
            map.get(unionInfo).add(Integer.parseInt(splitInfo[length]));
            return;
        }
        getProcessInfo(map, splitInfo, unionInfo + "-", length + 1);
        getProcessInfo(map, splitInfo, unionInfo + splitInfo[length], length + 1);
    }

    int binarySearch(List<Integer> list, int minScore) {
        int left = 0;
        int right = list.size() - 1;

        while ( left <= right) {
            int mid = (left + right) / 2;
            if ( list.get(mid) >= minScore ) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return list.size() - left;
    }
    public static void main(String[] args) {
        순위검색2 순위검색 = new 순위검색2();
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
