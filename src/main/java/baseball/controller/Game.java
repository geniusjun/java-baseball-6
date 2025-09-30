package baseball.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    public String computerInput;
    public String playerInput;
    public String reStart;
    public boolean isCorrect;
    public int countStrike;
    public int countBall;

    public String play(){
        Init();
        for(int i = 0; i < 3; i++) {
            computerInput += Randoms.pickNumberInRange(1,9);
        }
        System.out.println("computerInput = " + computerInput);
        while (!isCorrect){
            System.out.print("숫자를 입력해주세요 : ");
            playerInput = Console.readLine();
            Validate();
            Check();

        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        reStart = Console.readLine();
        if(reStart.equals("1")){
            return "1";
        }else if(reStart.equals("2")){
            return "2";
        }else{
            throw new IllegalArgumentException();
        }
    }

    private void Check(){
        countStrike = 0;
        countBall = 0;
        for(int i = 0; i < 3; i++){ // 볼 몇개 스트라이크 몇개 인지
            if(playerInput.charAt(i) == computerInput.charAt(i)){ // 스트라이크인지 먼저 확인
                countStrike++;
                continue;
            }
            for (int j = 0; j < 3; j++) {
                if(playerInput.charAt(i) == computerInput.charAt(j)){ // 스트라이크면 위에서 걸러지고 볼 체크
                    countBall++;
                    break;
                }
            }
        }

        if(countStrike == 0 && countBall == 0){ // 하나도 안맞은 경우
            System.out.println("낫싱");
            return;
        }
        if(countStrike == 3){
            isCorrect = true; // 맞췄는지 알려주는 플래그 변수 true바꿔놓고 처리는 while문 밖에서
            System.out.println(countStrike + "스트라이크");
            return;
        }

        if (countStrike > 0 && countBall > 0){
            System.out.println(countBall + "볼 " + countStrike + "스트라이크");
        } else if (countBall > 0) {
            System.out.println(countBall + "볼");
        } else if (countStrike > 0) {
            System.out.println(countStrike + "스트라이크");
        }
    }

    public void Validate(){
        if(playerInput.length() != 3){
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < 3; i++){
            if(playerInput.charAt(i) > 0 && playerInput.charAt(i) < 10){
                throw new IllegalArgumentException();
            }
        }
    }

    public void Init(){
        computerInput = "";
        playerInput = "";
        isCorrect = false;
        countBall = 0;
        countStrike = 0;
    }
}

