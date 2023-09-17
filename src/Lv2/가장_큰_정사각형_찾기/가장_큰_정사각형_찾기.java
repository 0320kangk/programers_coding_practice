package Lv2.가장_큰_정사각형_찾기;

public class 가장_큰_정사각형_찾기 {
    public int solution(int [][]board)
    {
        int answer = 0;  //dp 풀이
        if (board.length < 2 || board.length < 2)
            return 1;
        for(int i=1; i < board.length ;i++) {
            for(int j=1; j < board[0].length; j++) {
                if (board[i][j] != 0) {
                    board[i][j] += Math.min(board[i-1][j-1],Math.min(board[i-1][j],board[i][j-1]));
                    answer = Math.max(board[i][j], answer);
                }

            }
        }
        return answer * answer;
    }
}

