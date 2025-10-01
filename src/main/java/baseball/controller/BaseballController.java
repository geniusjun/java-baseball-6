package baseball.controller;

import baseball.service.ComputerService;

public class BaseballController {

    private final ComputerService computerService;

    public BaseballController(ComputerService computerService) {
        this.computerService = computerService;
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 게임 시작 - 컴퓨터 숫자 초기화 및 사용자 입력 받기
    public void start(){
        computerService.start();
    }

    // 사용자 입력 값에 대해 정답일 때 까지 볼, 스트라이크 카운팅 반복
    public void count(){
        computerService.count();
    }

}

