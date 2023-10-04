package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;

public final class Coaches {

  private final List<Coach> coaches;

  private Coaches(final List<Coach> coaches) {
    this.coaches = coaches;
  }

  public static Coaches from(final List<String> coachNames) {
    final List<Coach> coaches = new ArrayList<>();

    for (final String coachName : coachNames) {
      coaches.add(Coach.of(coachName));
    }

    return new Coaches(coaches);
  }
}
