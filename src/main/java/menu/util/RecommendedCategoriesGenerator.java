package menu.util;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import menu.domain.category.RecommendedCategories;

public final class RecommendedCategoriesGenerator {

  private final RandomCategoryPicker categoryPicker;

  public RecommendedCategoriesGenerator(final RandomCategoryPicker categoryPicker) {
    this.categoryPicker = categoryPicker;
  }

  public RecommendedCategories generate() {
    try {
      return RecommendedCategories.of(
          Stream.generate(categoryPicker::pick)
              .limit(5)
              .collect(Collectors.toList()));
    } catch (final IllegalArgumentException e) {
      return generate();
    }
  }

}
