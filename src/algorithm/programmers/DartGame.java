package algorithm.programmers;

/**
 * 2018 KAKAO BLIND RECRUITMENT
 * 다트게임
 */
public class DartGame {

    public int solution(String dartResult) {
        //세 차례 던져 점수희 합계
        //총 3번 0~10점까지
        // S, D, T 영역 존재 1제곱, 2제곱, 3제곱
        // 스타상시 점수 2배, # 당첨 시 -로 변환
        // * # 존재할 수도 있고 안할 수도 있음

        String[] bonus = {"S", "D", "T"};
        String[] random = {"*", "#"};

        int answer = 0;
        String[] split = dartResult.split("");
        int[] result = new int[3];
        int n = 0;

        for (int i = 0; i < split.length; i++) {
            if (i != 0) {
                if (split[i].equals(bonus[0])) {
                    result[n] = Integer.parseInt(split[i - 1]) * 1;
                    n++;
                } else if (split[i].equals(bonus[1])){
                    result[n] = Integer.parseInt(split[i - 1]) * Integer.parseInt(split[i - 1]);
                    n++;
                } else if (split[i].equals(bonus[2])) {
                    result[n] = Integer.parseInt(split[i - 1]) * Integer.parseInt(split[i - 1]) * Integer.parseInt(split[i - 1]);
                    n++;
                }

                if (split[i].equals(random[0])) {
                    if (n == 1) {
                        result[n-1] = result[n-1] * 2;
                    }else {
                        for (int j = n - 2; j < n; j++) {
                            result[j] = result[j] * 2;
                        }
                    }
                }
                if (split[i].equals(random[1])) {
                    if (n == 0) {
                        result[n] = result[n] * -1;
                    }else{
                        result[n - 1] = result[n - 1] * -1;
                    }
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            answer += result[i];
        }
        return answer;
    }
}
