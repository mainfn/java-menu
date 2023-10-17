package menu.domain.rand;

import menu.domain.category.Category;

public final class CategoryPicker {

  private final NumberPicker numberPicker;

  public CategoryPicker(final NumberPicker numberPicker) {
    this.numberPicker = numberPicker;
  }

  public Category pick() {
    return Category.of(numberPicker.pick());
  }
}
