package algorithm.programmers;
import java.util.*;

/**
 * 2025-06-20
 *
 * 2022 KAKAO BLIND RECRUITMENT
 * 주차 요금 계산
 */
public class ParkingFeeCalculation {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> timeMap = new HashMap<>(); // 차량별 누적 시간
        Map<String, String> inMap = new HashMap<>();    // 차량별 마지막 입차 시간

        for (String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];
            String car = parts[1];
            String action = parts[2];

            if (action.equals("IN")) {
                inMap.put(car, time);
            } else { // OUT
                int duration = getDuration(inMap.get(car), time);
                timeMap.put(car, timeMap.getOrDefault(car, 0) + duration);
                inMap.remove(car);
            }
        }

        // 출차 기록 없는 차 처리 (23:59 출차)
        for (String car : inMap.keySet()) {
            int duration = getDuration(inMap.get(car), "23:59");
            timeMap.put(car, timeMap.getOrDefault(car, 0) + duration);
        }

        // 요금 계산 및 차량번호 오름차순 정렬
        List<String> cars = new ArrayList<>(timeMap.keySet());
        Collections.sort(cars);

        int[] result = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            int totalTime = timeMap.get(cars.get(i));
            result[i] = calculateFee(fees, totalTime);
        }

        return result;
    }

    private int getDuration(String in, String out) {
        String[] inTime = in.split(":");
        String[] outTime = out.split(":");

        int inMinutes = Integer.parseInt(inTime[0]) * 60 + Integer.parseInt(inTime[1]);
        int outMinutes = Integer.parseInt(outTime[0]) * 60 + Integer.parseInt(outTime[1]);

        return outMinutes - inMinutes;
    }

    private int calculateFee(int[] fees, int time) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (time <= baseTime) return baseFee;

        return baseFee + (int)Math.ceil((time - baseTime) / (double)unitTime) * unitFee;
    }
}
