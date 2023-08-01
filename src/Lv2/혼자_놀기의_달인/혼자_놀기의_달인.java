package Lv2.java.혼자_놀기의_달인;

import java.util.Arrays;
import java.util.Collections;

public class 혼자_놀기의_달인 {
    public int solution(int[] cards) {
        boolean[] used = new boolean[cards.length];
        Integer[] groupSize = Arrays.stream(new int[cards.length]).boxed().toArray(Integer[]::new);
        int groupIndex = 0;

        for (int i = 0; i < used.length; i++) {
            if (used[i] == false) {
                groupSize[groupIndex++] = findGroup(cards, used, i + 1, 0);
            }
        }
        Arrays.sort(groupSize, Collections.reverseOrder());
        int answer = groupSize[0] * groupSize[1];
        return answer;
    }
    int findGroup (int [] cards, boolean[] used, int card, int length) {
        if (used[card - 1] == false) {
           used[card - 1] = true;
           length = findGroup(cards, used, cards[card - 1], length + 1);
        }
        return length;
    }

    public static void main(String[] args) {
        혼자_놀기의_달인 혼자_놀기의_달인 = new 혼자_놀기의_달인();
        int solution = 혼자_놀기의_달인.solution(new int[]{3,2,1,4});
        System.out.println(solution);
    }
}
