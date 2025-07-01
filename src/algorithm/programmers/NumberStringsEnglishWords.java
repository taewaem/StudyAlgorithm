package algorithm.programmers;

/**
 * 2021 카카오 채용연계형 인턴쉽
 * 숫자 문자열과 영단어
 */
public class NumberStringsEnglishWords {

    public int solution(String s) {

        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < arr.length; i++) {
            if (s.contains(arr[i])) {
                s = s.replace(arr[i], Integer.toString(i));
            }
        }

        return Integer.parseInt(s);
    }
}
