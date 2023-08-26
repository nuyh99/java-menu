package menu.domain;

import java.util.ArrayList;

public class Coach {

    private final Name name;
    private final BannedMenus bannedMenus;
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
}
