package Lv2.혼자서_하는_틱택토;

import java.util.Stack;

public class 혼자서_하는_틱택톡 {
    public int solution(String[] board) {
        int oCount = 0;
        int xCount = 0;
        for (String s : board) {
            for (int i = 0; i < s.length(); i++) {
                if ( s.charAt(i)=='O') {
                    oCount++;
                }
                else if ( s.charAt(i)=='X') {
                    xCount++;
                }
            }
        }
        //o와 x보다 1개 많거나 같지 않다면 불가능한 경우이므로 return 0
        //기본적인 o x 개수 조건
        if ( oCount - xCount > 1 || oCount - xCount < 0  ) {
            return 0;
        }
        boolean oBingo = isEnd(board, 'O');
        boolean xBingo = isEnd(board, 'X');
        //o가 한줄로 만들어져 있을 때 x의 개수가 제대로 있는가?

        if (oBingo) {
            if (oCount-xCount == 1 && !xBingo) {
                return 1;
            } else {
                return 0;
            }
        }

        if (xBingo){
            if (oCount-xCount == 0 ) {
                return 1;
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    //sign 문자 3개 유무 확인
    boolean isEnd(String[] board, char sign) {
        //가로 체크
        for (int i = 0; i < 3; i++) {
            boolean flag = true;
            for (int j = 0; j < 3; j++) {
                if(board[i].charAt(j) != sign ){
                    flag = false;
                }
            }
            if (flag) {
                return true;
            }
        }
        //세로 체크
        for (int i = 0; i < 3; i++) {
            boolean flag = true;
            for (int j = 0; j < 3; j++) {
                if(board[j].charAt(i) != sign ){
                    flag = false;
                }
            }
            if (flag) {
                return true;
            }
        }
        //대각선 체크
        if(board[0].charAt(0) == sign &&
        board[1].charAt(1) == sign &&
        board[2].charAt(2) == sign) {
            return true;
        }
        if (board[0].charAt(2)==sign &&
        board[1].charAt(1) == sign &&
        board[2].charAt(0) == sign) {
            return true;
        }
        return false;
    }


}
