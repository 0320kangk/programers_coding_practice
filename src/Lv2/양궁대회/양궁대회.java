package Lv2.java.양궁대회;

import java.util.Arrays;

public class 양궁대회 {
    public int[] solution(int n, int[] info) {

        Score score = new Score(0, new int[info.length]);
        Score result = new Score(0, new int[info.length]);
        dfs(n, info, score, result);
        int diffScore = getDiffScore(info, result);
        int[] answer = diffScore > 0 ? result.process : new int[] {-1};
        return answer;
    }

    private int getDiffScore(int[] info, Score result) {
        int diffScore = 0;
        for (int i = 0; i < info.length; i++) {
            if (result.process[i] > info[i] )
                diffScore += 10 - i;
            else if (info[i] > 0)
                diffScore -= 10 - i;
        }
        return diffScore;
    }

    void dfs(int n, int[] info, Score score, Score result) {
        if ( n == 0) {
            //기존 족보와 이전 족보를 비교할 수 있어야 한다.
            if ( score.sum > result.sum) {
                copy(score, result);
            }
            else if ( score.sum == result.sum) {
                for (int i = info.length -1; i >= 0; i--) {
                    if ( result.process[i] != score.process[i]) {
                        if ( result.process[i] < score.process[i]) {
                            copy(score, result);
                        }
                        break;
                    }
                }
            }
            return;
        }
        for (int i = 0; i < info.length; i++) {
            if ( score.process[i] == 0 && n > 0 && n > info[i] ) {
                int add = 0;
                if ( info[i] >= 1 )
                    add = (10 - i) * 2;
                else
                    add = 10 - i;
                score.process[i] = info[i] + 1;
                score.sum += add;
                dfs(n - (info[i] + 1), info,  score, result);
                score.process[i] = 0;
                score.sum -= add;

            } else if ( i == 10 && n > 0) {
                score.process[i] = n;
                dfs(0, info, score, result);
                score.process[i] = 0;
            }
        }
    }
    private void copy(Score score, Score result) {
        result.sum = score.sum;
        result.process = score.process.clone();
    }

    class Score {
        int sum;
        int[] process ;
        public Score(int sum, int[] process) {
            this.sum = sum;
            this.process = process;
        }
    }
    public static void main(String[] args) {
        양궁대회 양궁대회 = new 양궁대회();
        int[] solution = 양궁대회.solution(10, new int[]{0,0,0,0,0,0,0,0,3,4,3});
        System.out.println(Arrays.toString(solution));
    }

}
