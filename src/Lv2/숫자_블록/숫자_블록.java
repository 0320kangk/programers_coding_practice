package Lv2.숫자_블록;

public class 숫자_블록 {
    public int[] solution(long begin, long end) {
        int[] answer = new int[ (int)(end - begin) + 1];
        for(long i = begin; i <= end;i++){
            long maxBlock = 1;
            for(long j = 2; j <= Math.sqrt(i) ;j++) {
                if( i % j == 0){
                    maxBlock = j;
                    if ( i / j <= 10_000_000){
                        maxBlock = i / j;
                        break;
                    }
                }
            }
            answer[(int)i - (int)begin] = (int)maxBlock;
        }
        if (begin == 1)
            answer[0] = 0;
        return answer;
    }
}
