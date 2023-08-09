# 2 x n 타일링 풀이

### [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12900)

### 문제 풀이
이 문제는 dp를 이용하여 푸는 문제이다. </br>
n = 1인 경우는 타일을 세운 경우 1가지이다. </br>
n = 2인 경우 아래 그림과 같이 2가지인 것을 볼 수 있다. </br>
n = 3인 경우 직사각형은 3가지이다. </br>
n = 2 인 직사각형 모양에 타일을 세워 옆에 붙이면 가로의 길이가 4인 직사각형이 2개가 된다. </br>
n = 1인 경우의 직사각형 모양에 타일을 눕혀 붙이면 n = 3인 직사각형 1개가 만들어진다.. </br>
즉 n = 3인 직사각형 개수는 n-1 과 n-2의 타일모양 개수의 합이 된다.
f(n) = f(n-1) + f(n-2) 가 되는 것 이다.
위 식을 배열을 이용하여 코드로 구현하면 된다.

![img_2.png](img_2.png)

n = 2인 경우 타일

![img.png](img.png)

n = 3 인 경우 타일
### 소스 코드
```java
public class _2xn타일링 {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n + 1]; // 가로 길이 x 에 대한 직사각형 개수 = dp[x] 
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++)
            dp[i] = dp[i - 1] + dp[ i - 2]; // 가로 길이 i의 직사각형 만들기
        return answer;
    }
}
```