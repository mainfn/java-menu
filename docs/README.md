# domain

```

💡coaches: size 2~5
Coaches(List<Coach>)

💡name: len 2~4
Coach(
    String name,
    UneatableMenus uneatableMenus,
    RecommendedMenus recommendedMenus
    )
    UneatableMenu(List<Menu>)
    RecommendedMenus(List<Menu>)

💡menus: size 0~2
UneatableMenu(List<Menu>)

💡menus: size 5, duplicate category 0~2
RecommendedMenus(List<Menu>)

Category(enum)
Menu(enum)
    
RandomNumberPicker
RandomCategoryPicker
RandomWeeklyCategoriesPicker
RandomMenuPicker
```