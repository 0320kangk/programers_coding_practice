package Lv2.java._3xn타일링;

public class _3xn타일링 {
    public int solution(int n) {
        int answer = 0;
        long[] dp = new long[n + 1];
        dp[2] = 3;
        long preDp = 0;
        for (int i = 4; i < dp.length ; i+=2) {
            dp[i] = ((dp[i - 2] ) * 3 + 2 + preDp) % 1000000007;
            preDp += dp[i - 2] * 2;
        }
        answer = (int)dp[n];
        return answer;
    }
    //f(2) = f(n-2) * 3 + 2 f(n-4)*2+f....
    public static void main(String[] args) {
        _3xn타일링 문제1 = new _3xn타일링();
        int solution = 문제1.solution(5000);
        System.out.println(solution);
    }
}
