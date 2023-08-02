# k진수에서 소수 개수 구하기

### [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/92335)

### 문제 풀이
이 문제는 양의 정수 n을 k 진수로 바꿨을 때 조건에 맞는 소수를 찾는 문제이다.
k 진수로 바꾼 수를 0을 경계로 숫자를 구분하여 소수인지 찾는 문제이다.

### 소스 코드
```java
public class k진수에서_소수_개수_구하기 {
    public int solution(int n, int k) {
        int answer = 0;
        String[] split = Integer.toString(n, k).split("0"); //k진수로 바꾼 후 0을 경계로 구분하기
        //각 구분한 수를 반복문 돌리기
        for (String s : split) {
            //길이가 0보다 커야 숫자가 있는 경우
            if (s.length() > 0) {
                answer += findPrime(s);// 소수를 찾는다.
            }
        }
        return answer;
    }

    private int findPrime( String s) {
        long num = Long.valueOf(s); 
        long sqrt = (long) Math.sqrt(num);
        if ( num == 1) return 0; //1은 소수가 아니므로 0 반환
        for (long j = 2; j <= sqrt; j++) {
            //나머지가 존재한다면 0 반환
            if ( num % j == 0) {
                return 0; 
            }
        }
        //소수이므로 1 반환
        return 1;
    }
}

```