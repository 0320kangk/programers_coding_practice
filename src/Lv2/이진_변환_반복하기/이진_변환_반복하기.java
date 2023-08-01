package Lv2.java.이진_변환_반복하기;

public class 이진_변환_반복하기 {
    public int[] solution(String s) {
        int transCount = 0;
        int zeroCount = 0;
        while (!s.equals("1")){
            String replaceS = s.replaceAll("0", "");
            zeroCount = s.length() - replaceS.length();
            s = Integer.toBinaryString(replaceS.length());
            transCount++;
        }
        int [] answer = {transCount, zeroCount};
        return answer;
    }
}
