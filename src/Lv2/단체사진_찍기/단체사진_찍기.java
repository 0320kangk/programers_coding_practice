package Lv2.단체사진_찍기;

public class 단체사진_찍기 {
    boolean[] visited;
    char[] friends = new char[]{'A','C','F','J','M','N','R','T'};
    int count = 0;
    String[] data;

    public int solution(int n, String[] data) {
        int answer = 0;
        this.visited =new boolean[8];
        this.data = data;
        dfs("");
        answer = count;
        return answer;
    }
    void dfs(String line) {
        if ( line.length() == this.friends.length) {
            if ( checkCondition(line)){
                count++;
            }
            return;
        }
        for (int i = 0; i < this.friends.length ;i++){
            if(!this.visited[i]) {
                visited[i] = true;
                dfs(line + friends[i]);
                visited[i] = false;
            }
        }
    }
    boolean checkCondition(String line){
        for(String d : this.data) {
            String[] splitD = d.split("~");
            String friends1 = String.valueOf(splitD[0].charAt(0));
            String friends2 = String.valueOf(splitD[1].charAt(0));
            String compare = String.valueOf(splitD[1].charAt(1));
            int distC = Integer.parseInt(String.valueOf(splitD[1].charAt(2)));
            int dist = Math.abs(line.indexOf(friends1) - line.indexOf(friends2)) - 1;
            if( !((compare.equals(">") && dist > distC) ||
                    (compare.equals("<") && dist < distC) ||
                    (compare.equals("=") && dist == distC))){
                return false;
            }
        }
        return true;
    }

}
