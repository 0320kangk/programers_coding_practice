package Lv2.다음_큰_숫자;

public class 다음_큰_숫자 {
    public int solution(int n) {
        int answer = 0;
        String sN = Integer.toBinaryString(n);
        int count = 0;
        for(int i = 0; i < sN.length() ;i++) {
            if (sN.charAt(i) == '1')
                count++;
        }
        for(int i = n + 1; i < 1_000_000; i++){
            String iBinary = Integer.toBinaryString(i);
            int iBCount = 0;
            for (int j= 0 ; j < iBinary.length(); j++){
                if(iBinary.charAt(j) == '1')
                    iBCount++;
            }
            if (iBCount == count){
                answer = i;
                break;
            }
        }
        return answer;
    }
}
