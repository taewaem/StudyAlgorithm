package algorithm.programmers;


/**
 * 2025 코드챌린지 1차 예선
 * 유연근무제
 */
public class FlexibleWorkSystem {

    public static void main(String[] args) {

    }
    /**
     *    출근 희망 시각 + 10분
     *    토, 일 영향X
     *    시간은  시에 100 곱하고 분을 더한 정수 ex)10시13분 ->1000 + 13 = 1013
     *    일주일동안 지각을 안하고 상품받은 직원은 몇 명?
     *    i는 i+1번이 설정한 출근 희망시간 700~1100(7시에서 11시)
     *    i번쨰 직원이 j+1일차에 출근
     *    1은 월요일, 2는 화요일, 3은 수요일, 4는 목요일, 5는 금요일, 6은 토요일, 7일요일 %7
     */
    private static int solution(int[] schedules, int[][] timelogs, int startday) {

        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int sequence = 0;
            int day = startday;

            for (int j = 0; j < timelogs[i].length; j++) {
                int currentDay = day % 7;
                day++;

                // 주말은 패스
                if (currentDay == 0 || currentDay == 6)
                    continue;

                // 시각 비교는 "분 단위"로!
                int scheduleHour = schedules[i] / 100;
                int scheduleMinute = schedules[i] % 100;
                int scheduleTotal = scheduleHour * 60 + scheduleMinute;

                int deadline = scheduleTotal + 10;

                int logHour = timelogs[i][j] / 100;
                int logMinute = timelogs[i][j] % 100;
                int logTotal = logHour * 60 + logMinute;

                // 출근 인정
                if (logTotal <= deadline) {
                    sequence++;
                }

                if (sequence == 5) {
                    answer++;
                }
            }
        }

        return answer;      }
}
