package Lv2.행렬_테두리_회전하기;

import java.util.ArrayList;
import java.util.Arrays;
public class 행렬_테두리_회전하기 {
    private final int[] dy = {1,0,-1,0};
    private final  int[] dx = {0,1,0,-1};
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int index = 0;
        int[][] arrays = new int[rows + 1][columns + 1];
        int num = 1;
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < columns + 1; j++) {
                arrays[i][j] = num++;
            }
        }
        for (int[] query : queries) {
            int [] point = {query[0], query[1]};

            ArrayList<Integer> list = new ArrayList<>();
            int pre = arrays[point[0]][point[1]];
            for (int i = 0; i < 4; i++) {
                int d = query[3 - i];
                while ( ((point[(i+1) % 2] < d) && i < 2) ||
                        ((point[(i+1) % 2] > d) && i >= 2)) {
                    int next = arrays[point[0] + dx[i]][point[1] + dy[i]];
                    arrays[point[0] + dx[i]][point[1] + dy[i]] = pre;
                    list.add(pre);
                    point[0] += dx[i];
                    point[1] += dy[i];
                    pre = next;
                }
            }
            answer[index++] = list.stream()
                    .mapToInt(x -> x)
                    .min()
                    .orElse(0);
        }
        return answer;
    }

    public static void main(String[] args) {
        행렬_테두리_회전하기 행렬_테두리_회전하기 = new 행렬_테두리_회전하기();
        int[] solution = 행렬_테두리_회전하기.solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
        System.out.println(Arrays.toString(solution));
    }
}
