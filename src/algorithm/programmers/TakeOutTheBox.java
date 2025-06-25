package algorithm.programmers;

/**
 * 2025 코드 챌린지 2차 예선
 * 택배 상자 꺼내기
 */
public class TakeOutTheBox {

    /**
     * 상자을 왼쪽에서 오른쪽
     * if(w개 놓았다면)
     * 상자를 오른쪽에서 왼쪽으로
     * 상자 위에 있는거 꺼내기
     */
    public int solution(int n, int w, int num) {
        int h;

        if (n % w == 0) {
            h = n/w;
        }
        else {
            h = (n/w) + 1;
        }

        int boxNumber = 1;

        int[][] box = new int[h][w];

        for (int i = 0; i < h; i++) {
            if (i % 2 == 0) { // 왼 → 오
                for (int j = 0; j < w && boxNumber <= n; j++) {
                    box[i][j] = boxNumber++;
                }
            } else { // 오 → 왼
                for (int j = w - 1; j >= 0 && boxNumber <= n; j--) {
                    box[i][j] = boxNumber++;
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (box[i][j] == num) {
                    int count = 0;
                    for (int k = i; k < h; k++) {
                        if (box[k][j] != 0)
                            count++;
                    }
                    return count;
                }
            }
        }

        return 0;

    }
}
