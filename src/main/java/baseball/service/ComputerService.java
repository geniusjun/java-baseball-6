package baseball.service;

import baseball.Repository.ComputerRepository;
import baseball.Repository.PlayerRepository;
import baseball.config.BaseballConfig;
import baseball.validation.BaseballValidate;
import camp.nextstep.edu.missionutils.Randoms;


public class ComputerService {

    private final ComputerRepository computerRepository = BaseballConfig.getInstance().getComputerRepository();
    private final PlayerRepository playerRepository = BaseballConfig.getInstance().getPlayerRepository();

    // 검증 로직 의존성을 여기다가 추가하는 게 맞을까? -> 이쁘진 않지만 서비스에서 추가하므로!
    BaseballValidate baseballValidate = new BaseballValidate();

    public void start(){
        System.out.println("숫자를 입력해주세요 : ");
        computerInit();
        playerService.playerInput(player);
        baseballValidate.validateStartInput(player.getInput());
    }

    public void reStart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        playerService.playerInput(player);
        if(baseballValidate.validateReStartInput(player.getInput())){
            start();
        }else{
            throw new IllegalArgumentException();
        }

    }

    public void computerInit(){
        computer.setGoalNum("");
        for(int i = 0; i < 3; i++) {
            computer.setGoalNum(computer.getGoalNum() + Randoms.pickNumberInRange(1,9));
        }
    }

    public void count(){

        while(!baseballValidate.isCorrect(computer.getStrike())){
            computer.setStrike(0);
            computer.setBall(0);

            for(int i = 0; i < 3; i++){ // 볼 몇개 스트라이크 몇개 인지
                if(player.getInput().charAt(i) == computer.getGoalNum().charAt(i)){ // 스트라이크인지 먼저 확인
                    computer.setStrikePlus();
                    continue;
                }
                for (int j = 0; j < 3; j++) {
                    if(player.getInput().charAt(i) == computer.getGoalNum().charAt(j)){ // 스트라이크면 위에서 걸러지고 볼 체크
                        computer.setBallPlus();
                        break;
                    }
                }
            }
            printResult();
        }
        reStart();
    }

    public void printResult(){
        if(computer.getStrike() == 0 && computer.getBall() == 0){ // 하나도 안맞은 경우
            System.out.println("낫싱");
            return;
        }
        if(computer.getStrike() == 3){
            System.out.println(computer.getStrike() + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        if (computer.getStrike() > 0 && computer.getBall() > 0){
            System.out.println(computer.getBall() + "볼 " + computer.getStrike() + "스트라이크");
        } else if (computer.getBall() > 0) {
            System.out.println(computer.getBall() + "볼");
        } else if (computer.getStrike() > 0) {
            System.out.println(computer.getStrike() + "스트라이크");
        }
    }

}
