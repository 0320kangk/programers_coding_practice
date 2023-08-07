package Lv2.점_찍기;

public class 점_찍기 {
    public long solution(int k, int d) {
        long answer = 0;
        for (int x = 0; x <= d; x = x + k) {
            long y = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
            answer += y/k + 1;
        }
        return answer;
    }
    public static void main(String[] args) {
        점_찍기 점_찍기 = new 점_찍기();
        long solution = 점_찍기.solution(2, 4);
    }
}
