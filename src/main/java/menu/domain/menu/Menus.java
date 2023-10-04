package menu.domain.menu;

import java.util.List;

public class Menus {

  protected final List<Menu> menus;

  protected Menus(final List<Menu> menus) {
    this.menus = menus;
  }

  protected List<Menu> getMenus() {
    return menus;
  }
}
