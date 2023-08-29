package Lv2.배달;

import java.util.*;

public class 배달 {

    boolean[] visited;
    Set<Integer> set;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        set = new HashSet<Integer>();
        this.visited = new boolean[N + 1];
        List<List<Integer[]>> loadList = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
           loadList.add(new ArrayList<>());
        }
        for (int i = 0; i < road.length; i++) {
            loadList.get(road[i][0]).add(new Integer[]{road[i][1], road[i][2]});
            loadList.get(road[i][1]).add(new Integer[]{road[i][0], road[i][2]});
        }
        dfs(1, K, loadList);
        answer = set.size();
        return answer;
    }
    void dfs(int point, int length, List<List<Integer[]>> loadList){
        if ( length < 0 ) {
            return;
        } else  {
            set.add(point);
        }
        for (int i = 0; i < loadList.get(point).size(); i++) {
            Integer[] load = loadList.get(point).get(i);
            if(!visited[load[0]] ){
                visited[load[0]] = true;
                dfs(load[0], length - load[1], loadList);
                visited[load[0]] = false;
            }
        }
    }
    public static void main(String[] args) {
        배달 배달 = new 배달();
        int solution = 배달.solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3);
        System.out.println(solution);
    }

}
