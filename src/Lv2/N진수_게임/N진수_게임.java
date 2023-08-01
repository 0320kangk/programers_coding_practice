package Lv2.java.N진수_게임;

public class N진수_게임 {
    public String solution(int n, int t, int m, int p) {
        //N진수 게임
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (sb.length() < t * m) {
            String num = Integer.toString(i++, n);
            sb.append(num);
        }
        String num = sb.toString().toUpperCase();
        sb = new StringBuilder();
        for (int j = p -1 ; j <  t * m; j+=m) {
            sb.append(num.charAt(j));
        }
        answer = sb.toString();
        return answer;
    }
}
