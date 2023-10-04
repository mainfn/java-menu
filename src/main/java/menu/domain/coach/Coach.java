package menu.domain.coach;

import menu.domain.menu.RecommendedMenus;
import menu.domain.menu.UneatableMenus;

public final class Coach {

  private final String name;

  private final UneatableMenus uneatableMenus;

  private final RecommendedMenus recommendedMenus;

  private Coach(
      final String name,
      final UneatableMenus uneatableMenus,
      final RecommendedMenus recommendedMenus
  ) {
    validateCoachName(name);
    this.name = name;
    this.uneatableMenus = uneatableMenus;
    this.recommendedMenus = recommendedMenus;
  }

  public static Coach of(final String name) {
    return new Coach(
        name,
        UneatableMenus.empty(),
        RecommendedMenus.empty()
    );
  }

  private void validateCoachName(final String coachName) {
    if (coachName == null || coachName.length() < 2 || coachName.length() > 4) {
      throw new IllegalArgumentException("Coach 이름은 최소 2글자, 최대 4글자까지 가능합니다.");
    }
  }


}
