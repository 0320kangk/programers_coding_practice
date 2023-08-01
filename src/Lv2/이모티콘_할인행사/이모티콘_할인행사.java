package Lv2.java.이모티콘_할인행사;

import java.util.*;

public class 이모티콘_할인행사 {
    final int[] salesRatio = {40, 30, 20, 10};
    int maxEmoticons = 0;
    int maxExpense = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        bfs(users, emoticons, new int[emoticons.length], 0);
        int[] answer = new int[2];
        answer[0] = maxEmoticons;
        answer[1] = maxExpense;
        return answer;
    }
    void bfs (int[][] users, int[] emoticons, int[] rates, int bfsCount ) {
        if( bfsCount == emoticons.length) {
           updateMembership(users, emoticons, rates);
           return;
        }
        for (int ratio : salesRatio) {
            rates[bfsCount] = ratio;
            bfs(users, emoticons, rates, bfsCount + 1);
        }
    }
    void updateMembership(int[][] users, int[] emoticons, int[] rates) {
        int emoticonSigns = 0;
        int totalExpense =0 ;
        for (int i = 0; i < users.length; i++) {
            int expense = 0;
            for (int j = 0; j < emoticons.length; j++) {
                if ( users[i][0] <= rates[j] ) {
                    expense += emoticons[j] * ( 100 - rates[j]) / 100;
                }
                if (expense >= users[i][1]) {
                    emoticonSigns++;
                    expense = 0;
                    break;
                }
            }
            totalExpense += expense;
        }
        if ( emoticonSigns > maxEmoticons) {
            maxEmoticons = emoticonSigns;
            maxExpense = totalExpense;
        } else if (emoticonSigns == maxEmoticons) {
            maxExpense = maxExpense > totalExpense ? maxExpense : totalExpense;
        }
    }
    public static void main(String[] args) {
        이모티콘_할인행사 이모티콘_할인행사 = new 이모티콘_할인행사();
        int[] solution = 이모티콘_할인행사.solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000});
        System.out.println(Arrays.toString(solution));
    }
}
