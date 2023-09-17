package Lv2.점프와_순간_이동;

public class 점프와_순간_이동 {
    public int solution(int n) {
        int ans = 0;

        while ( n == 0 ) {
            ans += n % 2;
            n /= 2;
        }
        return ans;
    }
}
