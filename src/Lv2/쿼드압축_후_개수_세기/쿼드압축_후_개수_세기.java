package Lv2.쿼드압축_후_개수_세기;

public class 쿼드압축_후_개수_세기 {
    int one = 0, zero = 0;
    public int[] solution(int[][] arr) {
        int[] answer = {zero, one};
        divide(arr, 0, arr.length, 0, arr.length);
        return answer;
    }

    void divide(int[][] arr, int xStart, int xEnd, int yStart, int yEnd) {
        int oneCount = 0;
        int max = (int)Math.pow(xEnd - xStart, 2);
        for (int i = xStart; i < xEnd; i++) {
            for (int j = yStart; j < yEnd; j++) {
                oneCount += arr[i][j];
            }
        }
        if (oneCount == 0) zero++;
        else if (oneCount == max) one++;
        else {
            int xMid = (xStart + xEnd) / 2;
            int yMid = (yStart + yEnd) / 2;
            divide(arr, xStart, xMid, yStart, yMid); //1
            divide(arr, xStart, xMid, yMid, yEnd); //2
            divide(arr, xMid, xEnd, yStart, yMid);
            divide(arr, xMid, xEnd, yMid, yEnd);
        }
    }

    public static void main(String[] args) {
        쿼드압축_후_개수_세기 쿼드압축_후_개수_세기 = new 쿼드압축_후_개수_세기();
        쿼드압축_후_개수_세기.solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}});
    }
}
