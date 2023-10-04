package menu.domain.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class RecommendedMenus extends Menus {

  private RecommendedMenus(final List<Menu> menus) {
    super(menus);
  }

  public static RecommendedMenus empty() {
    return new RecommendedMenus(new ArrayList<>());
  }

  public void add(final Menu menu) {
    menus.add(menu);
  }

  public boolean canRecommend(final Menu menu) {
    return menus.stream().noneMatch(m -> menu == m);
  }

  public List<Menu> getRecommendedMenus() {
    return menus;
  }

  @Override
  public String toString() {
    return menus.stream()
        .map(Menu::getName)
        .collect(Collectors.joining(" | "));
  }
}
