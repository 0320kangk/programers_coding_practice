package Lv2.파일명_정렬;

import java.util.Arrays;
public class 파일명_정렬 {
    public String[] solution(String[] files) {
        File[] fileArray = new File[files.length];
        for (int i = 0; i < files.length; i++) {
            String upperFile = files[i].toUpperCase();
            int numIndex = 0;
            int lastNumIndex = 0;
            for (int j = 0; j < upperFile.length(); j++) {
                if (Character.isDigit(upperFile.charAt(j))){
                    numIndex = j;
                    for (int k = j; k < upperFile.length(); k++) {
                        if (!Character.isDigit(upperFile.charAt(k))){
                            lastNumIndex = k;
                            break;
                        }
                    }
                    break;
                }
            }
            String head = upperFile.substring(0,numIndex);
            if (lastNumIndex == 0) lastNumIndex = upperFile.length();
            int number =  Integer.parseInt(upperFile.substring(numIndex, lastNumIndex));
            File file1 = new File(head, number, files[i]);
            fileArray[i] = file1;
        }
        Arrays.sort(fileArray);
        String[] answer = new String[files.length];
        answer = Arrays.stream(fileArray)
                .map( x -> x.origin)
                .toArray(String[]::new);
        return answer;
    }
    class File implements Comparable<File> {
        String head;
        int number;
        String origin;
        public File(String head, int number, String origin) {
            this.head = head;
            this.number = number;
            this.origin = origin;
        }
        public int compareTo(File o) {
            if (!this.head.equals(o.head)){
                return this.head.compareTo(o.head);
            } else {
                return Integer.compare(this.number, o.number);
            }
        }
    }
    public static void main(String[] args) {
        파일명_정렬 파일명_정렬 = new 파일명_정렬();
        String[] solution = 파일명_정렬.solution(new String[]{"img12.png"});
        System.out.println(Arrays.toString(solution));
    }
}
