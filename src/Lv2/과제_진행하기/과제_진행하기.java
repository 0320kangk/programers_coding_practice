package Lv2.java.과제_진행하기;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class 과제_진행하기 {
    public String[] solution(String[][] plans) throws ParseException {
        Arrays.sort(plans, (o1, o2) -> o1[1].compareTo(o2[1])); // 과제 정렬하기
        Stack<String[]> stack = new Stack<>(); // 미룬 과제를 보관하는 곳
        List<String> answers = new ArrayList<>(); // 해결한 문제를 두는 곳
        //순서데로 과제 풀기
        for (int i = 0; i < plans.length -1; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            long time1 = sdf.parse(plans[i][1]).getTime(); //현재 과제 시작 시간 ms 단위로 시간 얻기
            long time2 = sdf.parse(plans[i + 1][1]).getTime();// 다음 과제 시작 시간
            long diffMin = (time2-time1) / (1000 * 60); //현재 과제와 다음 과제의 시간 차를 분 단위로 표현
            long workMin = Long.parseLong(plans[i][2]); // 과제 해결 필요 시간을 분 단위로 나타내기
            //일이 밀린 경우
            if (workMin > diffMin) {
                plans[i][2] = String.valueOf(workMin - diffMin);
                stack.add(plans[i]);
            }
            //일이 너무 빨리 끝난 경우
            else {
                answers.add(plans[i][0]); //해결한 과제
                long remainTime = diffMin - workMin; //여유 시간
                //남은 시간 동안 밀렸던 과제 해결하기
                while ( remainTime > 0 && !stack.isEmpty()) {
                    String[] pop = stack.pop(); //밀린 과제
                    int workTime = Integer.valueOf(pop[2]);//과제 해결 필요 시간
                    //과제를 풀다 미룬 경우
                    if (remainTime - workTime < 0) {
                        pop[2] = String.valueOf(workTime - remainTime); //남은 과제 시간 계산
                        stack.add(pop);//과제 다시 미루기
                    } else { //과제를 해결한 경우
                        answers.add(pop[0]);
                    }
                    remainTime -= workTime;//남은 여유 시간
                }
            }
        }
        answers.add(plans[plans.length - 1][0]);//마지막 과제는 미루지 않고 바로 해결해야 한다.
        while (!stack.isEmpty()){
            answers.add(stack.pop()[0]); //미룬 과제를 순서데로 풀기
        }
        String[] answer = answers.toArray(new String[answers.size()]);
        return answer;
    }
}
