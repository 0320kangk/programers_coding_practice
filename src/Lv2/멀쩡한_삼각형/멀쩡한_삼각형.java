package Lv2.멀쩡한_삼각형;

public class 멀쩡한_삼각형 {
    public long solution(int w, int h) {
        long count = 0;
        for (int x = 1; x < w; x++) {
            double y = 1.0 * x * h / w; //소수점 나눗셈이 정확하지 않으므로 h / w 를 마지막에 한다.
            count += Math.floor(y) * 2;
        }
        long answer = count;
        return answer;
    }

    public static void main(String[] args) {
        멀쩡한_삼각형 멀쩡한_삼각형 = new 멀쩡한_삼각형();
        long solution = 멀쩡한_삼각형.solution(1, 1);
    }
}
