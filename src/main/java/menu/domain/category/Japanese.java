package menu.domain.category;

import java.util.List;

public class Japanese extends Category {

    private static final int number = 1;
    private static final List<String> menus = List.of("규동", "우동", "미소시루", "스시",
            "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼");

    private Japanese(final int number, final List<String> menus) {
        super(number, menus);
    }

    protected static Japanese create() {
        return new Japanese(number, menus);
    }
}
