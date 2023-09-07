package menu.domain;

public final class Coach {

  private final String name;
  private final UneatableMenus uneatableMenus;
  private final RecommendedMenus recommendedMenus = RecommendedMenus.empty();


  private Coach(
      final String name,
      final UneatableMenus uneatableMenus
  ) {
    validateNameLength(name);
    this.name = name;
    this.uneatableMenus = uneatableMenus;
  }

  public static Coach of(
      final String name,
      final UneatableMenus uneatableMenus
  ) {
    return new Coach(name, uneatableMenus);
  }

  private void validateNameLength(final String name) {
    if (name == null || name.length() < 2 || name.length() > 4) {
      throw new IllegalArgumentException("[ERROR] 코치 이름은 최소 2글자, 최대 4글자이다.");
    }
  }

  // 추천 음식 추가
  public void addRecommendedMenu(
      final RandomMenuPicker randomMenuPicker,
      final Category category
  ) {
    // 임의의 메뉴 생성
    final Menu menu = randomMenuPicker.pickByCategory(category);

    // 먹을 수 없는 메뉴거나 이미 추천 메뉴로 등록 되어 있으면 재귀 호출
    if (!uneatableMenus.canEat(menu) || recommendedMenus.isDuplicateMenu(menu)) {
      addRecommendedMenu(randomMenuPicker, category);
      return;
    }

    // 가능하면 등록
    recommendedMenus.add(menu);
  }

  public MenuRecommendationResult intoMenuRecommendationResult() {
    return MenuRecommendationResult.of(name, recommendedMenus.getRecommendedMenus());
  }

}
