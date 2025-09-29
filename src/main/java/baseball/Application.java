package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> list = Randoms.shuffle(Arrays.asList(1,2,3,4,5));
        System.out.println(list);

    }
}
