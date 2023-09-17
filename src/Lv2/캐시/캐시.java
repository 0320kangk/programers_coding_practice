package Lv2.캐시;

import javax.swing.text.DefaultEditorKit;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayDeque<String> deque = new ArrayDeque<String>();
        int runTime = 0;
        if (cacheSize == 0)
            return cities.length * 5;
        for (int i = 0; i < cities.length; i++) {
            String lowerCity = cities[i].toLowerCase();
            System.out.println(runTime);
            if (deque.contains(lowerCity)) {
                deque.remove(lowerCity);
                deque.addFirst(lowerCity);
                runTime += 1;
            } else {
                runTime += 5;
                deque.addFirst(lowerCity);
                if ( deque.size() -1 == cacheSize )
                    deque.removeLast();
            }
        }
        answer = runTime;
        return answer;
    }
    public static void main(String[] args) {
        캐시 캐시 = new 캐시();
        int solution = 캐시.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" });
        System.out.println(solution);
    }
}
