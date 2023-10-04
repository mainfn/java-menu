package menu.domain.category;

import java.util.List;

public final class RecommendedCategories {

  private final List<Category> categories;

  private RecommendedCategories(final List<Category> categories) {
    validateRecommendedCategories(categories);
    this.categories = categories;
  }

  public static RecommendedCategories of(final List<Category> categories) {
    return new RecommendedCategories(categories);
  }

  private void validateRecommendedCategories(final List<Category> categories) {
    for (final Category category : categories) {
      if (hasSameCategoryMoreThanTwo(category, categories)) {
        throw new IllegalArgumentException("중복 카테고리가 3회 이상 존재합니다.");
      }
    }
  }

  private boolean hasSameCategoryMoreThanTwo(
      final Category category,
      final List<Category> categories
  ) {
    return categories.stream()
        .filter(c -> c == category)
        .count() > 2;
  }


}
