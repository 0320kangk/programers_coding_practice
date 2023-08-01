package Lv2.java.우박수열_정적분;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 우박수열_정적분 {

    public double[] solution(int k, int[][] ranges) {

        List<Integer[]> list = new ArrayList<>();
        while ( k > 1) {
            list.add(new Integer[]{list.size() ,k});
            if ( k % 2 == 0) {
                k /= 2;
            } else {
                k *= 3;
                k++;
            }
        }
        list.add(new Integer[]{list.size() ,k});
        //넓이 구하기
        double[] width = new double[list.size() - 1];
        for (int i = 0; i < list.size() - 1; i++) {
            Integer[] point1 = list.get(i);
            Integer[] point2 = list.get(i + 1);
            width[i] = (point1[1] + point2[1]) * 1.0 / 2;
        }
        //범위에 맞는 결과 구하기
        int start = 0;
        int end = list.size() - 1;
        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int x1 = start + ranges[i][0];
            int x2 = end + ranges[i][1];
            double rangeWidth = 0;
            if ( x2 >= x1 ){
                for (int j = x1; j < x2; j++) {
                    rangeWidth += width[j];
                }
                answer[i] = rangeWidth;
            } else
                answer[i] = -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        우박수열_정적분 우박수열_정적분 = new 우박수열_정적분();
        double[] solution = 우박수열_정적분.solution(5, new int[][]{{0, 0}, {0, -1}, {2, -3}, {3, -3}});
        System.out.println(Arrays.toString(solution));
    }
}
