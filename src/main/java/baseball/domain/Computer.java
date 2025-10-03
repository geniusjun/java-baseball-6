package baseball.domain;

import baseball.global.util.RandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    List<Integer> numbers;

    public Computer(List<Integer> numbers) {
        this.numbers = new ArrayList<>();
    }

    public void generate() {
        numbers = RandomNumberGenerator.generateRandomNumber();
    }

    
}
