package menu.domain;

import java.util.List;

public final class Coaches {

  private final List<Coach> coaches;

  private Coaches(final List<Coach> coaches) {
    validateCoachesCount(coaches);
    this.coaches = coaches;
  }

  public static Coaches of(final List<Coach> coaches) {
    return new Coaches(coaches);
  }

  private void validateCoachesCount(final List<Coach> coaches) {
    if (coaches == null || coaches.size() < 2 || coaches.size() > 5) {
      throw new IllegalStateException("[ERROR] 코치는 최소 2명, 최대 5명까지 식사를 함께 한다.");
    }
  }

  // 모든 코치에게 메뉴 추천
  public void recommend(
      final CategoryRecommender categoryRecommender,
      final RandomMenuPicker randomMenuPicker
  ) {
    while (categoryRecommender.canRecommendMore()) {
      final Category recommendedCategory = categoryRecommender.recommend();

      for (final Coach coach : coaches) {
        coach.addRecommendedMenu(randomMenuPicker, recommendedCategory);
      }
    }
  }
}
