package menu.util;

import static org.assertj.core.api.Assertions.assertThat;

import menu.domain.category.RecommendedCategories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RecommendedCategoriesGeneratorTest {

  @DisplayName("추천 카테고리는 5개 생성된다.")
  @Test
  void createCategories() {
    // given
    final RandomNumberPicker randomNumberPicker = new RandomNumberPicker(1, 5);
    final RecommendedCategoriesGenerator recommendedCategoriesGenerator = new RecommendedCategoriesGenerator(
        new RandomCategoryPicker(randomNumberPicker));
    final RecommendedCategories categories = recommendedCategoriesGenerator.generate();

    // when
    // then
    assertThat(categories.nextCategory()).isPresent();
    assertThat(categories.nextCategory()).isPresent();
    assertThat(categories.nextCategory()).isPresent();
    assertThat(categories.nextCategory()).isPresent();
    assertThat(categories.nextCategory()).isPresent();
    assertThat(categories.nextCategory()).isEmpty();
  }
}