package menu.domain.coach;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import menu.domain.category.Category;
import menu.domain.category.RecommendedCategories;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuPicker;

public final class Coaches {

  private final List<Coach> coaches;

  private final RecommendedCategories recommendedCategories;

  private Coaches(
      final List<Coach> coaches,
      RecommendedCategories recommendedCategories
  ) {
    this.coaches = coaches;
    this.recommendedCategories = recommendedCategories;
  }

  public static Coaches of(
      final List<Coach> coaches,
      final RecommendedCategories recommendedCategories
  ) {
    return new Coaches(coaches, recommendedCategories);
  }

  public void recommend(final MenuPicker menuPicker) {
    Optional<Category> category = recommendedCategories.get();

    while (category.isPresent()) {
      _recommend(category.get(), menuPicker);
      category = recommendedCategories.get();
    }
  }

  private void _recommend(
      final Category category,
      final MenuPicker menuPicker
  ) {
    for (final Coach coach : coaches) {
      Menu menu = menuPicker.pickByCategory(category);
      while (!coach.canRecommend(menu)) {
        menu = menuPicker.pickByCategory(category);
      }
      coach.addRecommendedMenu(menu);
    }
  }

  @Override
  public String toString() {
    return "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n" +
        recommendedCategories.toString() + "\n" +
        coaches.stream().map(Coach::toString)
            .collect(Collectors.joining("\n"));
  }

}
