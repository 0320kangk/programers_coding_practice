package skillCheck;

public class 문제1 {
    public int solution(int n) {
        int answer = 0;
        long[] dp = new long[n + 1];
        dp[2] = 3;
        for (int i = 4; i < dp.length ; i+=2) {
            dp[i] = (dp[i - 2] ) * 3 + 2;
            for (int j = i - 2; j > 0 ; j-=2) {
                dp[i] += (dp[j - 2] * 2);
                dp[i] %= 1000000007;
            }
        }
        answer = (int)dp[n];
        return answer;
    }
    //f(2) = f(n-2) * 3 + 2 f(n-4)*2+f....
    public static void main(String[] args) {
        문제1 문제1 = new 문제1();
        int solution = 문제1.solution(5000);
        System.out.println(solution);
    }
}
