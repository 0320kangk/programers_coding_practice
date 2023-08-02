package Lv2.java.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 오픈채팅방 {
    final String[] command = {"Enter", "Leave", "Change"};
    public String[] solution(String[] record) {
        String[] answer = {};
        List<String> chatList = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>(); //id, name, 마지막 아이디가 무엇인지 알기
        for (String r : record) {
            String[] split = r.split(" ");
            if( split[0].equals(command[1]) ){
                chatList.add(split[1] + "님이 나갔습니다." );
            } else if (split[0].equals(command[0]) ) {
                map.put(split[1], split[2]);
                chatList.add(split[1] + "님이 들어왔습니다." );
            } else {
                map.put(split[1], split[2]);
            }
        }
        ArrayList<String> messageList = new ArrayList<>();

        for (int i = 0; i < chatList.size() ; i++) {
            String s1 = chatList.get(i);
            String[] split = s1.split("님");
            if (map.containsKey(split[0])) {
                s1 = s1.replace(split[0], map.get(split[0]));
                messageList.add(s1);
            }
        }
        answer = messageList.toArray(new String[messageList.size()]);
        return answer;
    }

    public static void main(String[] args) {
        오픈채팅방 문제1 = new 오픈채팅방();
        문제1.solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
    }


}
