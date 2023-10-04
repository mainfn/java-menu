package menu.domain.coach;

import menu.domain.menu.RecommendedMenus;
import menu.domain.menu.UneatableMenus;

public final class CoachRecommending extends Coach {

  private CoachRecommending(
      final String name,
      final UneatableMenus uneatableMenus,
      final RecommendedMenus recommendedMenus
  ) {
    super(name, uneatableMenus, recommendedMenus);
  }

  public static Coach of(final String name) {
    return new CoachRecommending(
        name,
        UneatableMenus.empty(),
        RecommendedMenus.empty()
    );
  }

  public CoachCompleted intoCompleted() {
    return new CoachCompleted(name, uneatableMenus, recommendedMenus);
  }

}
