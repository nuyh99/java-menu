package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coach {

    private final Name name;
    private BannedMenus bannedMenus;
    private final EatenMenus eatenMenus;

    private Coach(final Name name, final BannedMenus bannedMenus, final EatenMenus eatenMenus) {
        this.name = name;
        this.bannedMenus = bannedMenus;
        this.eatenMenus = eatenMenus;
    }

    public static Coach from(final String name) {
        final BannedMenus bannedMenus = new BannedMenus(new ArrayList<>());
        final EatenMenus eatenMenus = new EatenMenus(new ArrayList<>());
        return new Coach(new Name(name), bannedMenus, eatenMenus);
    }

    public String getName() {
        return name.getValue();
    }

    public boolean isNameEquals(final Name name) {
        return Objects.equals(this.name, name);
    }

    public void updateBannedMenus(final List<String> menus) {
        this.bannedMenus = new BannedMenus(menus);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Coach)) return false;
        final Coach coach = (Coach) o;
        return Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
