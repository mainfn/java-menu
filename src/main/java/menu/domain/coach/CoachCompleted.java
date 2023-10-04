package menu.domain.coach;

import java.util.stream.Collectors;
import menu.domain.menu.Menu;
import menu.domain.menu.RecommendedMenus;
import menu.domain.menu.UneatableMenus;

public final class CoachCompleted extends Coach {

  public CoachCompleted(
      final String name,
      final UneatableMenus uneatableMenus,
      final RecommendedMenus recommendedMenus
  ) {
    super(name, uneatableMenus, recommendedMenus);
  }

  @Override
  public String toString() {
    return String.format("[ %s | %s ]",
        name,
        recommendedMenus.getRecommendedMenus().stream()
            .map(Menu::getName)
            .collect(Collectors.joining(" | "))
    );
  }
}
