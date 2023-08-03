package Lv2._2xn타일링;

public class _2xn타일링 {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++)
            dp[i] = dp[i - 1] + dp[ i - 2];
        return answer;
    }
}
