package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;


/**
 *  GCD = 최대공약수
 *  LCM = 최소공배수
 */
public class GcdLcm {

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        //두 수의 곱 / 두 수의 최대공약수
        return a * b / gcd(a, b);
    }

}
