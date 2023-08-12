package menu.view;

import java.util.List;

final class InputValidator {
    static void validateCoachesNumber(List<String> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException("[ERROR] 코치의 수는 2명 ~ 5명 사이만 가능합니다.");
        }
    }

    static void validateInvalidInput(String word) {
        if (word.matches("[a-z0-9]")
                || word.matches("[ \\[\\]{}()<>?|`~!@#$%^&*-_+=.;:\"']")) {
            throw new IllegalArgumentException("[ERROR] 한글만 입력해주세요");
        }
    }
}
