package Lv2.후보키;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class 후보키 {
    List<Set<Character>> candidateKeys;
    String[][] relation;
    public int solution(String[][] relation) {
        int answer = 0;
        candidateKeys = new ArrayList<>();
        this.relation = relation;
        String col = "";
        for (int i = 0; i < relation[0].length; i++) {
            col += i;
        }
        System.out.println(col);

        for (int i = 1; i <= col.length(); i++) {
            combination(col, new HashSet<>(), i);
        }
        return answer = candidateKeys.size();
    }
    //set에 들어갈 값은 0~n-1 까지의 열 번호, 이 열 번호가 unique 한지 확인
    void combination(String col, Set<Character> key, int size) {
        if  (size == 0 && isUnique(key) && isMinimal(key)) {
            candidateKeys.add(key);
            return;
        }
        //0, 1, 2, 3

        for (int i = 0; i < col.length(); i++) {
            HashSet<Character> newKey = new HashSet<>(key);
            newKey.add(col.charAt(i));
            combination(col.substring(i + 1), newKey, size - 1);
        }
    }
    //유니크인지 확인
    boolean isUnique(Set<Character> keySet) {
        //keySet = 0123(열번호)
        Set<String> dataSet = new HashSet<>();
        for (int i = 0; i < relation.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (Character c : keySet) {
                sb.append(relation[i][c-'0']);
            }
            if (!dataSet.add(sb.toString())) return false;
        }
        return true;
    }

    //최소성인지 확인
    boolean isMinimal(Set<Character> key) {
        for (Set<Character> candidateKey : candidateKeys) {
            if(key.containsAll(candidateKey)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        후보키 후보키 = new 후보키();
        int solution = 후보키.solution(new String[][]{{"100"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}});
    }
}
