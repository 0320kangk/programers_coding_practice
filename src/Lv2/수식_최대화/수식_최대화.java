package Lv2.수식_최대화;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class 수식_최대화 {
    public long solution(String expression) {
        long answer = 0;
        Character[][] operator = {{'+','-','*'},
                {'+','*','-'},
                {'-','+','*'},
                {'-','*','+'},
                {'*','-','+'},
                {'*','+','-'}};
        /*
        모든 연산자 순서를만들어 두는 것이 편할듯?
        우선순위에 맞게 연산하는 방법
        -가 들어오려 하면 스택 연산
         */
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> operatorList = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if( c < '0' ||
            c > '9') {
                 nums.add(Integer.valueOf(sb.toString()));
                 sb = new StringBuilder();
                 operatorList.add(c);
            } else {
                sb.append(c);
            }
        }
        nums.add(Integer.valueOf(sb.toString()));
       /* System.out.println(nums);
        System.out.println(operatorList);*/
        int max = 0;
        for (int i = 0; i < operator.length; i++) {
            for (int j = 0; j < operator[i].length; j++) {
                for (int k = 0; k < operatorList.size(); k++) {
                    int num;
                    if (operatorList.get(k) == operator[i][j] ) {
                        if ( operatorList.get(k) == '*') {
                            num = nums.get(k) * nums.get(k + 1);
                        }else if ( operatorList.get(k) == '-') {
                            num = nums.get(k) - nums.get(k + 1);
                        } else {
                            num = nums.get(k) + nums.get(k + 1);
                        }
                        nums.remove(k);
                        nums.remove(k); // 1,2,3,4,5
                        nums.add(k, num);

                    }
                }
            }
            max = Math.max(max ,nums.get(0));
        }
        answer = max;
        return answer;
    }

    public static void main(String[] args) {
        수식_최대화 수식_최대화 = new 수식_최대화();
        long solution = 수식_최대화.solution("100-200*300-500+20");
        System.out.println(solution);
    }
}
