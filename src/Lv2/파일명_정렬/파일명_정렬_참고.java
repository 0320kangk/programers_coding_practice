package Lv2.파일명_정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 파일명_정렬_참고 {
    public String[] solution(String[] files) {
        Pattern p = Pattern.compile("([a-z\\s.-]+)([0-9]{1,5})");
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                Matcher matcher1 = p.matcher(s1.toLowerCase());
                Matcher matcher2 = p.matcher(s2.toLowerCase());
                matcher1.find();
                matcher2.find();
                if (!matcher1.group(1).equals(matcher2.group(1))) {
                    return matcher1.group(1).compareTo(matcher2.group(1));
                } else {
                    return Integer.compare(Integer.parseInt(matcher1.group(2)),
                                            Integer.parseInt(matcher2.group(2)));
                }
            }
        });
        return files;
    }
    public static void main(String[] args) {
        파일명_정렬_참고 파일명_정렬_참고 = new 파일명_정렬_참고();
        파일명_정렬_참고.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});

    }

}
