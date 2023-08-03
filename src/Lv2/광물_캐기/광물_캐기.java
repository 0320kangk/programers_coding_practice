package Lv2.광물_캐기;
import java.util.Arrays;
public class 광물_캐기 {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int unit = (int)Math.ceil(minerals.length / 5.0);
        int sum = Arrays.stream(picks).sum();
        int work = minerals.length;
        if ( minerals.length > sum * 5) {
            unit = sum;
            work = sum * 5;
        }
        int[] diaGrain = new int[(int) Math.ceil(unit)];
        int[] ironGrain = new int[(int) Math.ceil(unit)];
        stone[] stoneGrain = new stone[(int) Math.ceil(unit)];

        for (int i = 0; i < unit ; i++) {
            stoneGrain[i] = new stone(i);
        }
        for (int i = 0; i < work; i++) {
            diaGrain[i/5] += 1;
            if (minerals[i].equals("diamond")) {
                ironGrain[i/5] += 5;
                stoneGrain[i/5].fatigue += 25;
            }
             else if (minerals[i].equals("iron")) {
                ironGrain[i/5] += 1;
                stoneGrain[i/5].fatigue += 5;
            } else {
                ironGrain[i/5] += 1;
                stoneGrain[i/5].fatigue += 1;
            }
        }
        Arrays.sort(stoneGrain,(s1,s2) -> (s2.fatigue-s1.fatigue));
        int x = 0;
        int i = 0;
        for (int pick : picks) {
            while( pick > 0 && i < unit) {
                if (x == 0) {
                    answer += diaGrain[stoneGrain[i++].index];
                } else if (x == 1) {
                    answer += ironGrain[stoneGrain[i++].index];
                } else if ( x==2) {
                    answer += stoneGrain[i++].fatigue;
                }
                pick--;
            }
            x++;
        }
        return answer;
    }
    class stone {
        int index;
        int fatigue;
        public stone(int index) {
            this.index = index;
        }
    }
    public static void main(String[] args) {
        광물_캐기 광물_캐기 = new 광물_캐기();
        int solution = 광물_캐기.solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"});
        System.out.println(solution);
    }
}
