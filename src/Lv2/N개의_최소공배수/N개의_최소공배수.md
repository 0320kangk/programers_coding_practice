# 최소공배수 찾기 풀이
프로그래머스 스킬체크 문제로 링크가 제공되지 않는다.

### 문제 풀이
이 문제는 주어진 수에 대한 최소 공배수를 구하는 문제이다.
최소 공배수를 구하는 공식을 이용하여 최소 공배수를 찾는다. 
자연수 a, b가 있다면 최소 공배수는 a,b의 최대 공약수 * (a / 최대 공약수) * (b / 최대 공약수) 가 된다.
최대 공약수가 1이라면 최소 공배수는 a * b가 된다.
```java
public class 최소공배수_찾기 {
    public int solution(int[] arr) {
        int answer = 0;
        int initValue = arr[0]; // 초기값
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];//i 번째 값
            int max = Math.max(initValue, num); // 더 큰수 찾기
            boolean flag = false;// 공배수 여부
            int multiple = 1; // 공약수
            int j = 2; 
            while (j <= max) {
                // 공약수 구하기
                if ( initValue % j == 0 && num % j == 0){
                    multiple *= j; // 공약수
                    initValue /= j; 
                    num /= j;
                    flag = true;
                    j = 2;
                    continue;
                }
                j++;
            }
            //최대 공약수가 1이 아닐 때
            if (flag)
                initValue = multiple * num * initValue;
            //최대 공약수가 1일 때
            if (!flag)
                initValue *= num;
        }
        answer = initValue;
        return answer;
    }
    
}

```