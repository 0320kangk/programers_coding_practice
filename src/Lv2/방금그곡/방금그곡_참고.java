package Lv2.방금그곡;

public class 방금그곡_참고 {
    //참고 링크: https://school.programmers.co.kr/learn/courses/30/lessons/17683/solution_groups?language=java

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int time = 0;

        m = edit(m); // #문자 1개의 길이 문자로 치환

        for (int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            int start = 60 * Integer.parseInt(info[0].substring(0,2)) + Integer.parseInt(info[0].substring(3));
            int end = 60 * Integer.parseInt(info[1].substring(0, 2)) + Integer.parseInt(info[1].substring(3));
            int playTime = end - start;

            if (playTime > time ) {
                info[3] = edit(info[3]);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < playTime; j++) {//playTime 길이 만큼의 문자열 만들기
                    sb.append(info[3].charAt(j % (info[3].length())));//j가 악보보다 길면 0부터 시작
                }
                System.out.println(sb.toString());
                if (sb.toString().indexOf(m) >= 0){
                    answer = info[2];
                    time = playTime; // 조건을 만족하는 더 긴 playTime 찾기
                }
            }
        }
        return answer;
    }
    //작성자의 풀이와 다르게 #이 달린 음을 다른 문자로 대체하였다.
    public String edit(String m) {

        m = m.replaceAll("C#", "V");
        m = m.replaceAll("D#", "W");
        m = m.replaceAll("F#", "X");
        m = m.replaceAll("G#", "Y");
        m = m.replaceAll("A#", "Z");

        return m;
    }


}
