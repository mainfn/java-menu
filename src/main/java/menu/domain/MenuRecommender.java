package menu.domain;

public final class MenuRecommender {

  private final RandomMenuPicker randomMenuPicker;

  public MenuRecommender(final RandomMenuPicker randomMenuPicker) {
    this.randomMenuPicker = randomMenuPicker;
  }

  // 메뉴 추천 기능
  public void recommend(final Coaches coaches) {
    // 모든 코치들의 recommendedMenus에 추천 메뉴 추가
  }
}
