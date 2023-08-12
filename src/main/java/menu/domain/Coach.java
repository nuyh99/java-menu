package menu.domain;

import java.util.List;

public final class Coach {
    private static final int BAN_SIZE_UPPER_BOUND = 2;
    private static final int BAN_SIZE_LOWER_BOUND = 0;
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;
    private String name;
    private List<MenuData> eatenMenus;
    private List<String> banMenus;

    private Coach() {
    }

    ;

    public Coach(String name, List<MenuData> eatenMenus, List<String> banMenus) {
        this.name = name;
        this.eatenMenus = eatenMenus;
        this.banMenus = banMenus;

        validateNameLength(name);
        validateBanMenusNumber(banMenus);
    }

    private void validateBanMenusNumber(List<String> banMenus) {
        if (banMenus.size() < BAN_SIZE_LOWER_BOUND || banMenus.size() > BAN_SIZE_UPPER_BOUND)
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴는 0~2개까지만 가능합니다.");
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException("[ERROR] 이름은 2~4글자 사이로 입력해주세요.");
    }


}
