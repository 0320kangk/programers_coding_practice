package Lv2.유사_칸토어_비트열;


//해결 못한 문제
public class 유사_칸토어_비트열 {
    public int solution(int n, long l, long r) {
        int answer = 0;

        for (long point = l; point <= r; point++) {
            answer += findBit1(n, point - 1);
        }
        return answer;
    }
    int findBit1(int n, long x) {
        if ( x == 0 || n == 0 )
            return 1;
        if ( x % 5 == 2)
            return 0;
        return findBit1(n - 1, x/5);
    }

}
