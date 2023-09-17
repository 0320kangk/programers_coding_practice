package Lv2.프렌즈4블록;

import java.util.ArrayList;

public class 프렌즈4블록  {

    int[] dy = {1, 0, -1};
    int[] dx = {0, 1, 0};
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int preAnswer = -1;
        for (String s : board) {
            System.out.println(s);
        }
        while (answer != preAnswer) {
            preAnswer = answer;
            ArrayList<Point> points = new ArrayList<>();
            for (int i = 0; i < m - 1 ; i++) {// 행
                for (int j = 0; j <  n - 1; j++) { //열
                    int[] point = {i, j};
                    char c = board[point[0]].charAt(point[1]);

                    ArrayList<Point> squarePoints = new ArrayList<>();
                    squarePoints.add(new Point(point[0], point[1]));
                    for (int k = 0; k < 3; k++) {
                        point[0] = point[0] + dx[k];
                        point[1] = point[1] + dy[k];
                        if ( board[point[0]].charAt(point[1]) != c || c == ' ' )
                            break;
                        squarePoints.add(new Point(point[0], point[1]));
                    }
                    if (squarePoints.size() == 4) {
                        for (Point squarePoint : squarePoints) {
                            if (!points.contains(squarePoint)){
                                answer++;
                                points.add(squarePoint);
                            }
                        }
                    }
                }
            }
            for (Point movePoint : points) {
                changeBlock(board, new Integer[]{movePoint.x, movePoint.y}, ' ');
            }
            for (int i = 0; i < n; i++) {
                for (int j = m - 1; j >= 0; j--) {
                    if (board[j].charAt(i) == ' ') {
                        for (int k = j - 1; k >= 0; k--) {
                            if (board[k].charAt(i) != ' ') {
                                changeBlock(board, new Integer[]{j, i}, board[k].charAt(i));
                                changeBlock(board, new Integer[]{k, i}, ' ');
                                break;
                            }
                        }

                    }
                }
            }
            System.out.println();
            for (String s : board) {
                System.out.println(s);
            }
        }
        return answer;
    }
    private static void changeBlock(String[] board, Integer[] movePoint, char c ) {
        board[movePoint[0]] =
                board[movePoint[0]].substring(0, movePoint[1]) +
                        c +
                        board[movePoint[0]].substring(movePoint[1]+1);
    }
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
    }
    public static void main(String[] args) {

        프렌즈4블록 프렌즈4블록 = new 프렌즈4블록();
        프렌즈4블록.solution(6, 6, new String[]{"TTTTTT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"});
        ArrayList<Integer[]> objects = new ArrayList<>();
        int[] ints = {1, 1};
    }
}
