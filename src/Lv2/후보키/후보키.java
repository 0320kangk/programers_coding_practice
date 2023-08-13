package Lv2.후보키;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 후보키 {
    public int solution(String[][] relation) {
        int answer = 0;
        /*
        속성이 1개일 때 유일하면 후보키
        속성이 2개일 때 유일하면 후보키..
        단 속성이 1개일 때의 후보키를 포함하면 안 된다.
        속성이 3개일 ㄸ
        4= 1+3, 2+2
        유일한 값인지 확인하는 코드는 필수
         */
        int col = relation[0].length;
        int row = relation.length;
        List<Set> setList = new ArrayList<>();
        //유일성 검사
        unique(relation, col, setList, row);


        return answer;
    }

     */
     boolean unique(String[][] relation, int start, List<Set> setList, int row) {
        for (int j = 1; j < col; j++) {
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < row; i++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < j; k++) {
                    sb.append(relation[i][k]);
                }
                if (!set.add(sb.toString())){
                    return false;
                }
            }
        }
        setList.add(set);
        return true;
    }
}
