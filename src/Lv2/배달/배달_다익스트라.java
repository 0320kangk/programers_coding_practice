package Lv2.배달;

import java.util.*;

public class 배달_다익스트라 {
    public int solution(int N, int[][] road, int K) {

        /*
        1. Node 만들기 (목표지점, 비용)
        2. 시작지점 정하기
        3. 우선순위 큐 만들기(cost)중심
        4. 큐에 시작점 넣기
        5. 큐의 점과 인접한 노드중에서 cost가 작은 것 큐에
         */
        int start = 1;
        List<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < road.length; i++) {
            graph.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
            graph.get(road[i][1]).add(new Node(road[i][0], road[i][2]));

        }
        int[] dist = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> (o1.cost - o2.cost));
        pq.add(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            //curNode 도착 비용보다 현재 노드의 총 도착거리가 더 작다면 넘어간다.
            if (dist[curNode.idx] < curNode.cost)
                continue;
            //인접한 노드 찾기
            for (int i = 0; i < graph.get(curNode.idx).size(); i++) {
                Node nextNode = graph.get(curNode.idx).get(i);
                if ( dist[nextNode.idx] > curNode.cost + nextNode.cost ){
                    dist[nextNode.idx] = curNode.cost + nextNode.cost;
                    pq.add(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }
        int answer = 0;
        System.out.println(Arrays.toString(dist));
        for (int i = 1; i < dist.length; i ++) {
            if ( i <= K ) answer++;
        }
        return answer;
    }

    class Node {
        int idx;
        int cost;
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        배달_다익스트라 배달 = new 배달_다익스트라();
        int solution = 배달.solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3);
        System.out.println(solution);
    }
}
