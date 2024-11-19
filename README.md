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

### Service/Repository 규칙
- DB 호출: save, find, update, delete
- 비즈니스 로직: create, get, update, delete
- 복수형: `${Entity명}s`

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
