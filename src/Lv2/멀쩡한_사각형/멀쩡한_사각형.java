package Lv2.멀쩡한_사각형;

public class 멀쩡한_사각형 {

    public long solution(int w, int h) {
        long answer = 1;

        long count = w + h - 2 + 1; //0,4 3,0
        for (int x = 1; x < w; x++) {
            double y = ( 1- (x / (double) w)) * h; //
            System.out.println(y);
            if ( y == (int) y ) {
                count--;
            }
        }
        answer = w * h - count;
        return answer;
    }

    public static void main(String[] args) {
        멀쩡한_사각형 멀쩡한_사각형 = new 멀쩡한_사각형();
        long solution = 멀쩡한_사각형.solution(3, 4);
        System.out.println(solution);
    }
}
