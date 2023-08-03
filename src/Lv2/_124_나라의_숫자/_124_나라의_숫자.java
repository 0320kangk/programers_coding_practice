package Lv2._124_나라의_숫자;

public class _124_나라의_숫자 {
    public String solution(int n) {
        //14 = 20, 1 2 4 // 0 1  2
        String[] numbers = {"4", "1", "2"};
        String answer = "";
        StringBuilder sb = new StringBuilder();
        while ( n > 0) {
            int remainder = n % 3;
            n /= 3;
            if(remainder == 0) n--;
            sb.append(numbers[remainder]);
        }
        sb.reverse();
        answer = sb.toString();
        return answer;
    }
}
