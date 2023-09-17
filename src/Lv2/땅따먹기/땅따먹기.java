package Lv2.땅따먹기;

public class 땅따먹기 {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][land[0].length];
        for(int i = 0; i < land[0].length; i++) {
            dp[0][i] = land[0][i];
        }
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                for (int k = 0; k < land[0].length; k++) {
                    if (j == k)
                        continue;
                    dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i-1][k]);
                }
            }
        }
        for (int i= 0 ; i < dp[0].length ;i++){
            answer = Math.max(answer, dp[dp.length -1][i]);
        }
        return answer;
    }
}
