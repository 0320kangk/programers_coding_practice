package Lv2.java.두_원_사이의_정수_쌍;

public class 두_원_사이의_정수_쌍 {
    public long solution(int r1, int r2) {
        long answer = 0;
        long r1x = (long) Math.pow(r1,2);
        long r2x = (long ) Math.pow(r2,2);
        int side = 0;
        for (int i = 0; i <= r2; i++) {
            // 원 사이의 정수 쌍
            long pow = (long) Math.pow(i, 2);
            long y1 = (long) Math.sqrt( r1x - pow);
            long y2 = (long) Math.sqrt( r2x - pow);
            answer += (y2 - y1) * 4;
            //작은 원의 선에 정수 쌍이 있을 때
            if ( Math.sqrt(r1x - pow)%1 == 0 ){
                side++;
            }
        }
        answer += side * 4 -4; // x=0 or y=0 일 때의 정수 쌍이 4번 겹치게 된다.
        return answer;
    }
    public static void main(String[] args) {
        두_원_사이의_정수_쌍 두_원_사이의_정수_쌍 = new 두_원_사이의_정수_쌍();
        long solution = 두_원_사이의_정수_쌍.solution(2, 3);
        System.out.println(solution);
        System.out.println(3.1%1);
    }
}
