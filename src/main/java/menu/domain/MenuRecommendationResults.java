// domain/MenuRecommendationResults.java
package menu.domain;

import java.util.List;
import java.util.stream.Collectors;

public final class MenuRecommendationResults {


  private final List<MenuRecommendationResult> menuRecommendationResults;
  private final List<Category> recommendedCategories;

  private MenuRecommendationResults(
      final List<MenuRecommendationResult> menuRecommendationResults,
      final List<Category> recommendedCategories
  ) {
    this.menuRecommendationResults = menuRecommendationResults;
    this.recommendedCategories = recommendedCategories;
  }

  public static MenuRecommendationResults of(
      final List<MenuRecommendationResult> menuRecommendationResults,
      final List<Category> recommendedCategories
  ) {
    return new MenuRecommendationResults(menuRecommendationResults, recommendedCategories);
  }

  @Override
  public String toString() {

    // 추천된 카테고리를 문자열로 포맷팅
    final String formattedCategories = String.format("[ 카테고리 | %s ]\n",
        recommendedCategories.stream()
            .map(Category::getName)
            .collect(Collectors.joining(" | "))
    );

    // 각 코치의 formattedMenuNames를 - [ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ] 형태
    // \n을 구분자로 연결하여 하나의 문자열로 만들어줌
    final String formattedMenus = menuRecommendationResults.stream()
        .map(MenuRecommendationResult::toString)
        .collect(Collectors.joining("\n"));

    return "메뉴 추천 결과입니다.\n" +
        "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n" +
        formattedCategories +
        formattedMenus +
        "\n" +
        "추천을 완료했습니다.";
  }
}