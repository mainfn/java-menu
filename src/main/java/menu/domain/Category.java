package menu.domain;

public enum Category {
  JAPANESE(1, "일식"),
  KOREAN(2, "한식"),
  CHINESE(3, "중식"),
  ASIAN(4, "아시안"),
  WESTERN(5, "양식");

  private final int code;
  private final String name;

  Category(
      final int code,
      final String name
  ) {
    this.code = code;
    this.name = name;
  }

  public static Category of(final int code) {
    if (code == 1) {
      return Category.JAPANESE;
    }
    if (code == 2) {
      return Category.KOREAN;
    }
    if (code == 3) {
      return Category.CHINESE;
    }
    if (code == 4) {
      return Category.ASIAN;
    }
    if (code == 5) {
      return Category.WESTERN;
    }
    throw new IllegalArgumentException("[ERROR] 존재하지 않는 카테고리입니다.");
  }

  public String getName() {
    return name;
  }
}
