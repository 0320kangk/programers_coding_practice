# N진수 게임 

### [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/17687)

### 문제 풀이
이 문제는 t * m (미리 구할 숫자의 갯수, 게임에 참가하는 인원) 까지의 숫자 길이를 갖을 때 까지 n 진수 1부터 등차가 1인 수열을 붙인다. </br>
이렇게 만들어진 문자열을 num 이라 하자. </br>
이 num 에서 튜브의 순서가 올 때의 문자를 추출한 문자열을 만들어 반환한다. </br>
튜브의 차례는 p 이므로 p번째 문자부터 p + m * t 번째 까지의 문자를 추출하여 답을 구한다.  </br>


### 소스 코드
```java
public class N진수_게임 {
    public String solution(int n, int t, int m, int p) {
        //N진수 게임
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (sb.length() < t * m) {
            String num = Integer.toString(i++, n); //숫자 i를 n진수 숫자로 변환
            sb.append(num); 
        }
        String num = sb.toString().toUpperCase(); // 소문자 대문자로 변환
        sb = new StringBuilder();
        for (int j = p -1 ; j <  t * m; j+=m) {
            sb.append(num.charAt(j)); // p차례 부터 m번 마다 문자 넣기
        }
        answer = sb.toString();
        return answer;
    }
}

```