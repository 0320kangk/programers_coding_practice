package Lv2.당구연습;

import java.util.ArrayList;
import java.util.List;

public class 당구_연습 {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        //대칭이동과
        //거리계산 함수 각각 두개 만들기
        Point board = new Point(m, n);
        Point startPoint = new Point(startX, startY);
        for (int i = 0; i < balls.length; i++) {
            Point ballPoint = new Point(balls[i][0], balls[i][1]);
            List<Point> flip = flip(board, startPoint, ballPoint);
            int minDistance = Integer.MAX_VALUE;
            for (Point point : flip) {
                int distance = twoPointDistance(startPoint, point);
                minDistance = Math.min(distance, minDistance);
            }
            answer[i] = minDistance;
        }
        return answer;
    }

    private List<Point> flip (Point board, Point start, Point ball) {
        List<Point> points = new ArrayList<>();
        if (!(ball.x == start.x && start.y > ball.y) )
            points.add(new Point(ball.x, ball.y * -1 ));//보드판 아래 가로 변 대칭
        if (!(ball.y == start.y && start.x > ball.x))
            points.add(new Point(ball.x * -1, ball.y));//보드판 왼쪽 세로 변 대칭
        if (!(ball.x == start.x && start.y < ball.y ))
            points.add(new Point(ball.x, board.y + (board.y - ball.y) ));//보드판 위쪽 가로 변 대칭
        if (!(ball.y == start.y && start.x < ball.x))
            points.add(new Point(board.x + (board.x- ball.x), ball.y));//보드판 오른쪽 세로 변 대칭
        return points;
    }
    private int twoPointDistance(Point start, Point ball) {
        return (int) (Math.pow(Math.abs(ball.x - start.x), 2) + Math.pow(Math.abs(ball.y - start.y), 2));
    }
    class Point {
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
