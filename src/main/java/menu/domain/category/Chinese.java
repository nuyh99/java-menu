package menu.domain.category;

import java.util.List;

public class Chinese extends Category {

    private static final int number = 3;
    private static final List<String> menus = List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부",
            "탕수육", "토마토 달걀볶음", "고추잡채");

    private Chinese(final int number, final List<String> menus) {
        super(number, menus);
    }

    protected static Chinese create() {
        return new Chinese(number, menus);
    }
}
