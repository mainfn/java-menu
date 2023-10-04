package menu.domain.category;

import java.util.HashMap;
import java.util.Map;

public enum Category {
  JAPENESE("일식", 1),
  KOREAN("한식", 2),
  CHINESE("중식", 3),
  ASIAN("아시안", 4),
  WESTERN("양식", 5);
  private static final Map<Integer, Category> mp = new HashMap<>();

  static {
    for (final Category category : values()) {
      mp.put(category.code, category);
    }
  }

  private final String name;
  private final int code;

  Category(final String name, final int code) {
    this.name = name;
    this.code = code;
  }

  public static Category of(final int code) {
    final Category category = mp.get(code);
    if (category == null) {
      throw new IllegalArgumentException("유효하지 않은 Category입니다.");
    }
    return category;
  }
}
