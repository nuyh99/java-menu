package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class RandomMenuGenerator implements RandomNumberGenerator {
    private static final int CATEGORY_LOWER_BOUND = 1;
    private static final int CATEGORY_UPPER_BOUND = 5;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(CATEGORY_LOWER_BOUND, CATEGORY_UPPER_BOUND);
    }

    public String getMenuFromCategory(int category) {
        List<String> menus = Arrays.stream(MenuData.values())
                .filter(entity -> entity.category() == category)
                .findAny()
                .map(MenuData::menus)
                .orElse(null);

        if (menus == null) return "";
        return Randoms.shuffle(menus).get(0);
    }
}