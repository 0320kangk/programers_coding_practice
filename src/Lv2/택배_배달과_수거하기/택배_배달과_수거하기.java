package Lv2.java.택배_배달과_수거하기;


import java.util.Stack;

public class 택배_배달과_수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> stackDeliveries = new Stack();
        Stack<Integer> stackPickups = new Stack<>();
        for (int i = 0; i < deliveries.length; i++) {
            for (int j = 0; j < deliveries[i]; j++) {
                //위치를 개수만큼 stack 넣기
                stackDeliveries.add(i + 1);
            }
        }
        for (int i = 0; i < pickups.length; i++) {
            for (int j = 0; j < pickups[i]; j++) {
                //위치의 개수만큼 stack 넣기
                stackPickups.add(i + 1);
            }
        }
        while (! stackDeliveries.isEmpty() &&
        !stackPickups.isEmpty()) {
            int topD = 0;
            int todP = 0;
            if(!stackDeliveries.isEmpty()) topD = stackDeliveries.peek();
            if(!stackPickups.isEmpty()) todP = stackPickups.peek();
            for (int i = 0; i < cap; i++) {
                if(!stackDeliveries.isEmpty()) stackDeliveries.pop();
                if(!stackPickups.isEmpty()) stackPickups.pop();

            }
            answer += Math.max(topD, todP);
        }

        return answer;
    }

    public static void main(String[] args) {
        택배_배달과_수거하기 택배_배달과_수거하기 = new 택배_배달과_수거하기();
        long solution = 택배_배달과_수거하기.solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
        System.out.println(solution);
    }
}
