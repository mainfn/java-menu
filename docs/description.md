# 도메인 객체 설계 V1

---

# enums

## 1. Category

### data

- 카테고리명

---

## 2. Menu

### data

- 메뉴명
- 카테고리

--- 

# Class

## 1. Coach

### data

- 이름
- 못 먹는 음식 목록
- 추천 받은 메뉴 목록

### behaviours

- 추천 메뉴 추가
- 못 먹는 음식 추가

---

## 2. Coaches

### data

- 포함된 코치 목록

### behaviours

## 3. RandomCategoryPicker

### behaviours

- 랜덤으로 카테고리를 골라줌

## 4. RandomMenuPicker

### behaviours

- 랜덤으로 메뉴 골라줌(인자로 카테고리를 받음)

---

## 5. CategoryRecommender

### data

- 메뉴 추천에 사용된 카테고리 목록(최대 5개)
- 랜덤 카테고리 선택을 위한 `RandomCategoryPicker`

### behaviours

- 주간 메뉴 추천에 사용할 카테고리 선택 및 목록 추가

> 같은 카테고리가 2회 이상 중복되면 안 되기 때문에 검사 및 실패 시, 카테고리 선택이 성공할 때까지 재귀 호출

- 성공적으로 선택된 카테고리 반환

 ---

## 6. UneatableMenus

### data

- 못 먹는 음식 목록

### behaviours

- 못 먹는 음식 추가
- 못 먹는 음식 여부 확인

---

## 7. RecommendedMenus

### data

- 추천 받은 음식 목록

### behaviours

- 추천 음식 추가
- 이미 추천 받은 음식 여부 확인

---

## 8. MenuRecommender

### data

- 메뉴 추천을 위한 `RandomMenuPicker`

### behaviours

- 메뉴 추천 대상인 `Coaches`와 `CategoryRecommender`를 인자로 받아서 모든 코치에게 메뉴 추천 및 결과 반환

---

## 9. MenuRecommendationResult

### data

- 메뉴 추천을 받은 코치명
- 추천 받은 메뉴 목록

### behaviours

- 추천 받은 메뉴를 출력에 맞는 양식으로 변환

---

## 10. MenuRecommendationResults

### data

- 메뉴 추천 결과인 `MenuRecommendationResult`를 리스트 형태로 가짐

### behaviours

- 최종 결과를 양식에 맞춰 출력하는 문자열 형태로 변환