package Lv2.java.두_큐_합_같게_만들기;

import java.util.LinkedList;
import java.util.Queue;

public class 두_큐_합_같게_만들기 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        Queue<Long> q1 = new LinkedList<>();
        long sum1 = 0;
        for (long i : queue1) {
            q1.add(i);
            sum1 += i;
        }
        long sum2 = 0;
        Queue<Long> q2 = new LinkedList<>();
        for (long i : queue2) {
            q2.add(i);
            sum2 += i;
        }
        long total = sum1 + sum2;
        if (total % 2 != 0) {
            return -1;
        }
        //q1 을 중심으로
        int count = 0;
        int q1Input = 0;
        int q2Input = 0;
        long half = total / 2;
        while( sum1 != half) {
            if (sum1 < half) {
                Long poll = q2.poll();
                q1.add(poll);
                sum1 += poll;
                q1Input ++;
            }else {
                Long poll = q1.poll();
                q2.add(poll);
                sum1 -= poll;
                System.out.println(poll);
                q2Input++;
            }
            count++;
            if (q1Input >= queue1.length * 2 || q2Input  >= queue1.length * 2 ){
                count = -1;
                break;
            }
        }
       answer = count;
        return answer;
    }
    public static void main(String[] args) {
        두_큐_합_같게_만들기 두_큐_합_같게_만들기 = new 두_큐_합_같게_만들기();
        int solution = 두_큐_합_같게_만들기.solution(new int[]{1,2,1,2}, new int[]{1,10,1,2});
        System.out.println(solution);
    }
}
