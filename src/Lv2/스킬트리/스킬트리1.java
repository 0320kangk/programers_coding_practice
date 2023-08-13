package Lv2.스킬트리;

import java.util.ArrayList;
public class 스킬트리1 {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        for (String skillTree : skill_trees) {
            int skillPoint = 0;
            for (int i = 0; i < skillTree.length(); i++) {
                int skillIndex = skill.indexOf(skillTree.charAt(i));
                if (skillIndex == -1)
                    continue;
                else if (skillIndex == skillPoint)
                    skillPoint++;
                else {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        스킬트리1 스킬트리1 = new 스킬트리1();
        int cbd = 스킬트리1.solution("CBDK", new String[]{"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"});
        System.out.println(cbd);
    }
}
