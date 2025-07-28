package algorithm.programmers;

/**
 * Summer/Winter Coding(~2018)
 * 점프와 순간이동
 */
public class JumpAndTeleportation {

    //K칸 앞으로 점프 or 현재까지온거리 X2로 순간이동
    //K칸 이동은 K만큼 건전지 사용.
    public int solution(int n) {
        int count = 0;

        while (n != 0) {
            if (n % 2 == 1) {
                count++;
            }
            n /= 2;
        }
        return count;
    }
}
