package Lv2.멀리_뛰기;

public class 멀리_뛰기 {
    public long solution(int n) {
        long answer = 0;
        int[] arr =new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;
        for(int i = 2; i < n ;i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
        }
        answer = arr[n];
        return answer;
    }
}
