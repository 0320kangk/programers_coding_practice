package Lv2.테이블_해시_함수;

import java.util.Arrays;

public class 테이블_해시_함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        row_begin--;
        row_end--;
        Arrays.sort(data, (d1, d2) -> (d2[0] - d1[0]));
        Arrays.sort(data, (d1, d2) -> (d1[col -1 ] - d2[col - 1]));

        int[] tupleR = new int[row_end - row_begin + 1];
        int index = 0;
        for (int i = row_begin; i <= row_end; i++) {
            for (int j = 0; j < data[0].length; j++) {
                tupleR[index] += data[i][j] % (i+1);
            }
            index++;
        }
        int xor = 0;
        for (int i : tupleR) {
            xor = xor ^ i;
        }
        answer = xor;
        return answer;
    }

    public static void main(String[] args) {
        테이블_해시_함수 테이블_해시_함수 = new 테이블_해시_함수();
        int solution = 테이블_해시_함수.solution(new int[][]{{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}, {2, 4, 2}}, 2, 2, 4);
        System.out.println(solution);
    }
}
