package Lv2.n2_배열_자르기;

import java.util.Arrays;

public class n2_배열_자르기 {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1);
        int[] answer = new int[size];
        int startRow = (int)(left / n);
        int endRow = (int)(right / n);
        int startCol = (int)(left % n);
        int index = 0;
        for (int i = startRow; i <= endRow; i++) {
            int j = 0;
            if ( i == startRow )
                j = startCol;
                while ( j < n) {
                    if (index >= size)
                        break;
                    answer[index++] = i >= j ? i +1 : j + 1;
                    j++;
                }
        }
        return answer;
    }
    public static void main(String[] args) {
        n2_배열_자르기 n2_배열_자르기 = new n2_배열_자르기();
        int[] solution = n2_배열_자르기.solution(4, 7, 14);
        System.out.println(Arrays.toString(solution));
    }
}
