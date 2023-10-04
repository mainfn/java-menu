package menu.domain.coach;

import java.util.List;
import menu.domain.category.RecommendedCategories;

public abstract class Coaches {

  protected final List<Coach> coaches;

  protected final RecommendedCategories recommendedCategories;

  protected Coaches(
      final List<Coach> coaches,
      final RecommendedCategories recommendedCategories
  ) {
    this.coaches = coaches;
    this.recommendedCategories = recommendedCategories;
  }

}
