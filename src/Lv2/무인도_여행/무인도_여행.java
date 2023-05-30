package Lv2.무인도_여행;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 무인도_여행 {
    final int[] dx = {-1, 1,0,0};// 상하
    final int[] dy = {0, 0, -1 ,1};// 좌우
    //무인도의 범위를 알 수 있어야 함
    //bfs?
    int bfsFindLand(Integer[] point, boolean[][] usedMap, String[] maps) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(point);
        usedMap[point[0]][point[1]] = true;
        int sum = 0;
        while (!queue.isEmpty()) {
            Integer[] move = queue.poll();
            sum += maps[move[0]].charAt(move[1]) - '0';
            for (int i = 0; i < 4; i++) {
                int nx = move[0] + dx[i];
                int ny = move[1] + dy[i];
                if ( nx < maps.length && nx >= 0 &&
                    ny < maps[0].length() && ny >= 0) {
                    if (usedMap[nx][ny] == false) {
                        usedMap[nx][ny] = true;
                        queue.add(new Integer[]{nx, ny});
                    }
                }
            }
        }
        for (Integer[] restPoint: queue) {
            sum += maps[restPoint[0]].charAt(restPoint[1]) - '0';
        }
        return sum;
    }
    public int[] solution(String[] maps) {
        ArrayList<Integer> sums = new ArrayList<>();
        boolean[][] usedMap = new boolean[maps.length][maps[0].length()];
        for (int i = 0; i < usedMap.length; i++) {
            for (int j = 0; j < usedMap[0].length; j++) {
                if (maps[i].charAt(j) == 'X'){
                    usedMap[i][j] = true;
                }
            }
        }
        for (int i = 0; i < usedMap.length; i++) {
            for (int j = 0; j < usedMap[0].length; j++) {
                if (usedMap[i][j] == false){
                    sums.add(bfsFindLand(new Integer[]{i, j}, usedMap, maps));
                }
            }
        }
        int[] answer = sums.stream()
                .mapToInt(i -> i)
                .sorted()
                .toArray();
        if (answer.length == 0)
            return new int[] {-1};
        return answer;
    }

    public static void main(String[] args) {
        무인도_여행 무인도_여행 = new 무인도_여행();
        int[] solution = 무인도_여행.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});
        System.out.println(Arrays.toString(solution));
    }
}
