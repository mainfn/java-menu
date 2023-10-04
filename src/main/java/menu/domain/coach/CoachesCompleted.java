package menu.domain.coach;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.category.RecommendedCategories;

public final class CoachesCompleted extends Coaches {

  public CoachesCompleted(
      final List<Coach> coaches,
      final RecommendedCategories recommendedCategories
  ) {

    super(coaches, recommendedCategories);
  }

  @Override
  public String toString() {
    return String.join("\n", List.of(
        "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]",
        recommendedCategories.toString(),
        coaches.stream().map(Coach::toString).collect(Collectors.joining("\n"))
    ));
  }

}
