package Lv2.뒤에_있는_큰_수_찾기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class 뒤에_있는_큰_수_찾기 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        //{2,3,3,5}
        Stack<Integer> nums = new Stack<>();
        nums.add(0);
        for (int i = 1; i < numbers.length; i++) {
            while ( !nums.isEmpty() && numbers[nums.peek()] < numbers[i] ) {
                int index = nums.pop();
                answer[index] = numbers[i];
            }
            nums.add(i);
        }
        for (int index : nums) {
            answer[index] = -1;
        }
        return answer;
    }
}
