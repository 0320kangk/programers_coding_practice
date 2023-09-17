package Lv1.개인정보_수집_유효기간;
import java.util.*;
public class 개인정보_수집_유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap();

        String[] splitT = today.split(".");
        Date dateT = createDate(today);

        List<Integer> list = new ArrayList();
        for( String term : terms){
            String[] split = term.split(" ");
            map.put(split[0], Integer.valueOf(split[1]));
        }
        int index = 1;
        for(String privacy : privacies) {
            String[] splitP = privacy.split(" ");
            Date dateP = createDate(splitP[0]);
            int term = map.get(splitP[1]);

            Date addDate = dateP.addTerm(term);
            if (dateT.compareTo(addDate) > 0){
                list.add(index);
            }
            index++;
        }
        answer = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();


        return answer;
    }

    Date createDate(String date){
        String[] splitDate = date.split("\\.");
        return new Date(Integer.parseInt(splitDate[0]),
                Integer.parseInt(splitDate[1]),
                Integer.parseInt(splitDate[2]));
    }

    class Date implements Comparable<Date> {
        int year;
        int month;
        int day;
        public Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
        public int compareTo (Date date) {
            if (this.year != date.year ){
                return this.year - date.year;
            } else if (this.month != date.month) {
                return this.month - date.month;
            }
            return this.day - date.day;
        }
        public Date addTerm (int term) {
            int addY = this.year + (this.month + term - 1) / 12;
            int addM = (this.month + term) % 12;
            if (addM == 0) addM = 12;
            int addD = this.day - 1;
            if (addD == 0) {
                addD = 28;
                addM--;
            }
            return new Date(addY,
                    addM,
                    addD);
        }
        public String toString(){
            return "year" + ":" + year +
                    "month" + ":" + month +
                    "day" + ":" + day;
        }
    }
}
