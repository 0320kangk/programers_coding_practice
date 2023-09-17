package Lv2.방금그곡;

import java.util.*;
public class 방금그곡 {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        List<String> listenSheet = divide(m);
        int minPlayTime = 0;
        for (String musicInfo : musicinfos) {
            String[] musicInfoSplit = musicInfo.split(",");
            List<String> sheetMusic = divide(musicInfoSplit[3]);
            int playTime = difTime(musicInfoSplit[0], musicInfoSplit[1]);
            if (sheetMusic.size() > playTime ) sheetMusic = sheetMusic.subList(0, playTime);
            for (int i = 0; i < sheetMusic.size(); i++) {
                int sheetIndex = i;
                int listenIndex = 0;
                boolean flag = false;
                for (int j = 0; j < listenSheet.size(); j++) {
                    if (sheetIndex == sheetMusic.size())
                        sheetIndex = 0;
                    if (listenIndex == listenSheet.size())
                        listenIndex = 0;

                    if (!sheetMusic.get(sheetIndex++).equals(listenSheet.get(listenIndex++))) {
                        flag = true;
                        break;
                    }
                }
                if (!flag && playTime > minPlayTime) {
                   answer = musicInfoSplit[2];
                   minPlayTime = playTime;
                }
            }
        }
        return answer;
    }
    public int difTime(String startTime, String endTime) {
        String[] split1 = startTime.split(":");
        int sTime = Integer.parseInt(split1[0]) * 60 + Integer.parseInt(split1[1]);
        String[] split2 = endTime.split(":");
        int eTime = Integer.parseInt(split2[0]) * 60 + Integer.parseInt(split2[1]);
        return eTime-sTime;
    }
    public static List<String> divide(String sheetMusic) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < sheetMusic.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(sheetMusic.charAt(i));
            if ( i + 1 < sheetMusic.length() &&sheetMusic.charAt(i + 1) == '#')
                list.add(String.valueOf(sb.toString() + "#"));
            else if ( sheetMusic.charAt(i) == '#')
                continue;
            else
                list.add(sb.toString());
        }
        return list;
    }
    public static void main(String[] args) {
        방금그곡 방금그곡 = new 방금그곡();
        String abcdefg = 방금그곡.solution("AAAAAAAAAA"	, new String[]{
                "03:00,03:02,FOO,AAAAAAAAAAA"});
        System.out.println(abcdefg);


    }
}
