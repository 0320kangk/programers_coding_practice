package Lv2.java.주차_요금_계산;

import java.util.*;

public class 주차_요금_계산 {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] split = records[i].split(" ");
            map.put(split[1], map.getOrDefault(split[1], 0) + getTotalTime(split[0], split[2]));
        }
        int[] answer = new int[map.size()];
        int index = 0;
        for (Integer totalTime : map.values()) {
            if (totalTime < 1) totalTime += 1439;
            int fee = fees[1];
            if( totalTime > fees[0])
                fee += Math.ceil ((totalTime - fees[0]) * 1.0 / fees[2]) * fees[3];
            answer[index++] = fee;
        }
        return answer;
    }
    private int getTotalTime(String time, String inOut ) {
        String[] timeSplit = time.split(":");
        int hour = Integer.valueOf(timeSplit[0]) * 60;
        int minute = Integer.valueOf(timeSplit[1]);
        int division = inOut.equals("IN") ? -1 : 1;
        int totalTime = (hour + minute) * division;
        return totalTime;
    }
    public static void main(String[] args) {
        주차_요금_계산 주차_요금_계산 = new 주차_요금_계산();
        int[] solution = 주차_요금_계산.solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                        "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                        "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});

        System.out.println(Arrays.toString(solution));
    }
}
