package Lv2.미로_탈출;

import java.util.LinkedList;
import java.util.Queue;

public class 미로_탈출 {
    final int[] dx = {-1,1,0,0};//상하
    final int[] dy = {0,0,1,-1};//우좌
    public int solution(String[] maps) {
        int row = maps.length;
        int col = maps[0].length();
        Point startPoint = new Point();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (maps[i].charAt(j) == 'S') {
                    startPoint.row = i;
                    startPoint.col = j;
                    startPoint.d = 0;
                    break;
                }
            }
        }
        Point lPoint = bfs(maps, startPoint, 'L');
        if (lPoint.d == 0 ) return -1;
        Point ePoint = bfs(maps, lPoint, 'E');
        if (ePoint.d == 0 ) return -1;
        int answer = ePoint.d;
        return answer;
    }

    private Point bfs(String[] maps, Point startPoint, char target) {
        int row = maps.length;
        int col = maps[0].length();
        boolean[][] visited = new boolean[row][col];
        Queue<Point> queue = new LinkedList<>();
        queue.add(startPoint);
        Point result = new Point();
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            System.out.println(point);
            if (maps[point.row].charAt(point.col) == target) {
                result.row = point.row;
                result.col = point.col;
                result.d = point.d;
                break;
            }
            //상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = point.row + dx[i]; //행 이동
                int ny = point.col + dy[i]; //열 이동
                if ( nx < row && nx >= 0 &&
                ny < col && ny >= 0 ) {
                    if (visited[nx][ny] == false &&
                    maps[nx].charAt(ny) != 'X' ) {
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny, point.d + 1));
                    }
                }
            }
        }
        return result;
    }
    class Point {
        int row;
        int col;
        int d;
        public Point(int row, int col, int d) {
            this.row = row;
            this.col = col;
            this.d = d;
        }
        public Point() {}
        @Override
        public String toString() {
            return "Point{" +
                    "row=" + row +
                    ", col=" + col +
                    ", d=" + d +
                    '}';
        }
    }
    public static void main(String[] args) {
        미로_탈출 미로_탈출 = new 미로_탈출();
        int solution = 미로_탈출.solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"});
    }
}
