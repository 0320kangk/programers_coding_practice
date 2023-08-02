package Lv2.java.마법의_엘리베이터;

import java.util.Stack;

public class 마법의_엘리베이터1 {

    public int solution(int storey) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        while (storey !=0 ) {
            stack.add( storey % 10);
            storey /= 10;
        }
        int add = 0;
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            Integer num1 = stack.pop() + add;
            if ( num1 == 5 ){
                answer += 5;
                add = 0;
                if ( !stack.isEmpty() && stack.peek() >= 5 ) {
                    add = 1;
                }
            } else if ( num1 < 5){
                answer += num1;
                add = 0;
            } else {
                answer += 10 - num1;
                add = 1;
            }
        }
        answer += add;
        return answer;
    }



    public static void main(String[] args) {
        마법의_엘리베이터1 마법의_엘리베이터 = new 마법의_엘리베이터1();
        int solution = 마법의_엘리베이터.solution(154);
        System.out.println(solution);
    }
}
