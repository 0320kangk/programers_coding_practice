package Lv2.튜플;

import java.util.*;

public class 튜플 {
    public int[] solution(String s) {
        String[] split = s.split("}");
        List<List<Integer>> list = new ArrayList<>();
        for (String stringE : split) {
            ArrayList<Integer> eList = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < stringE.length(); i++) {
                if( Character.isDigit(stringE.charAt(i))) {
                    sb.append(stringE.charAt(i));
                }
                if ( i > 0 && stringE.charAt(i) == ',' || i == stringE.length() - 1){
                    eList.add(Integer.parseInt(sb.toString()));
                    sb = new StringBuilder();
                }
            }
            list.add(eList);
        }
        list.sort((l1, l2) -> l1.size() - l2.size());
        HashSet<Integer> set = new HashSet<>();
        int[] answer = new int[split.length];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if(set.add(list.get(i).get(j)))
                    answer[i] = list.get(i).get(j);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        튜플 튜플 = new 튜플();
        튜플.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }
}
