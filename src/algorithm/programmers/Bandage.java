package algorithm.programmers;

/**
 * 붕대 감기
 */
public class Bandage {

    
}
class Solution{
    public int solution(int[] bandage, int health, int[][] attacks){
        //t초동안 1초에 x만큼
        //t초 연속 성공 시 y만큼 추가 회복
        //최대 체력 넘기 X
        int time = bandage[0];
        int heal = bandage[1]; //초당 회복량
        int plus = bandage[2]; //추가 회복
        int maxHealth = health;
        int currentHealth = health;
        int currentTime = 0;
        int row = 0;
        int sequence = 0;

        while (currentTime < attacks[attacks.length-1][0]){

            currentTime++;

            if(currentTime == attacks[row][0]){
                sequence = 0;
                currentHealth -= attacks[row][1];
                if (currentHealth <= 0) {
                    return -1;
                }
                row++;
            }
            else {
                sequence++;
                currentHealth += heal;

                if(sequence == time){
                    currentHealth += plus;
                    sequence = 0;
                }

                if(currentHealth > maxHealth){
                    currentHealth = maxHealth;
                }
            }
        }

        return currentHealth;
    }
}

/**
 * 더 개선된 코드
 */
//class Solution {
//    public int solution(int[] bandage, int health, int[][] attacks) {
//        int t = bandage[0];  // 붕대 감기 시전 시간
//        int x = bandage[1];  // 초당 회복량
//        int y = bandage[2];  // 추가 회복량
//
//        int maxHealth = health;
//        int currentHealth = health;
//
//        int attackIndex = 0;
//        int consecutive = 0;
//
//        int lastAttackTime = attacks[attacks.length - 1][0];
//
//        for (int time = 1; time <= lastAttackTime; time++) {
//            // 공격 시간인지 체크
//            if (attackIndex < attacks.length && attacks[attackIndex][0] == time) {
//                currentHealth -= attacks[attackIndex][1];
//                if (currentHealth <= 0) return -1; // 죽었으면 바로 종료
//                consecutive = 0;                   // 연속 성공 초기화
//                attackIndex++;
//            } else {
//                consecutive++;
//                currentHealth += x;               // 초당 회복
//
//                if (consecutive == t) {
//                    currentHealth += y;           // 추가 회복
//                    consecutive = 0;
//                }
//
//                if (currentHealth > maxHealth) currentHealth = maxHealth; // 최대 체력 제한
//            }
//        }
//
//        return currentHealth;
//    }
//}
