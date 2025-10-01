package baseball.controller;

import baseball.config.BaseballConfig;
import baseball.service.ComputerService;
import baseball.service.PlayerService;

public class BaseballController {

    private final ComputerService computerService = BaseballConfig.getInstance().getComputerService();

    // 게임 시작 - 컴퓨터 숫자 초기화 및 사용자 입력 받기
    public void start(){
        computerService.start();
    }

    // 사용자 입력 값에 대해 정답일 때 까지 볼, 스트라이크 카운팅 반복
    public void count(){
        computerService.count();
    }

}

