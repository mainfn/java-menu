package menu.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.domain.menu.Category;

public final class WeeklyCategoriesPicker {

  private final RandomCategoryPicker categoryPicker;

  public WeeklyCategoriesPicker(final RandomCategoryPicker categoryPicker) {
    this.categoryPicker = categoryPicker;
  }

  public List<Category> pick() {
    final Set<Category> categories = new HashSet<>();

    while (categories.size() < 5) {
      final Category category = categoryPicker.pick();
      if (!hasSameCategoryMoreThanTwo(category, categories)) {
        categories.add(category);
      }
    }

    return new ArrayList<>(categories);
  }

  private boolean hasSameCategoryMoreThanTwo(
      final Category category,
      final Set<Category> set
  ) {
    return set.stream()
        .filter(c -> c == category)
        .count() > 2;
  }
}
