package baseball;


import baseball.controller.Game;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("숫자 야구 게임을 시작합니다.");
        if(game.play().equals("1")){
         game.play();
        }


    }
}
