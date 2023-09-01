# N_Queen 풀이

### [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12952)

### 문제 풀이
이 문제는 n개의 퀸을 n * n 체스판에 서로 공격하지 못하게 배치하는 모든 경우를 찾는 문제이다. </br>
언듯 보기에 n * n 의 2차원 배열 칸에 퀸을 배치하여 경우를 찾는 문제 같다. </br>
하지만 이런 식으로 풀면 너무 많은 수행시간이 필요하게 된다. 또한 불필요한 계산절차도 엄청 많아진다. </br>
그렇다면 어떻게 풀어야 할까? </br>
바로 1차원 배열 체스판을 만들어 퀸을 배치한다.</br>
퀸은 같은 행에 존재할 수 없다는 것을 인지하자.</br>
1차원 배열 int arr[n] 에 대하여 각 인덱스가 행의 역할을 할 수가 있다.</br>
각 인덱스가 행의 역할을 한다면 퀸은 같은 행에 존재할 수 없게 된다.</br>
arr 배열의 값은 열이 된다.</br>
백트래킹을 이용하여 arr 에 조건에 맞는 모든 퀸을 배치하여 답을 찾는다.</br>
서로간의 퀸은 아래 조건을 만족해야 한다.</br>
1. 두 퀸의 좌표에 대한 직선의 기울기가 -1 혹은 1이 아니어야 한다.</br>
   + 기울기가 1이거나 -1이면 두 퀸이 대각선으로 공격이 가능하다.</br>
2. 서로 간의 퀸이 같은 열에 존재하지 않아야 한다.</br>


### 소스 코드

```java
public class N_Queen {
   public int solution(int n) {
      int[] arr = new int[n];
      int answer = bt(arr, 0, n);
      return answer;
   }
   int bt (int[] arr, int row , int n) {
      int count = 0;
      if (row == n) {
         return 1;
      }
      for (int i = 0; i < arr.length; i++) {
         arr[row] = i;// 행 = 열
         if (checking(arr, row)) {
            count += bt(arr, row + 1 , n);
         }
      }
      return count;
   }
   boolean checking(int[] arr,int row) {
      for (int i = 0; i < row; i++) {
         if (arr[row] ==arr[i])
            return false;
         if ( Math.abs(arr[row] - arr[i]) == Math.abs( row - i))
            return false;
      }
      return true;
   }
}

```