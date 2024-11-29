# 프로젝트 설명

# 설계
## API 명세
### 환전 
등록

- Method : POST
- URI:/exchanges
- Request
    - PathVariable : 없음
    - RequestBody :

      |   | 이름          | 타입   | 필수여부 | 설명           |
      |---|-------------|------|------|--------------|
      | 1 | userId     | Long | 필수   | 사용자 식별자      |
      | 2 | currencyId | Long | 필수   | 환전 대상 통화 식별자 |
      | 3 | amountInKrw       | int  | 필수   | 환전 전 금액      |


- Response

  |   | 이름                    | 타입     | 설명        |
      |---|-----------------------|--------|-----------|
  | 1 | exchangeId           | Long   | 환전 요청 식별자 |
  | 2 | userId               | Long   | 사용자 식별자   |
  | 3 | currencyId           | Long   | 환전 대상 식별자 |
  | 4 | amountInKrw         | Long   | 환전 후 식별자  |
  | 4 | amountAfterExchange | Long   | 환전 후 식별자  |
  | 5 | status                | Long   | 환전 요청 식별자 |
  | 6 | modifiedAt           | Long   | 환전 요청 식별자 |

조회

- Method : GET
- URI:/exchanges/{user_id}
- Request
    - PathVariable :

      |   | 이름          | 타입     | 필수여부 | 설명           |
            |---|-------------|--------|------|--------------|
      | 1 | userId     | Long   | 필수   | 사용자 식별자      |
    - RequestBody : 없음


- Response

  |   | 이름                    | 타입     | 설명        |
    |---|-----------------------|--------|-----------|
  | 1 | exchangeId           | Long   | 환전 요청 식별자 |
  | 2 | userId               | Long   | 사용자 식별자   |
  | 3 | currencyId           | Long   | 환전 대상 식별자 |
  | 4 | amountInKrw         | Long   | 환전 후 식별자  |
  | 4 | amountAfterExchange | Long   | 환전 후 식별자  |
  | 5 | status                | Long   | 환전 요청 식별자 |
  | 6 | modifiedAt           | Long   | 환전 요청 식별자 |

 환전 상태 취소

- Method : GET
- URI:/exchanges/{exchange_id}
- Request
    - PathVariable :

      |   | 이름          | 타입     | 필수여부 | 설명     |
            |---|-------------|--------|------|--------|
      | 1 | exchangeId | Long   | 필수   | 환전 식별자 |
    - RequestBody : 없음


- Response

  |   | 이름                    | 타입     | 설명        |
      |---|-----------------------|--------|-----------|
  | 1 | exchangeId           | Long   | 환전 요청 식별자 |
  | 2 | userId               | Long   | 사용자 식별자   |
  | 3 | currencyId           | Long   | 환전 대상 식별자 |
  | 4 | amountInKrw         | Long   | 환전 후 식별자  |
  | 4 | amountAfterExchange | Long   | 환전 후 식별자  |
  | 5 | status                | Long   | 환전 요청 식별자 |
  | 6 | modifiedAt           | Long   | 환전 요청 식별자 |

---
## ERD
![img.png](img.png)


---
# 시도해본것과 이유
- @PostConstruct 
- 기존 프로젝트에 들어간다는 생각으로 코드 스타일을 맞춰보았다.
- 환율 계산 기능과 @PostConstruct로 validate 해주는 코드를 따로 util로 관리해주었다
- 환율 계산 유틸은 공유하는 데이터가 없고 단순 기능이기 때문에 util로 분리해보았다.

---
# 어려웠던 점
## 트러블 슈팅
https://velog.io/@minkyeongk0418/%ED%8A%B8%EB%9F%AC%EB%B8%94-%EC%8A%88%ED%8C%85-%ED%99%98%EC%A0%84-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8
