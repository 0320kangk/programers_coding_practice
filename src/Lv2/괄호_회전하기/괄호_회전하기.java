package Lv2.괄호_회전하기;

import java.util.*;

public class 괄호_회전하기 {
    public int solution(String s) {
        //괄호 문자 문제
        int answer = 0;
        Deque<Character> deque = new ArrayDeque<>(); //회전을 위한 덱
        for (int i = 0; i < s.length(); i++) {
            deque.add(s.charAt(i)); // 덱에 괄호 넣기
        }
        Stack<Character> stack = new Stack<>();//올바른 괄호인지 확인하기 위한 스택
        for (int i = 0; i < deque.size() - 1; i++) {
            Iterator<Character> iterator = deque.iterator();
            if (check(iterator, stack)) // 올바른 괄호인지 확인
                answer++;
            deque.addLast(deque.removeFirst()); //덱 시계 방향으로 회전시키기
        }
        return answer;
    }

    /**
     *
     * @param s : 괄호 문자열
     * @param stack : 괄호 문자열 확인
     * @return : 올바른 괄호 문자열 : true, 올바르지 않는 괄호 문자열: false
     */
    private boolean check(Iterator<Character> s, Stack<Character> stack) {
        while (s.hasNext()) {
            char c = s.next();
            if ( c == '{' ||
                c == '[' ||
                c == '(' ) {
                stack.add(c);
            }
            else if ( !stack.isEmpty() &&
                    (((c == '}') && stack.peek() == '{')
                    ||
                    ((c == ']') && stack.peek() == '[')
                    ||
                    ((c == ')') && stack.peek() == '(')
                    )
            ){
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        괄호_회전하기 괄호_회전하기 = new 괄호_회전하기();
        int solution = 괄호_회전하기.solution("[](){}");
        System.out.println(solution);
    }
}
