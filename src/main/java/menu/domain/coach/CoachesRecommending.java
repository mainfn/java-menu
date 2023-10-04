package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import menu.domain.category.Category;
import menu.domain.category.RecommendedCategories;
import menu.domain.menu.UneatableMenus;
import menu.util.RecommendedMenuPicker;

public final class CoachesRecommending extends Coaches {

  private CoachesRecommending(
      final List<Coach> coaches,
      final RecommendedCategories recommendedCategories
  ) {
    super(coaches, recommendedCategories);
  }

  public static CoachesRecommending from(
      final List<String> coachNames,
      final RecommendedCategories recommendedCategories
  ) {
    final List<Coach> coaches = new ArrayList<>();

    for (final String coachName : coachNames) {
      coaches.add(CoachRecommending.of(coachName));
    }
    return new CoachesRecommending(coaches, recommendedCategories);
  }

  public void recommendMenus(final RecommendedMenuPicker menuPicker) {
    Optional<Category> category = recommendedCategories.nextCategory();
    while (category.isPresent()) {
      for (final Coach coach : coaches) {
        ((CoachRecommending) coach).recommendByCategory(category.get(), menuPicker);
      }
      category = recommendedCategories.nextCategory();
    }
  }

  public CoachesCompleted intoCompleted() {
    return new CoachesCompleted(coaches, recommendedCategories);
  }

  public void addUneatableMenusTo(
      final String coachName,
      final UneatableMenus uneatableMenus
  ) {
    final CoachRecommending coach = findCoachByName(coachName);
    coach.addUneatableMenus(uneatableMenus);
  }

  private CoachRecommending findCoachByName(final String coachName) {
    return (CoachRecommending) coaches.stream()
        .filter(c -> c.name.equals(coachName))
        .findFirst()
        .get();
  }

  public List<String> getCoachNames() {
    return coaches.stream()
        .map(Coach::getName)
        .collect(Collectors.toList());
  }

}
