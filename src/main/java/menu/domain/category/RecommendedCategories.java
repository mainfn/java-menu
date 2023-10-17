package menu.domain.category;

import java.util.List;
import java.util.Optional;

public final class RecommendedCategories {

  private final List<Category> categories;

  private int nextIndex = 0;

  private RecommendedCategories(final List<Category> categories) {
    this.categories = categories;
  }

  public static RecommendedCategories of(final List<Category> categories) {
    return new RecommendedCategories(categories);
  }

  public Optional<Category> get() {
    return Optional.of(categories.get(nextIndex++));
  }

}
