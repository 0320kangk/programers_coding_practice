package Lv2.교점에_별_만들기;

import java.util.ArrayList;
import java.util.Collections;

public class 교점에_별_만들기 {
    public String[] solution(int[][] line) {
        String[] answer = {};
        ArrayList<Long[]> list = new ArrayList<>();
        for (int i = 0; i < line.length - 1; i++) {
            int[] e1 = line[i];
            for (int j = i+1; j < line.length; j++) {
                int[] e2 = line[j];
                if ((e1[0] * e2[1] - e1[1] * e2[0]) == 0)
                    continue;

                double x = ( 1l * e1[1] * e2[2] - 1l * e1[2] * e2[1]  ) * 1.0 / ( 1l * e1[0] * e2[1] - 1l *e1[1] * e2[0]);
                double y = ( 1l * e1[2] * e2[0] - 1l * e1[0] * e2[2] ) * 1.0 / ((1l * e1[0] * e2[1]) - (1l * e1[1] * e2[0]));
                if ( x != (long) x ||
                        y != (long)y )
                    continue;
                list.add(new Long[]{(long)x, (long)y});
            }
        }
        //x 최솟값
        Collections.sort(list,(a, b) ->(int)(a[0] - b[0]));
        long minX = list.get(0)[0];
        //x 최댓값
        Collections.sort(list,(a, b) ->((int) (b[0] - a[0]) ));
        long maxX = list.get(0)[0];
        //y 최솟값
        Collections.sort(list,(a, b) ->((int)(a[1] - b[1])));
        long minY = list.get(0)[1];
        //y 최댓값
        Collections.sort(list,(a, b) ->((int) (b[1] - a[1]) ));
        long maxY = list.get(0)[1];


        long  row = Math.abs(maxY - minY) + 1;
        long  col = Math.abs(maxX - minX) + 1;
        String[] board = new String[(int)row];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < col ; i++) {
            sb.append(".");
        }
        for (int i = 0; i < board.length; i++){
            board[i] = sb.toString();
        }
        for (Long[] point : list) {
            int x = (int) (point[0] - minX);
            int y = (int)  (maxY  - point[1]);
            char[] chars = board[y].toCharArray();
            chars[x] = '*';
            board[y] = String.valueOf(chars);
        }
        answer = board;
        return answer;
    }
    public static void main(String[] args) {
        교점에_별_만들기 교점에_별_만들기 = new 교점에_별_만들기();
        String[] solution = 교점에_별_만들기.solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}});
        for (String s : solution) {
            System.out.println(s);
        }
    }
}
