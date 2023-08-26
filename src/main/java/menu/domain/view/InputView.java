package menu.domain.view;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String NAME_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(new InputStreamReader(System.in));

    private InputView() {
    }

    public static List<String> readNames() {
        final String input = scanner.nextLine();
        return List.of(input.split(NAME_DELIMITER));
    }

    public static List<String> readBannedMenusFor(final String coachName) {
        System.out.println(coachName + "꺼 못 먹는 메뉴는 ? ");

        final String input = scanner.nextLine();
        return List.of(input.split(NAME_DELIMITER));
    }
}
