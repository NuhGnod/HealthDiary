# HealthDiary

---
## api 명세서

- 회원가입
  - type : POST   
  - url : /users/signup
  - request body :
    ````
    {
        "id" : String,
        "name" : "",
        "password" : String,
        "email" : ""
    }
   
---
- 로그인 
  - type : POST
  - url : /users/signin
  - request body:
  ````
  {
    "id" : String,
    "password" : String,
  }
  ````
---
- 상태 기록
  - type : POST
  - url : /users/note
  - request body :
  ````
  {
    "userId" : String,
    "appendixMemo" : String,
    "conditions" : String,
    "waistPain" : String,
    "headache" : String
  }
  
  ````
- request header :
    ````
    {
        session_id : String
    }
    
    ````

---
- 내 기록 일지 보기
  - type : GET
  - url : /users/diarys{userId}
  - request parameter :
  ````
  {
    userId : string
  }
  
  ````
