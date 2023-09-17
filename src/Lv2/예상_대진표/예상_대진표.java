package Lv2.예상_대진표;

public class 예상_대진표 {

    public int solution(int n, int a, int b)
    {
        int answer = 0;
        //n 참가자 수, a ,b 경쟁자 번호
        while ( Math.abs(a-b) != 1 || Math.max(a, b) % 2 != 0) {
            a = (int) Math.ceil(a/2.0);
            b=  (int) Math.ceil(b/2.0);
            answer++;
        }
        return ++answer; //1,2 3,4 5,6 7,8 9, 10
    }

    public static void main(String[] args) {
        예상_대진표 예상_대진표 = new 예상_대진표();
        int solution = 예상_대진표.solution(4, 2, 3);
        System.out.println(solution);
    }

}
