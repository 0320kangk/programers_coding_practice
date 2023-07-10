package skillCheck;


import java.util.Arrays;

public class 문제1 {
    public int[] solution(int n) {

        int[][] triangle = new int[n][n];
        //아래, 오른쪽 왼쪽 위
        int size = ((n + 1) * n ) / 2;
        int[] answer = new int[size];
        int x = -1;
        int y = 0;
        int num = 1;
        for (int i = 0; i < n; i++){
            for(int j = i ; j < n; j++) {
                if( i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else  if (i % 3 == 2) {
                    x--;
                    y--;
                }
                triangle[x][y] = num++;
            }
        }

        int i = 0;
        for (int[] ints : triangle) {
            for (int anInt : ints) {
                if (anInt != 0)
                    answer[i++] = anInt;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        문제1 문제1 = new 문제1();
        int[] solution = 문제1.solution(6);
        System.out.println(Arrays.toString(solution));
    }

}
