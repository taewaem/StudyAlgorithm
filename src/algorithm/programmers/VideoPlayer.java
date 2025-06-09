package algorithm.programmers;

public class VideoPlayer {
    public static void main(String[] args) {
        // 테스트 케이스 1
        String video_len1 = "34:33";
        String pos1 = "13:00";
        String op_start1 = "00:55";
        String op_end1 = "02:55";
        String[] commands1 = {"next", "prev"};
        //asnwer -> 13:00

        // 테스트 케이스 2
        String video_len2 = "10:55";
        String pos2 = "00:05";
        String op_start2 = "00:15";
        String op_end2 = "06:55";
        String[] commands2 = {"prev", "next", "next"};
        //asnwer -> 6:55

        // 테스트 케이스 3
        String video_len3 = "07:22";
        String pos3 = "04:05";
        String op_start3 = "00:15";
        String op_end3 = "04:07";
        String[] commands3 = {"next"};
        //answer -> 4:17

        System.out.println(solution(video_len3, pos3, op_start3, op_end3, commands3));
    }

    /**
     * 내가 작성한 코드
     */
    private static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        String[] videoSplit = video_len.split(":");
        int video_lenInt = Integer.parseInt(videoSplit[0]) * 60 + Integer.parseInt(videoSplit[1]);

        String[] posSplit = pos.split(":");
        int posInt = Integer.parseInt(posSplit[0]) * 60 + Integer.parseInt(posSplit[1]);

        String[] op_startSplit = op_start.split(":");
        int op_startInt = Integer.parseInt(op_startSplit[0]) * 60 + Integer.parseInt(op_startSplit[1]);

        String[] op_endSplit = op_end.split(":");
        int op_endInt = Integer.parseInt(op_endSplit[0]) * 60 + Integer.parseInt(op_endSplit[1]);

        for (int i = 0; i < commands.length; i++) {
            if (op_startInt <= posInt && posInt <= op_endInt) {
                posInt = op_endInt;
            }
            if (commands[i].equals("prev")) {
                posInt -= 10;
                if (posInt < 0) {
                    posInt = 0;
                }
            } else if (commands[i].equals("next")) {
                posInt += 10;
                if (posInt > video_lenInt) {
                    posInt = video_lenInt; 
                }
            }
        }

        //계산이 끝나고 들어갔을 시
        if (op_startInt <= posInt && posInt <= op_endInt) {
            posInt = op_endInt;
        }

        int minute = posInt / 60;
        int second = posInt % 60;
        String minuteString = "";
        String secondString = "";
        if (minute < 10) {
             minuteString = "0" + String.valueOf(minute);
        }
        else{
            minuteString = String.valueOf(minute);
        }

        if (second < 10) {
            secondString = "0" + String.valueOf(second);
        }
        else
            secondString = String.valueOf(second);

        answer = minuteString + ":" + secondString;

        return answer;
    }
}



/**
 * 더 개선된 코드
 * GPT를 이용한 코드
 */

//    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
//        int videoLen = toSeconds(video_len);
//        int position = toSeconds(pos);
//        int opStart = toSeconds(op_start);
//        int opEnd = toSeconds(op_end);
//        int interval = 10;
//
//        for (String command : commands) {
//            // 검은 화면 영역 진입 시, 강제로 opEnd로 이동
//            if (position >= opStart && position <= opEnd) {
//                position = opEnd;
//            }
//
//            // 명령어 처리
//            if (command.equals("prev")) {
//                position = Math.max(0, position - interval);
//            } else if (command.equals("next")) {
//                position = Math.min(videoLen, position + interval);
//            }
//        }
//
//        // 마지막 위치가 검은 화면이면 다시 opEnd로 밀어냄
//        if (position >= opStart && position <= opEnd) {
//            position = opEnd;
//        }
//
//        return toTimeString(position);
//    }
//
//    // "MM:SS" → 초로 변환
//    private int toSeconds(String time) {
//        String[] parts = time.split(":");
//        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
//    }
//
//    // 초 → "MM:SS"로 변환
//    private String toTimeString(int totalSeconds) {
//        int minutes = totalSeconds / 60;
//        int seconds = totalSeconds % 60;
//        return String.format("%02d:%02d", minutes, seconds);
//    }
