package Lv2.리코쳇_로봇;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇_로봇 {
    final int[] dx = {-1,0,1,0};//상하
    final int[] dy = {0,1,0,-1};//우좌
    public int solution(String[] board) {

        int row = board.length; //행
        int col = board[0].length(); //열
        Queue<int[]> queue = new LinkedList<>();
        int[] startLocation = new int[3];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ( board[i].charAt(j) == 'R' ) {
                    startLocation[0] = i;
                    startLocation[1] = j;
                    startLocation[2] = 0;
                }
            }
        }
        queue.add(startLocation);
        boolean[][] used = new boolean[row][col];
        used[startLocation[0]][startLocation[1]] = true;
        boolean result = false;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = 0;
            int nx = poll[0]; // 행
            int ny = poll[1]; // 열

            while ( i < 4) {
                nx += dx[i]; // 행 이동
                ny += dy[i]; // 열 이동
                //길이 막힌 경우, 가고자 하는 위치
                if (nx >= row || nx < 0 ||
                        ny >= col || ny < 0 ||
                        board[nx].charAt(ny) == 'D'
                ) {
                    if (!used[nx - dx[i]][ny - dy[i]]) {
                        used[nx - dx[i]][ny - dy[i]] = true; //사용된 좌표
                        queue.add(new int[]{nx - dx[i], ny - dy[i], poll[2]+1});
                    }
                    if (board[nx -dx[i]].charAt(ny -dy[i]) == 'G') {
                        return poll[2] + 1;
                    }
                    i++;
                    nx = poll[0];
                    ny = poll[1];
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        리코쳇_로봇 리코쳇_로봇 = new 리코쳇_로봇();
        int solution = 리코쳇_로봇.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."});
        System.out.println(solution);
    }
}
