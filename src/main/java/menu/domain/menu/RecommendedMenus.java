package menu.domain.menu;

import java.util.ArrayList;
import java.util.List;

public final class RecommendedMenus extends Menus {

  private RecommendedMenus(final List<Menu> menus) {
    super(menus);
  }

  public static RecommendedMenus empty() {
    return new RecommendedMenus(new ArrayList<>());
  }
}
