package menu.domain.category;

import java.util.List;

public class Asian extends Category {

    private static final int number = 4;
    private static final List<String> menus = List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥",
            "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");

    private Asian(final int number, final List<String> menus) {
        super(number, menus);
    }

    protected static Asian create() {
        return new Asian(number, menus);
    }
}
