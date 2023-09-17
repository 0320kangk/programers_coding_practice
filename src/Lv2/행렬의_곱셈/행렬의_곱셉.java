package Lv2.행렬의_곱셈;

public class 행렬의_곱셉 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {//arr1행
            for (int j = 0; j < arr2[0].length; j++) { //arr2열
                for (int k = 0; k < arr1[0].length; k++) { //arr1, arr2 열
                    int num1 = arr1[i][k];
                    int num2 = arr2[k][j];
                    answer[i][j] += num1 * num2;
                }
            }
        }
        return answer;
    }
}
