package menu.domain.category;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class RecommendedCategories {

  private static final int MAX_CATEGORY_COUNT = 5;
  private final List<Category> categories;
  private int nextIndex = 0;

  private RecommendedCategories(final List<Category> categories) {
    this.categories = categories;
  }

  public static RecommendedCategories of(final List<Category> categories) {
    return new RecommendedCategories(categories);
  }

  public Optional<Category> get() {
    if (MAX_CATEGORY_COUNT == nextIndex) {
      return Optional.empty();
    }
    return Optional.of(categories.get(nextIndex++));
  }


  @Override
  public String toString() {
    return String.format("[ 카테고리 | %s ]",
        categories.stream()
            .map(Category::getName)
            .collect(Collectors.joining(" | "))
    );
  }
}
