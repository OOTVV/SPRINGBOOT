# 🌟 프로젝트 컨벤션 가이드

## ✉️ Commit Message Rules

### 📌 Commit Convention
`[태그] 제목` 형태로 작성

| 태그 | 설명 |
|------|------|
| FEAT | 새로운 기능 추가 |
| FIX | 버그 수정 |
| CHORE | 짜잘한 수정 |
| DOCS | 문서 수정 |
| INIT | 초기 설정 |
| TEST | 테스트 코드 추가/수정 |
| RENAME | 파일/폴더명 수정 또는 이동 |
| STYLE | 코드 포맷팅, 세미콜론 누락 등 |
| REFACTOR | 코드 리팩토링 |

예시) `[FEAT] 검색 api 추가`

## 💻 Github Management

### Gitflow Workflow
- **develop**: 기능들의 통합 브랜치
- **feature**: 기능 단위 브랜치
- **hotfix**: 버그 수정 브랜치

## ✍🏻 Code Convention

### 일반 규칙
- 메서드 길이: 12줄 이내
- 깊이(depth): 3 이내
- Lombok의 val 사용

### Entity 규칙
- id 생성 전략: IDENTITY 사용
- @NoArgsConstructor: access = PROTECTED

### 네이밍 규칙
- Controller DTO: `${Entity명}${List}${행위/상태}${Request/Response}`
- Service DTO: `${Entity명}${List}${행위/상태}Service${Request/Response}`

### Response 규칙
- 성공: BaseResponse + SuccessCode 구현체
- 실패: Exception + FailureCode 구현체

### Contoller의 메서드

> 컨트롤러의 메소드명은 해당 메소드가 수행하는 작업을 설명하는 동사로 시작합니다.
> 주로 HTTP 요청 메소드(GET, POST, PUT, DELETE 등)와 관련된 동사를 사용합니다.
> 예를 들어, 데이터를 조회하는 메소드의 경우 get으로 시작하고, 데이터를 생성하는 메소드의 경우 create로 시작합니다.
> 예시: getUserById, createUser, updateUser, deleteUser 등

### Service의 메서드 

> 서비스의 메소드명은 해당 메소드가 제공하는 기능이나 업무를 명확하게 설명하는 동사로 시작합니다.
> 비즈니스 로직이나 특정 업무 처리를 담당하는 메소드의 이름을 지을 때 주로 사용됩니다.
> 예를 들어, 주문을 처리하는 메소드의 경우 processOrder와 같이 설명적인 동사를 사용합니다.
> 예시: processOrder, calculateTotalPrice, cancelReservation 등

### Repository의 메서드 

> 레포지토리의 메소드명은 데이터베이스와 관련된 작업을 수행하는데, 주로 데이터베이스에서 데이터를 조회, 삽입, 갱신, 삭제하는 동작을 나타냅니다.
> 주로 CRUD(Create, Read, Update, Delete) 기능과 관련된 동사를 사용합니다.
> 예를 들어, 사용자를 검색하는 메소드의 경우 findByUsername과 같이 시작합니다.
> 예시: findById, save, delete, findByUsername, findAllByCategory 등

## 📍 Gitflow 규칙
1. develop 브랜치 직접 commit/push 금지
2. 작업 전 issue 생성 필수
3. Pull Request와 issue 연동
4. 전원 코드리뷰 진행
5. feature 브랜치에서 개발 후 PR

### ❗️ Branch Naming Convention
- `develop`
- `feature/issue_number`
- `fix/issue_number`
- `release/version_number`
- `hotfix/issue_number`

예시) `feature/#3`

## 📋 Code Review Convention
| 우선순위 | 의미 | 상태 |
|---------|------|------|
| P1 | 꼭 반영해주세요 | Request changes |
| P2 | 적극적으로 고려해주세요 | Request changes |
| P3 | 웬만하면 반영해 주세요 | Comment |
| P4 | 반영해도 좋고 넘어가도 좋습니다 | Approve |
| P5 | 사소한 의견입니다 | Approve |

## 🚀 Test Code Convention
1. given, when, then 구조 사용
2. 테스트 메서드명: `메서드명_테스트상태_예상결과`
   - 예시: `customizeAccount_NoColorProvided_DefaultColorIsSet`
3. 엣지 케이스까지 꼼꼼히 작성
4. 다수의 값 테스트: @ParameterizedTest 활용
