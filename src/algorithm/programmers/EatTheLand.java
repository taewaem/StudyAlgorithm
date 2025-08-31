package algorithm.programmers;

public class EatTheLand {

    class Solution {
        int maxScore = 0;
        int solution(int[][] land) {
            int answer = 0;

            int preCol = -1;

            for(int row = 0; row< land.length; row++){

                int maxColValue = 0;

                int targetCol = 0;

                for(int col = 0; col<4; col++){
                    if(col == preCol) continue;

                    if(maxColValue < land[row][col]){
                        targetCol = col;
                        maxColValue = land[row][col];
                    }
                }

                preCol = targetCol;

                answer += maxColValue;
            }

            return answer;
        }
    }
}
