package menu.domain.category;

import java.util.List;

public final class RecommendedCategories {

  private final List<Category> categories;

  private RecommendedCategories(final List<Category> categories) {
    this.categories = categories;
  }

  public static RecommendedCategories of(final List<Category> categories) {
    return new RecommendedCategories(categories);
  }

  public Category get(final int index) {
    return categories.get(index);
  }
}
