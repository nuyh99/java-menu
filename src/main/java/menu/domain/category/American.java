package menu.domain.category;

import java.util.List;

public class American extends Category {

    private static final int number = 5;
    private static final List<String> menus = List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트",
            "바게트", "스파게티", "피자", "파니니");

    private American(final int number, final List<String> menus) {
        super(number, menus);
    }

    public static American create() {
        return new American(number, menus);
    }
}
