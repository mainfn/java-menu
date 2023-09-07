package menu.domain;

public final class MenuRecommender {

  private final RandomMenuPicker randomMenuPicker;

  public MenuRecommender(final RandomMenuPicker randomMenuPicker) {
    this.randomMenuPicker = randomMenuPicker;
  }

  // 메뉴 추천 기능
  public void recommend(
      final Coaches coaches,
      final CategoryRecommender categoryRecommender
  ) {
    coaches.recommend(categoryRecommender, randomMenuPicker);
  }
}
