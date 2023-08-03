package Lv2.쿼드압축_후_개수_세기;

import java.util.Arrays;

public class 쿼드압축_후_개수_세기2 {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        /*
        모든 수를 카운팅
        0과 1을 찾을 때마다 -하기
         */
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (arr[i][j] == 0)
                    answer[0]++;
                else
                    answer[1]++;
            }
        }
        System.out.println(Arrays.toString(answer));
        while (length / 2 > 1) {
            for (int row = 0; row < arr.length; row += length) {
                for (int col = 0; col < arr.length; col += length) {
                    int init = arr[row][col];
                    boolean flag = true;
                    for (int i = row; i < row + length; i++) {
                        for (int j = col; j < col + length; j++) {
                            if (init != arr[i][j] || arr[i][j] == -1) {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag && length > 1) {
                        answer[init] -= (length * length - 1);
                        for (int i = row; i < row + length; i++) {
                            for (int j = col; j < col + length; j++) {
                                arr[i][j] = -1;
                            }
                        }
                    }
                }
            }
            length /= 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        쿼드압축_후_개수_세기 쿼드압축_후_개수_세기 = new 쿼드압축_후_개수_세기();
        int[] solution = 쿼드압축_후_개수_세기.solution(new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}});
        System.out.println(Arrays.toString(solution));
    }
}