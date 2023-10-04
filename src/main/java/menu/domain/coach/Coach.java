package menu.domain.coach;

import menu.domain.category.Category;
import menu.domain.menu.Menu;
import menu.domain.menu.RecommendedMenus;
import menu.domain.menu.UneatableMenus;
import menu.util.RecommendedMenuPicker;

public abstract class Coach {

  protected final String name;

  protected final UneatableMenus uneatableMenus;

  protected final RecommendedMenus recommendedMenus;

  protected Coach(
      final String name,
      final UneatableMenus uneatableMenus,
      final RecommendedMenus recommendedMenus
  ) {
    validateCoachName(name);
    this.name = name;
    this.uneatableMenus = uneatableMenus;
    this.recommendedMenus = recommendedMenus;
  }


  private void validateCoachName(final String coachName) {
    if (coachName == null || coachName.length() < 2 || coachName.length() > 4) {
      throw new IllegalArgumentException("Coach 이름은 최소 2글자, 최대 4글자까지 가능합니다.");
    }
  }


}
