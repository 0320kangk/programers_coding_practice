package Lv2.java.연속된_부분_수열의_합;

import java.util.*;

public class 연속된_부분_수열의_합 {

    public int[] solution(int[] sequence, int k) {
        int left = 0; //시작부분
        int right = 0; // 끝부분
        int partitionSum = sequence[0]; //부분 수열의 합

        int n = sequence.length; // 사이즈

       List<SubSequence> subs = new ArrayList<>();
       while (true) {
           if (partitionSum == k) {
                subs.add(new SubSequence(left, right));
           }
           if (left == n && right == n) break;
           //수열의 합이 k보다 작거나 같고 right가 n보다 작으면 right를 키워 partionSum의 크기를 늘린다.
           if(partitionSum <= k && right < n) {
               right++;
               if(right < n) partitionSum += sequence[right];
           } else { //partionSum의 크기가 크므로 left 크기를 늘린다.
               if (left < n) partitionSum -= sequence[left];
               left++;
           }
       }
       subs.sort(SubSequence::compareTo);//조건을 만족하는 부분 수열중에서 가장 사이즈가 작고 인덱스가 작은 것을 고른다.
        return new int[]{subs.get(0).left, subs.get(0).right};
    }

    private class  SubSequence implements Comparable<SubSequence> {
        int left, right, size;
        public SubSequence(int left, int right) {
            this.left = left;
            this.right = right;
            this.size = right-left;
        }
        @Override
        public int compareTo(SubSequence o) {
            if (this.size == o.size) {
                return this.left - o.left;
            }
            return this.size - o.size;
        }
    }
    //시간초과 코드, 답은 맞음..
        /*public int[] solution(int[] sequence, int k) {

       int[] answer = new int[2];
        for (int i = 0; i < sequence.length; i++) {
            Queue<Integer> q = new LinkedList<Integer>();
            int sum = 0;
            for (int j = 0; j < sequence.length; j++) {
                if(q.size() < i+1) {
                    q.add(sequence[j]);
                    sum +=(sequence[j]);
                } if (q.size() == i + 1) {
                    if ( sum == k) {
                        answer[0] = j + 1 - q.size();
                        answer[1] = j;
                        return answer;
                    } else{
                        sum -= q.poll();
                    }
                }
            }
        }
        return answer;
    }*/
    public static void main(String[] args) {
        연속된_부분_수열의_합 연속된_부분_수열의_합 = new 연속된_부분_수열의_합();
        int[] solution = 연속된_부분_수열의_합.solution(new int[]{1,1,1,2,3,4,5}, 5);
        System.out.println(Arrays.toString(solution));
    }
}
