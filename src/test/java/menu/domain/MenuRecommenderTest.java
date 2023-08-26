package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MenuRecommenderTest {

    @Test
    @DisplayName("코치는 2 ~ 5명으로 생성할 수 있다")
    void construct() {
        //given
        final List<String> names = List.of("이름1", "이름2");

        //when, then
        assertDoesNotThrow(() -> MenuRecommender.of(names));
    }

    @Test
    @DisplayName("코치가 1명 이하라면 예외가 발생한다")
    void construct_fail1() {
        //given
        final List<String> names = List.of("이름1");

        //when, then
        assertThatThrownBy(() -> MenuRecommender.of(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 코치는 2 ~ 5 명이여야 합니다.");
    }

    @Test
    @DisplayName("코치가 6명 이상이라면 예외가 발생한다")
    void construct_fail2() {
        //given
        final List<String> names = List.of("이름1", "이름2", "이름3", "이름4", "이름5", "이름6");

        //when, then
        assertThatThrownBy(() -> MenuRecommender.of(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 코치는 2 ~ 5 명이여야 합니다.");
    }

    @Test
    @DisplayName("중복된 이름의 코치가 존재하면 예외가 발생한다")
    void construct_fail3() {
        //given
        final List<String> names = List.of("이름1", "이름1", "이름1", "이름1", "이름1");

        //when, then
        assertThatThrownBy(() -> MenuRecommender.of(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 이름의 코치는 존재할 수 없습니다.");
    }

    @Test
    @DisplayName("전체 코치의 이름을 얻을 수 있다")
    void getAllNames() {
        //given
        final List<String> names = List.of("이름1", "이름2");
        final MenuRecommender menuRecommender = MenuRecommender.of(names);

        //when
        final List<String> allCoachNames = menuRecommender.getAllCoachNames();

        //then
        assertThat(allCoachNames).containsExactlyElementsOf(names);
    }

    @Test
    @DisplayName("못 먹는 메뉴를 업데이트 한다")
    void updateBannedMenusTo() {
        //given
        final MenuRecommender menuRecommender = MenuRecommender.of(List.of("강아지", "고양이"));

        //when, then
        assertDoesNotThrow(() -> menuRecommender.updateBannedMenusTo("강아지", List.of("라면")));
    }

    @Test
    @DisplayName("못 먹는 메뉴를 업데이트 할 때 존재하지 않는 코치라면 예외가 발생한다")
    void updateBannedMenusTo_fail() {
        //given
        final MenuRecommender menuRecommender = MenuRecommender.of(List.of("강아지", "고양이"));
        final String targetCoachName = "노트북";

        //when, then
        assertThatThrownBy(() -> menuRecommender.updateBannedMenusTo(targetCoachName, List.of("라면")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 존재하는 코치가 아닙니다.");
    }
}
