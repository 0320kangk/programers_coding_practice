package Lv2.히노이의_탑;

import java.util.ArrayList;
import java.util.List;

public class 히노이의_탑 {
    List<Integer[]> list;
    public int[][] solution(int n) {
        List<Integer[]> list = new ArrayList<>();
        this.list = list;
        moveHanoi(n, 1, 2, 3);
        int[][] answer = new int[list.size()][2];
        for(int i = 0 ; i < list.size(); i++) {
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        return answer;
    }
    void moveHanoi(int n,int start, int temp, int dest) {
        if ( n == 1)
            list.add(new Integer[]{start, dest});
        else{
            moveHanoi(n-1, start, dest, temp);
            list.add(new Integer[]{start, dest});
            moveHanoi(n-1, temp, start, dest);
        }
    }
}
