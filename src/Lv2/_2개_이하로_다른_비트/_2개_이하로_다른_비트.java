package Lv2.java._2개_이하로_다른_비트;

import java.util.Arrays;
public class _2개_이하로_다른_비트 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        //0찾기
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            long zero = 1;
            long one = 0;
            while (num > 0) {
                if (num % 2 == 0)
                    break;
                else {
                    zero *=2;
                    if ( one == 0) one = 1;
                    else one *= 2;
                    num /= 2;
                }
            }
            answer[i] = numbers[i] + zero - one;
        }
        return answer;
    }



    public static void main(String[] args) {
        _2개_이하로_다른_비트 _2개_이하로_다른_비트 = new _2개_이하로_다른_비트();
        long[] solution = _2개_이하로_다른_비트.solution(new long[]{31});
        System.out.println(Arrays.toString(solution));
    }
}
