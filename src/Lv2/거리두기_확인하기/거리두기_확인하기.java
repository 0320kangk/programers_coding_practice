package Lv2.java.거리두기_확인하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 거리두기_확인하기 {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        HashMap<Integer, List<Integer[]>> map = new HashMap<>();
        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < places[0].length; j++) {
                for (int k = 0; k < places[i][j].length(); k++) {
                    if (places[i][j].charAt(k) == 'P') {
                        Integer[] point = {j, k};
                        if (map.containsKey(i)) {
                            map.get(i).add(point);
                        } else {
                            ArrayList<Integer[]> room = new ArrayList<>();
                            room.add(point);
                            map.put(i, room);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
                answer[i] = 1;
        }
        for ( Integer key : map.keySet()) {
            List<Integer[]> points = map.get(key);
            for (int j = 0; j < points.size(); j++) {
                Integer[] point1 = points.get(j);
                boolean able = true;
                for (int k = j + 1; k < points.size() ; k++) {
                        Integer[] point2 = points.get(k);
                        double pow1 = Math.pow(point1[0] - point2[0], 2);
                        double pow2 = Math.pow(point1[1] - point2[1], 2);
                        double d = pow2 + pow1;
                        if (d < 2) {
                            able = false;
                            break;
                        } else if (d == 2 && point1[1] != point2[1]) {
                            String s1 = places[key][point1[0]];
                            String s2 = places[key][point2[0]];

                            char c1;
                            char c2;
                            if (point1[1] > point2[1]) {
                                c1 = s1.charAt(point1[1] - 1);
                                c2 = s2.charAt(point2[1] + 1);
                            } else {
                                c1 = s1.charAt(point1[1] + 1);
                                c2 = s2.charAt(point2[1] - 1);
                            }
                            if (c1 != 'X' || c2 != 'X') {

                                able = false;
                                break;
                            }
                        } else if ( d == 4) {
                            if (point1[0] == point2[0]&&
                                places[key][point1[0]].charAt(point1[1] + 1) == 'O') {
                                able = false;
                                break;
                            } else if (point1[0] != point2[0]&&
                                    places[key][point1[0] + 1].charAt(point1[1]) == 'O') {
                                able = false;
                                break;
                            }
                        }
                }
                if (able == false) {
                    answer[key] = 0;
                    break;
                }

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        거리두기_확인하기 거리두기_확인하기 = new 거리두기_확인하기();
        int[] solution = 거리두기_확인하기.solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
        System.out.println(Arrays.toString(solution));
    }
}
