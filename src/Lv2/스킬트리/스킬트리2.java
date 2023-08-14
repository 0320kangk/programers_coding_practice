package Lv2.스킬트리;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class 스킬트리2 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        Iterator<String> it = skillTrees.iterator();
        while (it.hasNext()) {
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        return answer;
    }
    public static void main(String[] args) {
        스킬트리2 스킬트리2 = new 스킬트리2();
        int cbd = 스킬트리2.solution("CBDK", new String[]{"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"});
        System.out.println(cbd);
    }
}
