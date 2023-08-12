package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoachTest {
    @Test
    @DisplayName("이름이 5글자면 예외가 발생한다.")
    void testOverNameLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Coach("가나다라마", List.of("탕수육"));
        });
    }

    @Test
    @DisplayName("이름이 1글자면 예외가 발생한다.")
    void testUnderNameLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Coach("가", List.of("탕수육"));
        });
    }

    @Test
    @DisplayName("못먹는 음식이 3가지면 예외가 발생한다.")
    void testOverNumberBanMenus() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Coach("가나", List.of("탕수육", "규동", "김밥"));
        });
    }

    @Test
    @DisplayName("못먹는 음식이 메뉴로 들어오면 False")
    void isPossibleMenu() {
        assertThat(new Coach("가나", List.of("탕수육", "김밥")).isPossibleMenu("김밥")).isFalse();
    }
}