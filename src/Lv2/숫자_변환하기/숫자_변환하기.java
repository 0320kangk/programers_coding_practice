package Lv2.숫자_변환하기;
import java.util.*;
public class 숫자_변환하기 {
    public int solution(int x, int y, int n) {
        int answer = -1;
        List<Set<Integer>> sets = new ArrayList<>(); //n 번째 연산 결과들(set)을 담을 list
        int count = 0;
        int min = 0; //n 번째 set의 최솟값
        Set<Integer> firstSet = new HashSet(); //1 번째 연산을 담을 set
        firstSet.add(x);//set에 x값 넣기
        sets.add(firstSet); // sets 에 첫 번째 연산 set 넣기
        //n-1 번째 연산값들의 최솟값이 y보다 작다면 반복, 최솟값이 y보다 크다면 y는 구하지 못한다.
        while(min < y){
            Set<Integer> newSet = new HashSet(); //n 번째 연산 결과를 담을 set
            Set<Integer> preSet = sets.get(count); //n-1 번째 연산 결과 set
            min = Integer.MAX_VALUE;
            for (Integer xValue : preSet) {
                //n-1 번째의 set의 최솟값 구하기
                if (min > xValue) {
                    min = xValue;
                } if ( xValue == y) {
                    return count;
                }
                newSet.add(xValue + n); //n번째 연산 결과 넣기
                newSet.add(xValue * 2); //n번째 연산 결과 넣기
                newSet.add(xValue * 3); //n번째 연산 결과 넣기
            }
            count++; //연산 횟수 세기
            sets.add(newSet);
        }
        
        return answer;
    }

}
