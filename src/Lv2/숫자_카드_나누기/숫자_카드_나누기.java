package Lv2.숫자_카드_나누기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 숫자_카드_나누기 {

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int a = arrayA[0];
        int b = arrayB[0];
        List<Integer> aList = new ArrayList<>();
        aList.add(a);
        int aSqrt = (int) Math.sqrt(a);
        for (int i = 2; i <= aSqrt; i++) {
            if (a % i == 0) {
                aList.add(i);
                aList.add(a/i);
            }
        }
        int bSqrt = (int) Math.sqrt(b);
        List<Integer> bList = new ArrayList<>();
        bList.add(b);
        for (int i = 2; i <= bSqrt; i++) {
            if (b % i == 0) {
                bList.add(b/i);
                bList.add(i);
            }
        }
        answer = getAnswer(arrayA, arrayB, answer, aList);
        answer = getAnswer(arrayB, arrayA, answer, bList);

        return answer;
    }

    private static int getAnswer(int[] ownArray, int[] restArray, int answer, List<Integer> divisorList) {
        for (Integer dNum : divisorList) {
            boolean flag = false;
            for (int numA : ownArray) {
                if (numA % dNum != 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                for (int numB : restArray) {
                    if (numB % dNum == 0) {
                        flag = true;
                        break;
                    }
                }
                if (!flag && answer < dNum) {
                    answer = dNum;
                }
            }

        }
        return answer;
    }
    public static void main(String[] args) {
        숫자_카드_나누기 숫자_카드_나누기 = new 숫자_카드_나누기();
        int solution = 숫자_카드_나누기.solution(new int[]{10, 17}, new int[]{5, 20});
        System.out.println(solution);
    }
}
