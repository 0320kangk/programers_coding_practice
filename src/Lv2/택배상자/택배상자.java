package Lv2.java.택배상자;

import java.util.Stack;

public class 택배상자 {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < order.length; i++) {
            stack.add(i + 1);
            while ( !stack.isEmpty() && stack.peek() == order[index] ) {
                stack.pop();
                index++;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        택배상자 택배상자 = new 택배상자();
        int solution = 택배상자.solution(new int[]{4,3,1,2,5});
        System.out.println(solution);
    }
}
