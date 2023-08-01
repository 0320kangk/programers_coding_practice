package Lv2.java.k진수에서_소수_개수_구하기;



public class k진수에서_소수_개수_구하기 {
    public int solution(int n, int k) {
        int answer = 0;
        String[] split = Integer.toString(n, k).split("0");

        for (String s : split) {
            if (s.length() > 0) {
                answer += findPrime(s);
            }
        }
        return answer;
    }

    private int findPrime( String s) {
        long num = Long.valueOf(s);
        long sqrt = (long) Math.sqrt(num);
        if ( num == 1) return 0;
        for (long j = 2; j <= sqrt; j++) {
            if ( num % j == 0) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        k진수에서_소수_개수_구하기 k진수에서_소수_개수_구하기 = new k진수에서_소수_개수_구하기();
        int solution = k진수에서_소수_개수_구하기.solution(437674, 3);
        System.out.println(solution);
    }
}
