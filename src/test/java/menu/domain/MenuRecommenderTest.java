package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
}
