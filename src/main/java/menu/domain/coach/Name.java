package menu.domain.coach;

import java.util.Objects;

public class Name {

    private static final int NAME_LOWER_BOUND = 2;
    private static final int NAME_UPPER_BOUND = 4;

    private final String value;

    public Name(final String value) {
        final String trimmed = value.trim();

        validate(trimmed);
        this.value = trimmed;
    }

    private void validate(final String value) {
        if (value.length() < NAME_LOWER_BOUND || value.length() > NAME_UPPER_BOUND) {
            throw new IllegalArgumentException("[ERROR] 이름은 2 ~ 4글자만 가능합니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        final Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
