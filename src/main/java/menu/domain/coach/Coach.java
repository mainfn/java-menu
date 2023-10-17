package menu.domain.coach;

import menu.domain.menu.RecommendedMenus;
import menu.domain.menu.UneatableMenus;

public final class Coach {

  private final String name;

  private final UneatableMenus uneatableMenus = UneatableMenus.empty();

  private final RecommendedMenus recommendedMenus = RecommendedMenus.empty();

  private Coach(final String name) {
    this.name = name;
  }

  public static Coach of(final String name) {
    return new Coach(name);
  }

}
