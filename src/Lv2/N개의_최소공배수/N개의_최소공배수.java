package skillCheck.Lv2;

public class 최소공배수_찾기 {
    public int solution(int[] arr) {
        int answer = 0;
        int initValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            int max = Math.max(initValue, num);
            boolean flag = false;
            int multiple = 1;
            int j = 2;
            while (j <= max) {
                if ( initValue % j == 0 && num % j == 0){
                    multiple *= j;
                    initValue /= j;
                    num /= j;
                    flag = true;
                    j = 2;
                    continue;
                }
                j++;
            }
            if (flag)
                initValue = multiple * num * initValue;
            if (!flag)
                initValue *= num;
        }
        answer = initValue;
        return answer;
    }

    public static void main(String[] args) {
        최소공배수_찾기 문제1 = new 최소공배수_찾기();
        int solution = 문제1.solution(new int[]{1,100,3,4 });
        System.out.println(solution);
    }
}
