package Lv2.호텔_대실;
import java.util.*;

public class 호텔_대실2 {
    public int solution(String[][] book_time) {
        //시간 정렬
        int[][] intsBookTime = new int[book_time.length][2];

        for (int i = 0; i < book_time.length; i++) {
            intsBookTime[i] = new int[] { parseTime(book_time[i][0]), parseTime(book_time[i][1]) + 10};
        }
        Arrays.sort(intsBookTime, (time1, time2) -> (time1[0] - time2[0])); //먼저 에약하는 순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1]-b[1])); //우선순위 기준은 먼저 끝나는 예약
        int answer = 0;
        for (int i = 0; i < intsBookTime.length; i++) {
            //기존 방 사용 가능 여부
          while (!pq.isEmpty() && pq.peek()[1] <= intsBookTime[i][0]) {
              pq.poll(); // 기존 방의 예약자가 나감
          }
          pq.add(intsBookTime[i]);
          answer = Math.max(answer, pq.size());//기존보다 pq 사이즈가 더 커졌다면 새로운 방이 생긴 것
        }
        return answer;
    }

    private int parseTime(String time) {
        String[] hm = time.split(":");
        int hour = Integer.parseInt(hm[0]);
        int min = Integer.parseInt(hm[1]);
        return hour * 60 + min;
    }

    public static void main(String[] args) {
        호텔_대실2 호텔_대실 = new 호텔_대실2();
        int solution = 호텔_대실.solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}});
        System.out.println(solution);
    }
}
