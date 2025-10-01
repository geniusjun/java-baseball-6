package baseball.service;

import baseball.Repository.ComputerRepository;
import baseball.Repository.PlayerRepository;
import baseball.validation.BaseballValidate;
import camp.nextstep.edu.missionutils.Randoms;


public class ComputerService {

    private final PlayerService playerService;
    private final ComputerRepository computerRepository;
    private final PlayerRepository playerRepository;
    private final BaseballValidate baseballValidate;

    public ComputerService(PlayerService playerService, ComputerRepository computerRepository, PlayerRepository playerRepository, BaseballValidate baseballValidate) {
        this.playerService = playerService;
        this.computerRepository = computerRepository;
        this.playerRepository = playerRepository;
        this.baseballValidate = baseballValidate;
    }

    public void start(){
        computerInit();
    }

    public void reStart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        playerService.playerInput(playerRepository.getPlayer());
        if(baseballValidate.validateReStartInput(playerRepository.getPlayer().getInput())){
            computerRepository.getComputer().setStrike(0);
            computerRepository.getComputer().setBall(0);
            start();
            count();
        }

    }

    public void computerInit(){
        computerRepository.getComputer().setGoalNum("");
        for(int i = 0; i < 3; i++) {
            computerRepository.getComputer()
                                .setGoalNum(computerRepository.getComputer().getGoalNum()
                                        + Randoms.pickNumberInRange(1,9));
        }
    }

    public void count(){

        while(!baseballValidate.isCorrect(computerRepository.getComputer().getStrike())){
            computerRepository.getComputer().setStrike(0);
            computerRepository.getComputer().setBall(0);

            System.out.print("숫자를 입력해주세요 : ");

            playerService.playerInput(playerRepository.getPlayer());
            baseballValidate.validateStartInput(playerRepository.getPlayer().getInput());

            for(int i = 0; i < 3; i++){ // 볼 몇개 스트라이크 몇개 인지
                if(playerRepository.getPlayer().getInput().charAt(i) == computerRepository.getComputer().getGoalNum().charAt(i)){ // 스트라이크인지 먼저 확인
                    computerRepository.getComputer().setStrikePlus();
                    continue;
                }
                for (int j = 0; j < 3; j++) {
                    if(playerRepository.getPlayer().getInput().charAt(i) == computerRepository.getComputer().getGoalNum().charAt(j)){ // 스트라이크면 위에서 걸러지고 볼 체크
                        computerRepository.getComputer().setBallPlus();
                        break;
                    }
                }
            }
            printResult();
        }
        reStart();
    }

    public void printResult(){
        if(computerRepository.getComputer().getStrike() == 0 && computerRepository.getComputer().getBall() == 0){ // 하나도 안맞은 경우
            System.out.println("낫싱");
            return;
        }
        if(computerRepository.getComputer().getStrike() == 3){
            System.out.println(computerRepository.getComputer().getStrike() + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        if (computerRepository.getComputer().getStrike() > 0 && computerRepository.getComputer().getBall() > 0){
            System.out.println(computerRepository.getComputer().getBall() + "볼 " + computerRepository.getComputer().getStrike() + "스트라이크");
        } else if (computerRepository.getComputer().getBall() > 0) {
            System.out.println(computerRepository.getComputer().getBall() + "볼");
        } else if (computerRepository.getComputer().getStrike() > 0) {
            System.out.println(computerRepository.getComputer().getStrike() + "스트라이크");
        }
    }

}
