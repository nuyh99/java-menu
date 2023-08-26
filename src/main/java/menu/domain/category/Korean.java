package menu.domain.category;

import java.util.List;

public class Korean extends Category {

    private static final int number = 2;
    private static final List<String> menus = List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥",
            "칼국수", "불고기", "떡볶이", "제육볶음");

    private Korean(final int number, final List<String> menus) {
        super(number, menus);
    }

    public static Korean create() {
        return new Korean(number, menus);
    }
}
