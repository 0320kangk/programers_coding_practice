package Lv2.java.숫자의_표현;

public class 숫자의_표현 {
    public int solution(int n) {
        int answer = 1;
        for (int i = 1; i <= Math.floor(n/2.0) ; i++) {
            int x = i;
            int temp = x;
            while (true) {
                x += temp;
                temp++;
                if ( x== n)
                    answer++;
                else if ( x > n)
                    break;
            }
        }
        return answer;
    }
}
