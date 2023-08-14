package Lv2.방문_길이;

import java.util.Arrays;
import java.util.HashSet;

public class 방문_길이 {
    public int solution(String dirs) {
        int answer = 0;
        // L, R, U, D 방향으로 움직이기
        // 시작 위치는 0,0
        int[][] map = new int[11][11];
        // 5, 5  = (0, 0) 라고 한다면 기본적으로 모든 위치를 +5 해주기?
        int[] point = {5, 5};
        HashSet<Point> points = new HashSet<>();
        for (int i = 0; i < dirs.length(); i++) {
            int x = point[0];
            int y = point[1];
            if (dirs.charAt(i) == 'D' && point[0] < 10  ) {
                point[0]++;
            } else  if (dirs.charAt(i) == 'U' && point[0] > 0  ) {
                point[0]--;
            } else  if (dirs.charAt(i) == 'R' && point[1] < 10  ) {
                point[1]++;
            }else  if (dirs.charAt(i) == 'L' && point[1] > 0  ) {
                point[1]--;
            } else
                continue;
            if(points.add(new Point(new int[]{x, y, point[0], point[1]})) &&
                    points.add(new Point(new int[]{ point[0], point[1], x, y})) &&
                    (x != point[0] || y != point[1])
            )
                answer++;

        }
        return answer;
    }
class Point {
        int [] road;

    public Point(int[] road) {
        this.road = road;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Arrays.equals(road, point.road);
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(road);
    }
}
    public static void main(String[] args) {
        방문_길이 방문_길이 = new 방문_길이();
        int ulurrdllu = 방문_길이.solution("UUUUUUUUUUUUUUU");
        System.out.println(ulurrdllu);
    }
}
