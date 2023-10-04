package menu.domain.coach;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import menu.domain.category.RecommendedCategories;
import menu.domain.menu.Menu;
import menu.domain.menu.UneatableMenus;
import menu.util.RandomCategoryPicker;
import menu.util.RandomNumberPicker;
import menu.util.RecommendedCategoriesGenerator;
import menu.util.RecommendedMenuPicker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachesRecommendingTest {

  @DisplayName("코치 이름과 카테고리 생성기를 통해 Coaches 생성 가능하다.")
  @Test
  void createCoaches() {
    // given
    final RandomNumberPicker randomNumberPicker = new RandomNumberPicker(1, 5);
    final RandomCategoryPicker randomCategoryPicker = new RandomCategoryPicker(randomNumberPicker);

    final RecommendedCategoriesGenerator recommendedCategoriesGenerator = new RecommendedCategoriesGenerator(
        randomCategoryPicker);
    final RecommendedCategories recommendedCategories = recommendedCategoriesGenerator.generate();
    final CoachesRecommending coaches = CoachesRecommending.from(List.of("aa", "bb", "cc"),
        recommendedCategories);

    // when
    final List<String> coachNames = coaches.getCoachNames();

    // then
    assertThat(coachNames).hasSize(3);
    assertThat(coachNames).containsExactly(
        "aa",
        "bb",
        "cc"
    );
  }

  @DisplayName("메뉴 추천 이후에는 추천 카테고리를 더 이상 받을 수 없다.")
  @Test
  void cannotRecommendCategoryAfterMenuRecommendation() {
    // given
    final RandomNumberPicker randomNumberPicker = new RandomNumberPicker(1, 5);
    final RandomCategoryPicker randomCategoryPicker = new RandomCategoryPicker(randomNumberPicker);

    final RecommendedCategoriesGenerator recommendedCategoriesGenerator = new RecommendedCategoriesGenerator(
        randomCategoryPicker);
    final RecommendedCategories recommendedCategories = recommendedCategoriesGenerator.generate();
    final CoachesRecommending coaches = CoachesRecommending.from(List.of("aa", "bb", "cc"),
        recommendedCategories);
    final RecommendedMenuPicker recommendedMenuPicker = new RecommendedMenuPicker();

    // when
    coaches.recommendMenus(recommendedMenuPicker);

    // then
    assertThat(coaches.recommendedCategories.nextCategory()).isEmpty();
  }


  @DisplayName("UneatableMenu로 등록한 메뉴는 추천되지 않는다.")
  @Test
  void notRecommendUneatableMenus() {
    for (int i = 0; i < 100_000; i++) {

      // given
      final RandomNumberPicker randomNumberPicker = new RandomNumberPicker(1, 5);
      final RandomCategoryPicker randomCategoryPicker = new RandomCategoryPicker(
          randomNumberPicker);

      final RecommendedCategoriesGenerator recommendedCategoriesGenerator = new RecommendedCategoriesGenerator(
          randomCategoryPicker);
      final RecommendedCategories recommendedCategories = recommendedCategoriesGenerator.generate();
      final CoachesRecommending coaches = CoachesRecommending.from(List.of("aa", "bb", "cc"),
          recommendedCategories);
      final RecommendedMenuPicker recommendedMenuPicker = new RecommendedMenuPicker();

      // when
      final UneatableMenus uneatableMenus = UneatableMenus.of(List.of(Menu.M1));
      coaches.addUneatableMenusTo("aa", uneatableMenus);
      coaches.addUneatableMenusTo("bb", uneatableMenus);
      coaches.addUneatableMenusTo("cc", uneatableMenus);
      coaches.recommendMenus(recommendedMenuPicker);

      // then
      final CoachesCompleted coachesCompleted = coaches.intoCompleted();
      final String str = coachesCompleted.toString();
      assertThat(str).doesNotContain(Menu.M1.getName());
    }
  }
}