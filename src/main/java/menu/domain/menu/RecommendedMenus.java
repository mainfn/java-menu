package menu.domain.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class RecommendedMenus {

  private final List<Menu> menus;

  private RecommendedMenus(final List<Menu> menus) {
    this.menus = menus;
  }

  public static RecommendedMenus empty() {
    return new RecommendedMenus(new ArrayList<>());
  }

  public void add(final Menu menu) {
    menus.add(menu);
  }

  public boolean isNotDuplicate(final Menu menu) {
    return menus.stream()
        .noneMatch(m -> m == menu);
  }

  @Override
  public String toString() {
    return menus.stream()
        .map(Menu::getName)
        .collect(Collectors.joining(" | "));
  }
}
