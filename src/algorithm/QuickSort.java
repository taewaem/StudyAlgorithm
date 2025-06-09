package step;

/*
퀵정렬
평균적으로 가장 빠른 정렬
전체 리스트를 2개의 리스트로 분할 후, 다쉬 퀵정렬(재귀 호출)로 정렬
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QuickSort {
    public static void main(String[] args) {



//        //프로그래머스 lv_1 2022 kakao 다시 풀기.
//        HashMap<String, Integer> map = new HashMap<>();
//        HashMap<String, String> userReport = new HashMap<>();
//        int[] answer = {};
//
//        for(int i=0; i<id_list.length; i++){
//            map.put(id_list[0], 0);
//        }
//        for(int i=0; i<report.length; i++){
//            String[] s = report[i].split(" ");
//
//            if (map.get(s[i]) && userReport.get(s[0])) {
//                userReport.put(s[0], s[1]);
//                map.put(s[i], map.get(s[i]) + 1);
//            }
//        }
//        for (int i = 0; i < map.size(); i++) {
//            answer = map.get(id_list[i]);
//        }
//
//
//        String a = "spring summer";
//        String[] s = a.split(" ");
//

//        String answer = "";
//        int num = 0;
//
//        for(int i=0; i<completion.length; i++){
//            for(int j=0; j<participant.length; j++){
//                if(completion[i].equals(participant[j]))
//                    participant[j] = null;
//                break;
//            }
//        }
//        for(int i=0; i<participant.length; i++){
//            if(participant[i] != null)
//                answer += participant[i];
//        }
//

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        HashMap<String, Integer> map = new HashMap<>();

        queue.add(1);
        stack.add(1);
        map.put("one", 1);

        queue.poll();
        stack.pop();
        map.get("one");

        queue.peek();
        stack.peek();
        map.size();

        int[] arr = {2,1,3,4,5};

        quick_sort(arr, 0, (arr.length)-1);

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    private static void quick_sort(int[] arr, int left, int right){
        if(left < right){
            int q = partition(arr, left, right);
            quick_sort(arr, left, q-1);
            quick_sort(arr, q+1, right);
        }
    }

    private static int partition(int[] arr, int left, int right){

        int low;
        int high;
        int pivot;

        pivot = arr[left];
        low = left + 1 ;
        high = right;

        // 루프 조건을 low < high로 설정하여 올바른 분할 수행
        while (low <= high) {
            // pivot보다 큰 값이여야 하므로 pivot보다 작으면 low 증가
            while (low <= right && pivot > arr[low]) {
                low++;
            }
            // pivot보다 작은 값이여야 하므로 pivot보다 크면 high 감소
            while (high >= left && pivot < arr[high]) {
                high--;
            }
            // low가 high보다 작은 경우에만 swap 수행
            if (low < high) {
                swap(arr, low, high);
            }
        }

        swap(arr, left, high);
        return high;
    }



    private static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}