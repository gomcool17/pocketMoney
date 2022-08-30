# PocketMoney
심부름, 알바 등 다양한 구인글을 올려서 용돈벌이를 할 수 있는 사이트

3인에서 구현

PocketMoney git 주소 : https://github.com/PoKMoney/PocketMoney

## 내가 한 부분에 대한 내용
# 회원가입
1. 실행 된 모습 
<img width="500" alt="image" src="https://user-images.githubusercontent.com/30142575/187355059-d5bb3712-1710-490e-9d1f-d4ec35d77bf2.png">

# 로그인
1. 로그인 한 모습
<img width="500" alt="image" src="https://user-images.githubusercontent.com/30142575/187355273-919264be-72d6-4816-be71-2fa14b406f47.png">
- accessToken을 반환해줌
2. kakao login
<img width="500" alt="image" src="https://user-images.githubusercontent.com/30142575/187355820-1ba49415-cf2a-4536-bd08-f17c9faf3909.png">
- 발급받은 token으로 login
- kakao login이 된 모습(id = 2), 추가 정보는 새로 받을 것
<img width="1153" alt="image" src="https://user-images.githubusercontent.com/30142575/187356253-38704b99-2f26-43f2-b130-8b65e177ced7.png">

# 게시글 및 댓글
- 이렇게 header에 token을 넣어준다
<img width="500" alt="image" src="https://user-images.githubusercontent.com/30142575/187356523-c157ade0-655b-402c-987b-cedaa15daf9e.png">

1. 게시글 작성, 수정, 삭제
- 작성 : 사진이 있을시, 사진의 key와 path(url) 반환, 없을시 null 반환
<img width="500" alt="image" src="https://user-images.githubusercontent.com/30142575/187356706-ecf4329a-afb6-4d5b-b6bf-4ce4b259e50a.png">
- 수정 : 수정시 다른 사진을 넣어도 잘 되는것 확인
- 다른 내용도 수정 가능 : 사진 및 제목이 변경된 것을 볼 수 있다.
<img width="500" alt="image" src="https://user-images.githubusercontent.com/30142575/187357249-04d6a6ad-e4d7-4081-bdf9-5ccc02352691.png">
- 삭제 : 전, 후
<img width="500" alt="image" src="https://user-images.githubusercontent.com/30142575/187357511-2a6ab959-e0ce-4d9c-8286-cc4f44ac899c.png">
<img width="500" alt="image" src="https://user-images.githubusercontent.com/30142575/187357449-9de87a8e-6cc1-4f34-824a-50fed8fefa44.png">

2. 게시글 조최
- 비회원 게시글 조회
<img width="500" alt="image" src="https://user-images.githubusercontent.com/30142575/187358458-7480d486-5663-46dd-9942-73facb55cc6b.png">
- 작성자 게시글 조회
<img width="552" alt="image" src="https://user-images.githubusercontent.com/30142575/187358628-28ba0bac-ee06-4d4a-8033-78cbda80bf0d.png">
- 비작성자 게시글 조회
<img width="631" alt="image" src="https://user-images.githubusercontent.com/30142575/187358903-b6f6e5ec-2023-49ce-93d4-0b3f794f3825.png">

3. 게시글 목록
- 현재 저장된 data
<img width="500" alt="image" src="https://user-images.githubusercontent.com/30142575/187358043-77457243-4121-4b42-9780-f63321406dc2.png">

- 최신순 부터 조회 : start -> 시작 페이지, end -> 마지막 페이지, prev,next -> 이전, 다음 페이지가 있는지
<img width="500" alt="image" src="https://user-images.githubusercontent.com/30142575/187358002-91aa1bbd-7003-43cd-bae2-97f579a0842a.png">
<img width="500" alt="image" src="https://user-images.githubusercontent.com/30142575/187358088-e5437236-2203-4d94-a7fa-31d7901c04e5.png">

4. 제목에 대한 검색
- 검색할 제목들
<img width="204" alt="image" src="https://user-images.githubusercontent.com/30142575/187360961-08d998fa-19b9-4845-8aeb-b9bb32228bee.png">
- 강아지 검색
<img width="500" alt="image" src="https://user-images.githubusercontent.com/30142575/187361062-aa29d087-27e0-4980-bee0-a7bdb483d0fc.png">
- 고양이 검색
<img width="500" alt="image" src="https://user-images.githubusercontent.com/30142575/187361156-8566a1fb-ba19-43f9-af84-c2c4611f0260.png">
- 고양 검섹 -> 고양이 포함된 제목 전부 검색
<img width="500" alt="image" src="https://user-images.githubusercontent.com/30142575/187361234-1c6222ee-35b3-4f3a-a432-05d48e241633.png">

5. 도시에 대한 검색 (근처 일자리)
- 검색할 도시들
<img width="59" alt="image" src="https://user-images.githubusercontent.com/30142575/187361581-e091ed08-c057-45ca-bc41-942b6de7a104.png">
- 서울 
<img width="500" alt="image" src="https://user-images.githubusercontent.com/30142575/187361842-4c19a646-98b3-4987-bdfa-3a3d8162f694.png">
- 인천
<img width="505" alt="image" src="https://user-images.githubusercontent.com/30142575/187361940-b04977cc-ac3e-47a5-91dc-a5299891448d.png">
- 천
<img width="585" alt="image" src="https://user-images.githubusercontent.com/30142575/187362122-d49285d3-f193-43ed-af46-f083c046d4bc.png">


6. 댓글기능은 게시글이랑 동일하게 구현
7. 예외처리들
- 회원가입시
  - 이메일 중복 에러
<img width="531" alt="image" src="https://user-images.githubusercontent.com/30142575/187355156-47d9bd9c-8d3b-4c01-9b2b-fa7e49e609fb.png">
  - 닉네임 중복 에러
<img width="521" alt="image" src="https://user-images.githubusercontent.com/30142575/187355204-a33c01b1-e7a7-4393-8949-971ed93b715b.png">

- 로그인시
  - 이메일 에러
<img width="462" alt="image" src="https://user-images.githubusercontent.com/30142575/187355405-67ce7ec4-5df6-491f-8068-5a1fb7265fc5.png">
  - 비밀번호 에러
<img width="450" alt="image" src="https://user-images.githubusercontent.com/30142575/187355446-441adf88-befa-492d-bfb4-4ca4bd93266c.png">

- 게시글 관련 (댓글도 동일)
  - 작성자가 아닌데 삭제, 수정등 접근
<img width="441" alt="image" src="https://user-images.githubusercontent.com/30142575/187362541-058ca759-76e5-41e2-b624-243b3db99940.png">
  - 존재하지 않는 게시글에 대한 접근
<img width="375" alt="image" src="https://user-images.githubusercontent.com/30142575/187362627-62bc82ec-9629-4cff-9a8f-b0b541c6600c.png">



## 💻 기술 스택 & 개발 환경
### 프레임워크/API
- Backend  : Spring Boot, Spring Data JPA, Spring Security  
- Frontend : React 
### 데이터베이스
- MariaDB(실서버), H2DB(테스트용)
### 언어
- Backend : Java
- Frontend : HTML/CSS/JS
- Database : SQL
