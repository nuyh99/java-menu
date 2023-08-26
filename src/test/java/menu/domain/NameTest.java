package menu.domain;

import menu.domain.coach.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NameTest {

    @DisplayName("앞 뒤 공백을 제외한 2 ~ 4글자로 생성할 수 있다")
    @ValueSource(strings = {"이름", "이름이름", "    이름  ", "  이름이름  "})
    @ParameterizedTest
    void construct(final String name) {
        assertDoesNotThrow(() -> new Name(name));
    }

    @DisplayName("앞 뒤 공백을 제외한 2 ~ 4글자가 아니면 예외가 발생한다")
    @ValueSource(strings = {"이", "", "      ", "  이름이이름  "})
    @ParameterizedTest
    void construct_fail(final String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 2 ~ 4글자만 가능합니다.");
    }

}
