package algorithm.programmers;

import java.util.*;

/**
 * 2022 KAKAO BLIND RECRUITMENT
 * 신고 결과 받기
 */
public class GetReportResults {
    private static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < report.length; i++) {

            String[] reports = report[i].split(" ");

            if (!map.containsKey(reports[1])) {
                map.put(reports[1], new HashSet<>());
            }

            map.get(reports[1]).add(reports[0]);
        }

        Map<String, Integer> countMap = new HashMap<>();

        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            if (entry.getValue().size() >= k) {
                for (String reporter : entry.getValue()) {
                    if (!countMap.containsKey(reporter)) {
                        countMap.put(reporter, 0);
                    }
                    countMap.put(reporter, countMap.get(reporter) + 1);
                }
            }
        }
        for (int i = 0; i < id_list.length; i++) {
            if (!countMap.containsKey(id_list[i])) {
                countMap.put(id_list[i], 0);
            }
            answer[i] = countMap.get(id_list[i]);
        }

        return answer;
    }

    /**
     * 더 개선된 코드
     */
    class solution {
        public int[] solution(String[] id_list, String[] report, int k) {

            // 최종 결과 메일 수 배열 (id_list 순서대로)
            int[] answer = new int[id_list.length];

            // 1. 중복 신고 제거 (한 사람이 같은 사람을 여러 번 신고하는 경우 1회만 인정)
            Set<String> uniqueReports = new HashSet<>(Arrays.asList(report));

            // 2. 신고당한 사람(key) -> 신고한 사람(set) 목록 저장
            Map<String, Set<String>> reportMap = new HashMap<>();

            // 중복 제거된 신고들을 기반으로 Map 구성
            for(String rep : uniqueReports){
                String[] parts = rep.split(" ");
                String reporter = parts[0];  // 신고한 사람
                String reported = parts[1];  // 신고당한 사람

                // reported를 키로, 신고자들을 Set으로 관리 (중복 방지)
                reportMap.putIfAbsent(reported, new HashSet<>());
                reportMap.get(reported).add(reporter);
            }

            // 3. 각 신고자별 메일 수를 저장할 Map
            Map<String, Integer> countMap = new HashMap<>();

            // 4. 신고당한 사람이 k번 이상 신고되었는지 확인
            for (Map.Entry<String, Set<String>> entry : reportMap.entrySet()) {
                String reported = entry.getKey();         // 신고당한 사람
                Set<String> reporters = entry.getValue(); // 신고한 사람들

                // 신고당한 횟수가 k 이상이면, 신고자들에게 메일 보냄(카운트 증가)
                if (reporters.size() >= k) {
                    for (String reporter : reporters) {
                        countMap.putIfAbsent(reporter, 0);
                        countMap.put(reporter, countMap.get(reporter) + 1);
                    }
                }
            }

            // 5. id_list 순서대로 메일 수를 answer 배열에 넣기
            for (int i = 0; i < id_list.length; i++) {
                countMap.putIfAbsent(id_list[i], 0); // 신고 내역 없으면 0으로 초기화
                answer[i] = countMap.get(id_list[i]);
            }

            // 최종 결과 반환
            return answer;
        }
    }
}