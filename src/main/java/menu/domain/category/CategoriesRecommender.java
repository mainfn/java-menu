package menu.domain.category;

import java.util.ArrayList;
import java.util.List;

public final class CategoriesRecommender {

  private final CategoryPicker categoryPicker;

  public CategoriesRecommender(final CategoryPicker categoryPicker) {
    this.categoryPicker = categoryPicker;
  }

  public RecommendedCategories recommend() {
    final List<Category> categories = new ArrayList<>();

    while (categories.size() < 5) {
      final Category category = categoryPicker.pick();
      if (canRecommend(categories, category)) {
        categories.add(category);
      }
    }

    return RecommendedCategories.of(categories);
  }


  public boolean canRecommend(
      final List<Category> categories,
      final Category category
  ) {
    return categories.stream()
        .filter(c -> c == category)
        .count() < 2;
  }

}
