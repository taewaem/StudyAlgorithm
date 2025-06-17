package algorithm;

public class Reactor {
    public static void main(String[] args) {
        //각 리엑터는 매 초 에너지 2만큼 소요
        //에너지를 소모하 수 있는 경우, 좌우에 있는 리엑테에게 1의 에너지 전달
        //에너지가 2 미만 이면 행동X
        //좌우 양 끝에 있는 리엑터는 한쪽으로만 에너지 전달, but 에너지 2소모
        //리액터가 전달받은 에너지는 같은초의 종료 시점에 반영된다.
        //양끝 정렬 X, 일렬로만 존재, 모든 리엑터가 에너지를 소모하지 안헥 되는 시간 구하기
        //입력은 정수 배열 4<=N<=1000
        //출력 리엑터가 에너지를 전달하지 않는 최초의 시간

        //각 리액터가 가진 수
        int n = 10;
        int time = 0;
        int[] energy = new int[n];

        for (int i = 0; i < energy.length; i++) {
            energy[i] = n;
        }

        while (true) {
            //동시 처리를 위한 변수 생성
            boolean changed = false;

            int[] next = new int[n];

            for (int i = 0; i < n; i++) {
                if (energy[i] < 2){
                    continue;
                }
                changed = true;
                if (i == 0) {
                    energy[i] -= 2;
                    next[i + 1] += 1;
                } else if (i == n - 1) {
                    energy[i] -= 2;
                    next[i - 1] += 1;
                } else {
                    energy[i] -= 2;
                    next[i + 1] += 1;
                    next[i - 1] -= 1;
                }
            }

            if (changed == false) {
                break;
            }
            for (int i = 0; i < n; i++) {
                energy[i] += next[i];
            }
            time++;
        }

        System.out.println(time);

    }
}
