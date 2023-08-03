package Lv2.거리두기_확인하기;

import java.util.Arrays;

public class 거리두기_확인하기2 {
    final static int[] dx = {1, -1, 0, 0};
    final static int[] dy = {0, 0, 1, -1};
    int[] answer = {1,1,1,1,1};
    public int[] solution(String[][] places) {
        boolean[][] used = new boolean[5][5];
        for (int i = 0; i < places.length ; i++) {
            String[] place = places[i];
            for (int j = 0; j < place.length; j++) {
                for (int k = 0; k < place[0].length(); k++) {
                    if (place[j].charAt(k) == 'P' && answer[i] == 1) {
                        used[j][k] = true;
                        if(!dfs(place, used, 0, new int[]{j, k}, true))
                            answer[i] = 0;
                        used[j][k] = false;
                    }
                }
            }
        }
        return answer;
    }
    boolean dfs(String[] place, boolean[][] used, int length, int[] point, boolean result) {
        if (place[point[0]].charAt(point[1]) == 'P' &&
                length > 0 && length <= 2) {
                return false;
        }
        for (int i = 0; i < 4; i++) {
            int x = point[0] + dx[i];
            int y = point[1] + dy[i];
            if (x >= 0 && x < place.length &&
                    y >= 0 && y <  place[0].length()
            ) {
                if ( !used[x][y] &&
                        ( place[x].charAt(y) == 'O' || place[x].charAt(y) == 'P')
                ){
                    used[x][y] = true;
                    result = dfs(place,used, length + 1, new int[] {x, y}, result);
                    used[x][y] = false;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        거리두기_확인하기2 거리두기_확인하기 = new 거리두기_확인하기2();
        int[] solution = 거리두기_확인하기.solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
        System.out.println(Arrays.toString(solution));
    }

}
