package Lv2.N_Queen;

import java.util.Arrays;

public class N_Queen {
    public int solution(int n) {
        int[] arr = new int[n];
        int answer = bt(arr, 0, n);
        return answer;
    }
    int bt (int[] arr, int row , int n) {
        int count = 0;
        if (row == n) {
            return 1;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[row] = i;// 행 = 열
            if (checking(arr, row)) {
                count += bt(arr, row + 1 , n);
            }
        }
        return count;
    }
    boolean checking(int[] arr,int row) {
        for (int i = 0; i < row; i++) {
            if (arr[row] ==arr[i])
                return false;
            if ( Math.abs(arr[row] - arr[i]) == Math.abs( row - i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        N_Queen nQueen = new N_Queen();
        int solution = nQueen.solution(4);
        System.out.println(solution);
    }
}
