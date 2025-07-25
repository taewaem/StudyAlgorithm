package algorithm.programmers;

import java.util.Stack;

/**
 * 2019 카카오 개발자 겨울 인턴쉽
 * 크레인 인형뽑기 게임
 */
public class DollClawMachine {
    public int solution(int[][] board, int[] moves) {
        //같으면 폭발
        //총 개수 구하기

        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            int pick = moves[i] - 1;

            for (int j = 0; j < board.length; j++) {
                if (board[j][pick] != 0) {
                    int last = board[j][pick];
                    board[j][pick] = 0;

                    if (!stack.isEmpty() && stack.peek() == last) {
                        stack.pop();
                        answer += 2;
                    }else {
                        stack.push(last);
                    }

                    break;
                }
            }
        }

        return answer;
    }
}