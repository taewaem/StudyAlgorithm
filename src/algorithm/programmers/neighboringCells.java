package algorithm.programmers;

/**
 * PCCE 9번
 * 이웃한 칸
 */
public class neighboringCells {

    //위 아래 왼쪽 오른쪽 중 같은 색깔 갯수 구하기
    //색깔 리스트 board
    //위치를 h,w로 나타냄
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int solution(String[][] board, int h, int w) {

        // 위, 아래, 왼쪽, 오른쪽 방향

            int count = 0;
            String targetColor = board[h][w];

            for (int i = 0; i < 4; i++) {
                int nh = h + dx[i];
                int nw = w + dy[i];

                // 경계 체크
                if (nh >= 0 && nh < board.length && nw >= 0 && nw < board[0].length) {
                    if (board[nh][nw].equals(targetColor)) {
                        count++;
                    }
                }
            }

            return count;
        }
}
