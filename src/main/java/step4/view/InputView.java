package step4.view;

import step4.dto.InputDto;
import step4.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇회 인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static InputDto input() {
        System.out.println(CAR_NAME_MESSAGE);
        String inputCarNames = scanner.next();

        // 이런식으로 input 메소드에서 하는 일을 다른 메소드로 뺐는데 이러면 메소드 끼리 의존관계가 있어서 좋지 않아지는 걸까요? 아니면 이렇게 분리하는게 자연스러운 걸까요?? ㅠㅠ
        String[] carNameList = inputValidator(inputCarNames);

        System.out.println(TRY_COUNT_MESSAGE);
        int tryCount = scanner.nextInt();
        InputValidator.checkTryCountIsMinus(tryCount);

        System.out.println();
        System.out.println(RESULT_MESSAGE);

        return new InputDto(new ArrayList<>(Arrays.asList(carNameList)), tryCount);
    }

    private static String[] inputValidator(String inputCarNames) {
        String[] carNameList = inputCarNames.split(",");

        for (String carName: carNameList) {
            InputValidator.checkCarName(carName);
        }
        return carNameList;
    }
}
