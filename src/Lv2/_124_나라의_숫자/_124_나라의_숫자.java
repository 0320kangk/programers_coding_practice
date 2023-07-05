package Lv2.나라124의_숫자;

public class 나라124의_숫자 {
    public String solution(int n) {
        //14 = 20, 1 2 4 // 0 1  2
        String[] numbers = {"4", "1", "2"};
        String answer = "";

        while ( n > 0) {
            int remainder = n % 3;
            n /= 3;
            if(remainder == 0) n--;
            answer = numbers[remainder] + answer;
        }
        return answer;
    }
}
