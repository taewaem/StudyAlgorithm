//package step;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class HeapSort {
//    public static  void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int[] test = {40, 20, 50, 10, 30, 70};
//
//        heapSort(test);
//    }
//
//
//    private static void heapSort(int[] arr){
//
//        int n= arr.length;
//
//        for(int i = n/2 -1; i>=0; i--){
//            heapify(arr, n, i);
//        }
//        System.out.println(Arrays.toString(arr));
//    }
//
//
//    private static void heapify(int[] arr, int parentIndex, int n){
//
//        int leftIndex = 2*parentIndex+1;
//        int rightIndex = 2*parentIndex+2;
//        int largestIndex = parentIndex;
//
//        if(leftIndex <= n && arr[largestIndex] < arr[leftIndex]){
//            largestIndex = leftIndex;
//        }
//
//        if(rightIndex <= n && arr[largestIndex] < arr[rightIndex]){
//            largestIndex = rightIndex;
//        }
//
//        if(parentIndex != largestIndex){
//            swap(arr, parentIndex, largestIndex);
//        }
//    }
//
//    private static void swap(int[] arr, int i, int j){
//        int tmp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tmp;
//    }
//
//}
//
////
////    private static void heapif(int[] arr, int index){
////        for(int i=1; i<index; i++)      //i가 1부터 시작하는 이유는 0번    노드는 루트 노드이기 때문이다.
////        {
////            int child = i;
////            while(child > 0){
////                int parent = (child-1)/2;           //부모의 값은 자식-1/2 를 나눠주면 나온다.
////                if(arr[child] > arr[parent]){
////                    swap(arr, child, parent);
////                    System.out.println("변환된 정렬");
////                    System.out.println(Arrays.toString(arr));
////                }
////                child = parent;
////            }
////        }
////        System.out.println("최종 배열 = " + Arrays.toString(arr));
////    }