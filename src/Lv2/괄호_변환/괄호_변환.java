package Lv2.괄호_변환;

import java.util.Stack;

public class 괄호_변환 {

    public String solution(String p) {
        String answer = "";
        answer = search(p);
        return answer;
    }
    /*
    1. p를 반으로 쪼겜
     */
    String search(String bracket) {
        int openCount = 0;
        int closeCount = 0;
        int i = 0;
        for (i = 0; i < bracket.length(); i++) {
                 if (bracket.charAt(i) == '('){
                    openCount++;
                 } else
                     closeCount++;
                 if (openCount == closeCount)
                     break;
        }
        if (openCount == closeCount && !bracket.isEmpty()) {
            System.out.println("u : " + bracket.substring(i + 1));
            System.out.println("v : " +bracket.substring(0, i + 1));
            String vBracket = search(bracket.substring(i + 1));
            String uBracket = bracket.substring(0, i + 1);
            if (!checkBracket(uBracket)) {
                System.out.println("4단계: ");
                System.out.println("v 브라켓"+ vBracket);
                bracket = "(" + search(vBracket)+ ")";
                StringBuilder sb = new StringBuilder();
                for (int j = 1; j < uBracket.length() - 1; j++) {
                    if(uBracket.charAt(j) == '(')
                        sb.append(')');
                    else
                        sb.append('(');
                }
                bracket += sb.toString();
                System.out.println(bracket);
            } else
                bracket = uBracket + vBracket;
        }
        return bracket; // v뒤에 u를 붙인다?
    }
    boolean checkBracket(String bracket){
        Stack<Character> stack = new Stack<>();
        stack.add(bracket.charAt(0));
        for (int i = 1; i < bracket.length(); i++) {
            if(!stack.isEmpty() &&
            bracket.charAt(i)== ')'){
                stack.pop();
            } else {
                stack.add('(');
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        괄호_변환 괄호_변환 = new 괄호_변환();
        String solution = 괄호_변환.solution(")())((");
        System.out.println(solution);
    }
}
