package algorithm.programmers;

import java.util.*;

/**
 * PCCE 10번
 * 데이터 분석
 */
public class DataAnalysis {
    /**
     * ext 값이 < sort_by
     * ext, sort_by -> code, date, maximum, remain
     * sort_by순으로 오름차순
     * val_ext보다 작은 데이터만 오름차순
     */
    static int search;
    static int sort;

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();

        // 필터링 기준 설정 (ext)
        if (ext.equals("code")) {
            search = 0;
        } else if (ext.equals("date")) {
            search = 1;
        } else if (ext.equals("maximum")) {
            search = 2;
        } else if (ext.equals("remain")) {
            search = 3;
        }

        // val_ext보다 작은 데이터만 필터링
        for (int[] row : data) {
            if (row[search] < val_ext) {
                list.add(row);
            }
        }

        // 정렬 기준 설정 (sort_by)
        if (sort_by.equals("code")) {
            sort = 0;
        } else if (sort_by.equals("date")) {
            sort = 1;
        } else if (sort_by.equals("maximum")) {
            sort = 2;
        } else if (sort_by.equals("remain")) {
            sort = 3;
        }

        // 오름차순 정렬
        Collections.sort(list, (a, b) -> a[sort] - b[sort]);

        // List -> 배열 변환
        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
