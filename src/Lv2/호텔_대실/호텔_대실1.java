package Lv2.호텔_대실;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
public class 호텔_대실1 {

    public int solution(String[][] book_time) {
        int answer = 1;
        //시간 정렬
        Arrays.sort(book_time, (b1, b2) -> (b1[0].compareTo(b2[0])));
        List<Stack<String[]>> lists = new ArrayList<>();
        Stack<String[]> firstRoom = new Stack<>();
        firstRoom.add(book_time[0]);
        lists.add(firstRoom);
        for (int i = 1; i < book_time.length; i++) {
            boolean flag = true;
            for (Stack<String[]> stack : lists) {
                int time = timeDif(stack.peek() , book_time[i]);
                if (time >= 10) {
                    stack.add(book_time[i]);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                Stack<String[]> newRoom = new Stack<>();
                newRoom.add(book_time[i]);
                lists.add(newRoom);
                answer++;
            }
        }
        return answer;
    }

    private static int timeDif(String[] book_time1, String[] book_time2) {
        String[] split1 = book_time1[1].split(":");
        int hour1 = Integer.valueOf(split1[0]) * 60;
        int minute1 = Integer.valueOf(split1[1]);
        String[] split2 = book_time2[0].split(":");
        int hour2 = Integer.valueOf(split2[0]) * 60;
        int minute2 = Integer.valueOf(split2[1]);
        return (hour2 + minute2) - (hour1 + minute1);
    }
}
