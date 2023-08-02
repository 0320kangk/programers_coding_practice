package Lv2.java.요격_시스템;

import java.util.Arrays;
public class 요격_시스템 {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a , b) -> (a[0]-b[0]));
        int count = 1; //기본 요격 미사일 수 1개
        int startingPoint = 0; //폭격 미사일 시작점
        int endPoint = targets[0][1]; //요격 미사일 위치
        for (int i =1; i < targets.length; i++) {
            startingPoint = targets[i][0];//폭격미사일 시작점
            //폭격미사일 시작점이 요격 미사일 위치보다 뒤에 있는 경우
            if( endPoint <= startingPoint) {
                endPoint = targets[i][1];
                count++;
            } else if (targets[i][1] < endPoint) { // 폭격 미사일 끝점이 요격 미사일 보다 앞에 있는 경우
                endPoint = targets[i][1];
            }
        }
        answer = count;
        return answer;
    }
    public static void main(String[] args) {
        요격_시스템 요격_시스템 = new 요격_시스템();
        int solution = 요격_시스템.solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}});
        System.out.println(solution);
    }

}
