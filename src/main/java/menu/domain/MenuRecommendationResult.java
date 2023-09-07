package menu.domain;

import java.util.List;
import java.util.stream.Collectors;

public final class MenuRecommendationResult {

  private final String coachName;
  private final List<Menu> recommendedMenus;

  private MenuRecommendationResult(
      final String coachName,
      final List<Menu> recommendedMenus
  ) {
    this.coachName = coachName;
    this.recommendedMenus = recommendedMenus;
  }

  public static MenuRecommendationResult of(
      final String coachName,
      final List<Menu> recommendedMenus
  ) {
    return new MenuRecommendationResult(coachName, recommendedMenus);
  }

  @Override
  public String toString() {
    final String formattedMenuNames = recommendedMenus.stream()
        .map(Menu::getName)
        .collect(Collectors.joining(" | "));

    return String.format("[ %s | %s ]", coachName, formattedMenuNames);
  }
}
