package algorithm.programmers;

public class LengthOfOverlappingSegments {
    private static int solution(int[][] lines) {
        int[] cover = new int[201]; // -100 ~ 100 범위이므로 0~200 인덱스 사용

        for (int[] line : lines) {
            int start = line[0] + 100; // 음수 보정
            int end = line[1] + 100;
            for (int i = start; i < end; i++) {
                cover[i]++;
            }
        }

        int answer = 0;
        for (int c : cover) {
            if (c >= 2) answer++;
        }

        return answer;
    }
}
