package menu.domain.menu;

import java.util.ArrayList;
import java.util.List;

public final class UneatableMenus extends Menus {


  private UneatableMenus(final List<Menu> menus) {
    super(menus);
  }

  public static UneatableMenus empty() {
    return new UneatableMenus(new ArrayList<>());
  }

}
