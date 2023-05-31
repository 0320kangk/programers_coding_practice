package Lv2.숫자_변환하기;
import java.util.*;
public class 숫자_변환하기 {
    public int solution(int x, int y, int n) {
        int answer = -1;
        List<Set<Integer>> sets = new ArrayList<>();
        int count = 0;
        int min = 0;
        Set<Integer> firstSet = new HashSet();
        firstSet.add(x);
        sets.add(firstSet);
        while(min < y){
            Set<Integer> newSet = new HashSet();
            Set<Integer> preSet = sets.get(count);
            min = Integer.MAX_VALUE;
            for (Integer xValue : preSet) {
                if (min > xValue) {
                    min = xValue;
                } if ( xValue == y) {
                    return count;
                }
                newSet.add(xValue + n);
                newSet.add(xValue * 2);
                newSet.add(xValue * 3);
            }
            count++;
            sets.add(newSet);
        }
        return answer;
    }

    public static void main(String[] args) {
        숫자_변환하기 숫자_변환하기 = new 숫자_변환하기();
        int solution = 숫자_변환하기.solution(1, 1, 1);
        System.out.println(solution);
    }
}
