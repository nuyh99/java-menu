package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class InputView {
    public List<String> readCoachesName() {
        String input = Console.readLine();
        InputValidator.validateInvalidInput(input);

        List<String> coaches = splitInput(input);

        InputValidator.validateCoachesNumber(coaches);

        return coaches;
    }

    public List<String> readBanMenus() {
        String input = Console.readLine();
        InputValidator.validateInvalidInput(input);

        if (input.isEmpty()) return List.of("");
        return splitInput(input);

    }

    private List<String> splitInput(String input) {
        String[] split = input.split(",");

        return Arrays
                .stream(split)
                .collect(Collectors.toList());
    }
}
