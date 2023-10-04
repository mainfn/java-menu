package menu.util;

import menu.domain.menu.Category;

public final class RandomCategoryPicker {

  private final NumberPicker numberPicker;

  public RandomCategoryPicker(final NumberPicker numberPicker) {
    this.numberPicker = numberPicker;
  }

  public Category pick() {
    return Category.of(numberPicker.pick());
  }
}
