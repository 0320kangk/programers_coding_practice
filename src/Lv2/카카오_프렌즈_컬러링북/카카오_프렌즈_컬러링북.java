package Lv2.카카오_프렌즈_컬러링북;

public class 카카오_프렌즈_컬러링북 {

    int[] dx = {1,0,-1,0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] used;
    int[][] picture;
    int maxSizeOfOneArea;
    int size;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        this.used = new boolean[picture.length][picture[0].length];
        this.picture = picture;
        for(int i = 0; i < this.picture.length; i++) {
            for(int j = 0; j < this.picture[0].length; j++) {
                if(!this.used[i][j] && this.picture[i][j] != 0){
                    this.used[i][j] = true;
                    size = 1;
                    dfsFriends(this.picture[i][j], new int[]{i, j});
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(size, maxSizeOfOneArea);
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    void dfsFriends(int color, int[] point) {
        for(int i = 0; i < 4; i++){
            int x = point[0] + dx[i];
            int y = point[1] + dy[i];
            if ( (x >= 0 && x< picture.length ) &&
                    (y >= 0 && y < picture[0].length) &&
                    !used[x][y] &&
                    picture[x][y] == color) {
                used[x][y] = true;
                size++;
                dfsFriends(color, new int[]{x, y});
            }
        }
    }
}
