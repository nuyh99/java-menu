package menu.domain;

import menu.domain.category.Category;
import menu.domain.coach.Coach;
import menu.domain.coach.Name;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRecommender {

    private final List<Coach> coaches;
    private final List<Category> categoryPerDay;

    private MenuRecommender(final List<Coach> coaches, final List<Category> categoryPerDay) {
        validate(coaches);
        this.coaches = coaches;
        this.categoryPerDay = categoryPerDay;
    }

    private void validate(final List<Coach> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 2 ~ 5 명이여야 합니다.");
        }

        final long distinctCoachesSize = coaches.stream().distinct().count();
        if (coaches.size() != distinctCoachesSize) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름의 코치는 존재할 수 없습니다.");
        }
    }

    public static MenuRecommender of(final List<String> names) {
        final List<Coach> coaches = names.stream()
                .map(Coach::from)
                .collect(Collectors.toList());

        return new MenuRecommender(coaches, new ArrayList<>());
    }

    public List<String> getAllCoachNames() {
        return coaches.stream()
                .map(Coach::getName)
                .collect(Collectors.toList());
    }

    public void updateBannedMenusTo(final String coachName, final List<String> bannedMenus) {
        final Name name = new Name(coachName);
        final Coach coach = findCoachByName(name);

        coach.updateBannedMenus(bannedMenus);
    }

    private Coach findCoachByName(final Name name) {
        return coaches.stream()
                .filter(coach -> coach.isNameEquals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하는 코치가 아닙니다."));
    }
}
