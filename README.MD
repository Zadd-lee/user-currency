# API 명세
## 일정
### 등록

- Method : POST
- URI:/exchanges
- Request
    - PathVariable : 없음
    - RequestBody :

      |   | 이름          | 타입     | 필수여부 | 설명           |
      |---|-------------|--------|------|--------------|
      | 1 | user_id     | Long   | 필수   | 사용자 식별자      |
      | 2 | currency_id | Long   | 필수   | 환전 대상 통화 식별자 |
      | 3 | money       | String | 필수   | 환전 전 금액      |


- Response

  |   | 이름          | 타입     | 설명        |
      |---|-------------|--------|-----------|
  | 1 | exchange_id | Long   | 환전 요청 식별자 |

### 조회

- Method : GET
- URI:/exchanges/{user_id}
- Request
    - PathVariable :

      |   | 이름          | 타입     | 필수여부 | 설명           |
            |---|-------------|--------|------|--------------|
      | 1 | user_id     | Long   | 필수   | 사용자 식별자      |
    - RequestBody : 없음


- Response

  |   | 이름                    | 타입     | 설명        |
    |---|-----------------------|--------|-----------|
  | 1 | exchange_id           | Long   | 환전 요청 식별자 |
  | 2 | user_id               | Long   | 사용자 식별자   |
  | 3 | currency_id           | Long   | 환전 대상 식별자 |
  | 4 | amount_in_krw         | Long   | 환전 후 식별자  |
  | 4 | amount_after_exchange | Long   | 환전 후 식별자  |
  | 5 | status                | Long   | 환전 요청 식별자 |
  | 6 | modified_at           | Long   | 환전 요청 식별자 |


### 환전 상태 취소

- Method : GET
- URI:/exchanges/{exchange_id}
- Request
    - PathVariable :

      |   | 이름          | 타입     | 필수여부 | 설명     |
            |---|-------------|--------|------|--------|
      | 1 | exchange_id | Long   | 필수   | 환전 식별자 |
    - RequestBody : 없음


- Response

  |   | 이름                    | 타입     | 설명        |
      |---|-----------------------|--------|-----------|
  | 1 | exchange_id           | Long   | 환전 요청 식별자 |
  | 2 | user_id               | Long   | 사용자 식별자   |
  | 3 | currency_id           | Long   | 환전 대상 식별자 |
  | 4 | amount_in_krw         | Long   | 환전 후 식별자  |
  | 4 | amount_after_exchange | Long   | 환전 후 식별자  |
  | 5 | status                | Long   | 환전 요청 식별자 |
  | 6 | modified_at           | Long   | 환전 요청 식별자 |


### 삭제

- Method : GET
- URI:/exchanges/{user_id}
- Request
    - PathVariable :

      |   | 이름          | 타입     | 필수여부 | 설명           |
            |---|-------------|--------|------|--------------|
      | 1 | user_id     | Long   | 필수   | 사용자 식별자      |
    - RequestBody : 없음


- Response: 200 OK


### 공통 예외



## ERD



![img.png](img.png)