package menu.domain.coach;

import menu.domain.menu.Menu;
import menu.domain.menu.RecommendedMenus;
import menu.domain.menu.UneatableMenus;

public final class Coach {

  private final String name;

  private final UneatableMenus uneatableMenus;

  private final RecommendedMenus recommendedMenus = RecommendedMenus.empty();

  private Coach(
      final String name,
      final UneatableMenus uneatableMenus
  ) {
    this.name = name;
    this.uneatableMenus = uneatableMenus;
  }

  public static Coach of(
      final String name,
      final UneatableMenus uneatableMenus
  ) {
    return new Coach(name, uneatableMenus);
  }

  public void addRecommendedMenu(final Menu menu) {
    recommendedMenus.add(menu);
  }

  public boolean canRecommend(final Menu menu) {
    return uneatableMenus.isEatable(menu) && recommendedMenus.isNotDuplicate(menu);
  }

  @Override
  public String toString() {
    return String.format("[ %s | %s ]",
        name,
        recommendedMenus
    );
  }
}