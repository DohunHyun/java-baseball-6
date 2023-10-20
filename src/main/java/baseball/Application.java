package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        int endSign = 1; // 게임 지속 : 1, 게임 종료 : 2
        boolean isCorrect = false;

        // 게임 진행. 문제를 맞춰도 다시 시작 가능.
        while(endSign == 1) {
            // 랜덤 숫자 생성.
            int[] randomNumberArray = new int[3];
            boolean[] checkArray = new boolean[9];
            for(int i=0; i<randomNumberArray.length; i++) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                while(checkArray[randomNumber-1]) {
                    randomNumber = Randoms.pickNumberInRange(1, 9);
                }
                checkArray[randomNumber-1] = true;
                randomNumberArray[i] = randomNumber;
            }

            // 숫자 맞추기 게임 시작
            while(!isCorrect) {
                System.out.print("숫자를 입력해주세요. : ");
                // 입력 : 1~9 숫자 중 3가지로 이루어진 세자리 숫자.
                // 입력 시 같은 숫자는 사용 금지.
                // 입력 시 숫자만 입력 가능.
                String input = Console.readLine();
                String[] inputArray = input.split("");
                int[] inputToIntArray = new int[3];
                boolean[] checkList = new boolean[9];

                for (int i=0; i<inputArray.length; i++) {
                    inputToIntArray[i] = Integer.parseInt(inputArray[i]); // 입력 값이 숫자인지 체크
                    if(!checkList[inputToIntArray[i]-1]) {
                        checkList[inputToIntArray[i]-1] = true;
                    } else { // 중복된 숫자 체크.
                        throw new IllegalArgumentException();
                    }
                }


                // 입력 후 판단.
                // 구현 필요.

                // 정답이라면 while문 break.
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int inputInt = Integer.parseInt(Console.readLine());
                if(inputInt == 2) { // 게임 종료
                    endSign = 2;
                } else { // 이번 게임은 끝. 다음 게임 다시 시작.
                    endSign = 1;
                }
                isCorrect = true;
            }

        }
    }
}
