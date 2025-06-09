package Saafy;

import java.util.*;
import java.io.*;

public class one {
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int first = 0;

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int x = sc.nextInt();


            first = 0;

            if (d == x) {
                first++;
            }

            int sum = 0;
            int[] arr = new int[n];
            int[] new_arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
                sum += arr[j];
            }
            for (int k = d; k <= sum; k++) {
                new_arr[k % n]++;
                first++;
                if (new_arr[d - 1] == arr[d - 1] && (k % n) == x - 1) {
                    break;
                }
            }
            System.out.println("#" + first);

        }

    }
}
