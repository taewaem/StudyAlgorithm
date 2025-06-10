package algorithm.programmers;


import java.util.*;

/**
 * PCCE 10번 공원
 *
 */
public class ParkingLot {
    public static void main(String[] args) {

        int[] mats = {5, 3, 2};

        String[][] park = {
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };

        int result = 3;// 3번째 매트 크기 (2)

        int answer = soultion(mats, park);

        System.out.println(answer);
    }

    private static int soultion(int[] mats, String[][] park) {

        int answer;

//        Collections.reverseOrder()는 integer일 때 사용 가능
//        Arrays.sort(mats, Collections.reverseOrder());
//        mats 내림차순 정렬


        // 가지고 있는 돗자리 크기를 내림차순 정렬
        // 가장 큰 돗자리부터 깔아볼 수 있도록 함
        Arrays.sort(mats);

        // 큰 돗자리부터 확인하기 위해 역순으로 반복
        for (int i = mats.length - 1; i >= 0; i--) {

            int size = mats[i];         // 현재 확인할 돗자리의 한 변 길이


            // (j, k)는 돗자리를 깔 수 있는 좌측 상단 좌표
            for (int j = 0; j <= park.length - size; j++) {
                for (int k = 0; k <= park[0].length - size; k++) {

                    boolean check = true;  // 해당 위치에 돗자리를 깔 수 있는지 여부
                    
                    // size x size 크기의 사각형 범위를 확인
                    for (int x = 0; x < size; x++) {
                        for (int y = 0; y < size; y++) {

                            // park[j + x][k + y]가 "-1"이 아니면 사람이 있는 자리
                            if (!park[j + x][k + y].equals("-1")) {
                                check = false; // 돗자리 못 깜
                                break;
                            }
                        }
                        if (!check)
                            break;  // 사람이 있으므로 이 위치는 불가능
                    }

                    // 깔 수 있는 위치를 찾았으면 바로 반환
                    if (check)
                        return size;
                }
            }
        }

        // 모든 위치에 어떤 돗자리도 깔 수 없을 경우
        return -1;
    }
}
