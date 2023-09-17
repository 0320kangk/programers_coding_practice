package Lv2.짝지어_제거하기;

import java.util.Stack;

public class 짝지어_제거하기 {
    public int solution(String s) {
        int answer = 1;
        //stack을 사용하기?
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else
                stack.add(c);
        }
        if (!stack.isEmpty())
            answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        짝지어_제거하기 짝지어_제거하기 = new 짝지어_제거하기();
        int solution = 짝지어_제거하기.solution("caacc");
        System.out.println(solution);
    }
}
