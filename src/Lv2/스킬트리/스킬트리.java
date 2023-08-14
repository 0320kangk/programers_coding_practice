package Lv2.스킬트리;

import java.util.ArrayList;
import java.util.Arrays;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        for (String skillTree : skill_trees) {
            int[] skills = new int[skill.length()];
            for (int i = 0; i < skill.length(); i++) {
                for (int j = 0; j < skillTree.length(); j++) {
                    if(skillTree.charAt(j) == skill.charAt(i))
                        skills[i] = j + 1;
                }
            }
            for (int i = 0; i < skills.length - 1; i++) {
                if (skills[i + 1] < skills[i] && skills[i + 1] != 0){
                    answer--;
                    break;
                }
                else if (skills[i] == 0){
                    for (int j = i + 1; j < skill.length(); j++) {
                        if (skills[j] != 0){
                            answer--;
                            i = skills.length;
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        스킬트리 스킬트리 = new 스킬트리();
        int cbd = 스킬트리.solution("CBDK", new String[]{"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"});
        System.out.println(cbd);
    }
}
