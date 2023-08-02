package Lv2.java.마법의_엘리베이터;

public class 마법의_엘리베이터2 {

    public int solution(int storey) {

        if (storey == 0)
            return 0;

        if (storey % 10 == 0) {
            return solution(storey / 10);
        }

        if (storey < 10) {
            return Math.min(storey, 11 - storey);
        }

        int mod = storey % 10;

        int up = 10 - mod + solution(storey + 10 - mod);
        int down = mod + solution( storey - mod);

        return Math.min(up, down);
    }

}
