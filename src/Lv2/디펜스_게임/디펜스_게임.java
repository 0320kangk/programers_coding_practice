package Lv2.java.디펜스_게임;

import java.util.PriorityQueue;

public class 디펜스_게임 {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if(k >= enemy.length){
            return enemy.length;
        }
        for (int i = 0; i < k; i++) {
            pq.offer(enemy[i]);
        }
        int round = k;
        for (int i = k; i < enemy.length; i++) {
            if ( !pq.isEmpty() && pq.peek() < enemy[i] ) {
                n-= pq.poll();
                pq.add(enemy[i]);
            } else {
                n-= enemy[i];
            }
            if ( n  < 0 ) return round;
            if ( n == 0 ) return round + 1;
            round++;
        }
        return enemy.length;
    }

    public static void main(String[] args) {
        디펜스_게임 디펜스_게임 = new 디펜스_게임();
        int solution = 디펜스_게임.solution(2, 4, new int[]{3,3,3,3});
        System.out.println(solution);
    }
}
