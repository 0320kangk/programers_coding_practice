package Lv2.배달;

import java.util.Arrays;
import java.util.Comparator;

public class 배달_크루스칼 {

    int findParent(int[][] parents, int town) {
        if (parents[town][0] != town)
            return findParent(parents, parents[town][0]);
        else
            return town;
    }
    public void union(int[][] parent, int town1, int town2, int cost) {
        int parent1 = findParent(parent, town1);
        int parent2 = findParent(parent, town2);
        System.out.println(parent1 + ":" + parent[parent1][1]);
        System.out.println(parent2 + ":" + parent[parent2][1]);
        System.out.println();
        if ( parent1 < parent2){
            parent[parent2][0] = parent1;
            parent[parent2][1] = cost;
        } else{
            parent[parent1][0] = parent2;
            parent[parent1][1] =  cost;
        }
    }
    public int solution(int N, int[][] road, int K) {

        int[][] towns = new int[N + 1][2];
        for (int i = 0; i < N + 1; i++) {
            towns[i][0] = i;
        }
        Arrays.sort(road, Comparator.comparing( r -> r[2]));
        for (int i = 0; i < road.length; i++) {
            if (findParent(towns, road[i][0]) != findParent(towns, road[i][1])){
                System.out.println(road[i][0] + ":" + road[i][1]);
                union(towns, road[i][0], road[i][1], road[i][2]);
            }
        }
        for (int[] town : towns) {
            System.out.println( Arrays.toString(town));
        }
        return 1;
    }
    public static void main(String[] args) {
        배달_크루스칼 배달 = new 배달_크루스칼();
        int solution = 배달.solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3);
        System.out.println(solution);
    }
}
