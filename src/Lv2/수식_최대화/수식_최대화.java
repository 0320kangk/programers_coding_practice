package Lv2.수식_최대화;

import java.util.ArrayList;
import java.util.List;

public class 수식_최대화 {
    public long solution(String expression) {
        long answer = 0;
        Character[][] operator = {{'+','-','*'},
                {'+','*','-'},
                {'-','+','*'},
                {'-','*','+'},
                {'*','-','+'},
                {'*','+','-'}};
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> operatorList = new ArrayList<>();
        ArrayList<Long> nums = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(!Character.isDigit(c)) {
                 nums.add(Long.valueOf(sb.toString()));
                 sb = new StringBuilder();
                 operatorList.add(c);
            } else {
                sb.append(c);
            }
        }
        nums.add(Long.valueOf(sb.toString()));
        long max = 0;
        for (int i = 0; i < operator.length; i++) {
            List<Character> copyOList = new ArrayList<>(operatorList);
            ArrayList<Long> copyNumList = new ArrayList<>(nums);
            for (int j = 0; j < operator[i].length; j++) {
                for (int k = 0; k < copyOList.size(); k++) {
                    long num;
                    if (copyOList.get(k) == operator[i][j] ) {
                        if ( copyOList.get(k) == '*')
                            num = copyNumList.get(k) * copyNumList.get(k + 1);
                        else if ( copyOList.get(k) == '-')
                            num = copyNumList.get(k) - copyNumList.get(k + 1);
                         else
                            num = copyNumList.get(k) + copyNumList.get(k + 1);
                        copyNumList.set(k, num);
                        copyNumList.remove(k + 1);
                        copyOList.remove(k--); //  - + *
                    }
                }
            }
            max = Math.max(max ,Math.abs(copyNumList.get(0)));
        }
        answer = max;
        return answer;
    }
    public static void main(String[] args) {
        수식_최대화 수식_최대화 = new 수식_최대화();
        long solution = 수식_최대화.solution("600+500-800");
        System.out.println(solution);
    }
}
