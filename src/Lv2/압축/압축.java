package Lv2.압축;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 압축 {
    public int[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < 26; i++) {
            map.put(Character.toString( 65 + i), i + 1);
        }
        int indexNum = 26;
        int i = 0;
        while (true) {
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(i++));
            while ( i  < msg.length() && map.containsKey(sb.toString())){
                sb.append(msg.charAt(i++));
            }
            if (map.containsKey(sb.toString())){
                list.add(map.get(sb.toString()));
                break;
            }
            String wAndC = sb.toString();
            list.add(map.get(wAndC.substring(0, wAndC.length() - 1)));
            map.put(sb.toString(), ++indexNum);
            i--;
        }
        return list.stream()
                            .mapToInt( x-> x)
                            .toArray();
    }

    public static void main(String[] args) {
        압축 압축 = new 압축();
        압축.solution("TOBEORNOTTOBEORTOBEORNOT");
    }
}
