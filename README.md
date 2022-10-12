# 221012-algorithm-hospital

# 1. 알고리즘
## 1. 코드업 2081번 - codeup2081
![](https://velog.velcdn.com/images/lyj1023/post/06c67437-a15f-4f64-b432-46df182a8fd9/image.png)

 
## 2. 코드업 4596번 -codeup4596
![](https://velog.velcdn.com/images/lyj1023/post/301ad3bd-2648-4eda-942f-bd445a65987e/image.png)
![](https://velog.velcdn.com/images/lyj1023/post/3462cee5-479f-475d-a277-147f94fab0b5/image.png)


## 3. 다형성을 적용해 최대,최소값 구하기 - MinAndMax
- min과 max가 따로 메소드를 구성할 경우 index 추가등 여러 기능을 넣게 되면 모두 바꿔줘야 하기 때문에 번거롭다.
- interface와 callback을 이용해서 boolean 을 리턴한다.
- 위 코드에선 Template Callback패턴을 이용했다.
- Template Callback패턴
	1) Template Method(private)클래스 안에서만 호출되는 Template을 만든다.
	2) public -max(), min()메소드에서 Template Method를 호출 한다.
 	3) 바뀐 부분만 내부 클래스로 구현해서 parameter로 넘긴다.
 	4) interface를 선언한다.

## 4. 빅 오(big-O) 표기법
### 1. 빅오 표기법이란?
- 알고리즘의 효율성을 표기해주는 표기법이다.
- 알고리즘의 시간 복잡도와 공간 복잡도를 나타내는데 주로 사용 된다.

### 2. 빅오 표기법의 특징
1) 상수항 무시
- 빅오 표기법에선 N이 충분히 크다고 가정하기 때문에 상수항은 무시한다
- 예시) O(2N) -> O(N)

2) 영향력 없는 항 무시
- 상수항 무시와 같이 N이 충분히 크다고 가정하기 때문에 영향력 없는 항또한 무시한다.
- 예시) O(2N^2+3N+1) -> O(N^2)

### 3. 빅오 표기법 예제
1) O(1) : 스택에서 Push, Pop 
2) O(log N) : 이진트리 
3) O(N) : for 문 
4) O(Nlog N) : 퀵 정렬(quick sort), 병합정렬(merge sort), 힙 정렬(heap Sort)
5) O(N^2): 이중 for 문, 삽입정렬(insertion sort), 버블정렬(bubble sort), 선택정렬(selection sort)
6) O(2^N) : 피보나치 수열

# 2. SQL Insert하는 스크립트 만들기
## 0. 데이터 정보
- 링크: [서울시 병의원 위치 정보](http://data.seoul.go.kr/dataList/OA-20337/S/1/datasetView.do#AXexec)
- 데이터는 공공데이터로 서울시 병의원 위치 정보.csv파일이다.
- 19040건의 데이터가 들어있다.
- 다음과 같은 데이터를 얻을 수 있다.
 1) 병원분류명이 총 몇가지 일까?
 2) 병원분류별로 몇개씩 있을까? ex)의원:x개, 치과병원:y개 ...
 3) 병원 분류가 몇가지 일까?
 4) 서울의 구별로 각 병원이 몇개 있을까?
 5) 구별로 병원이 가장 많은 구는 어디일까?
 6) 이비인후과, 외과, 내과, 소아과, 피부과, 성형외과 는 각 몇개일까?
 
## 1. 논리적 설계
- 테이블 정의서를 작성하는 단계이다.
![](https://velog.velcdn.com/images/lyj1023/post/5d769f44-3941-4b85-adcb-e47be277a384/image.png)
![](https://velog.velcdn.com/images/lyj1023/post/b9de18d6-49dc-49d8-a574-b8886ff0178c/image.png)


## 2. 물리적 설계
### 1. Table 생성
![](https://velog.velcdn.com/images/lyj1023/post/13a46e52-3be4-4082-ba3e-8228553c471d/image.png)

### 2. 직접 INSERT하기
![](https://velog.velcdn.com/images/lyj1023/post/e9ac3c18-7391-41ee-bfb7-91d671aaad1c/image.png)
![](https://velog.velcdn.com/images/lyj1023/post/68538cb9-c342-4b11-8bd8-c1741ad239dd/image.png)
-Entity(Table) seoul_hospital에 1개 Row(Record) Insert한다.
```sql
INSERT INTO `likelion-db`.`seoul_hospital`
(`id`,
`address`,
`district`,
`category`,
`emergency_room`,
`name`,
`subdivision`)
VALUES
('A1120837',
'서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동)',
'서울특별시 금천구',
'C',
2,
'가산기대찬의원',
null);
```
### 3. 파일로 INSERT하기
 1) 파일에 sql문을 작성한다.
![](https://velog.velcdn.com/images/lyj1023/post/893e086c-683e-40ad-acb6-5022ddc6128e/image.png)

 2) .sql로 스크립트 파일을 저장한다.
 ![](https://velog.velcdn.com/images/lyj1023/post/dc6de02b-83b6-42ee-962f-9687fca87ff1/image.png)

 3) Workbench에서 .sql 스크립트를 불러온다.
 ![](https://velog.velcdn.com/images/lyj1023/post/c7609670-ff15-4358-80c8-971f22390e33/image.png)

 4) 불러온 .sql 스크립트를 실행한다.
 ![](https://velog.velcdn.com/images/lyj1023/post/089918ba-d340-4189-a6fa-5ab7999438bb/image.png)

 > - INSERT INTO 작성할 때 팁
 	- insert into를 한번만 써도 values에 여러개 넣을 수 있다.
    - ex)
```sql
INSERT INTO `likelion-db`.`seoul_hospital`(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`)
VALUES
('B1100027','서울특별시 강남구 도산대로 118 (논현동 신사빌딩 2층)
','서울특별시 강남구','C',2,'365엠씨의원',null),
('A1117873','서울특별시 강남구 도산대로 118 (논현동 신사빌딩 2층)
','서울특별시 강남구','C',2,'365엠씨의원',null)
;
```

### 3. Java로 SQL 파일 만들기
 0) Gradle Build로 프로젝트생성
 ![](https://velog.velcdn.com/images/lyj1023/post/3784d7e1-eedc-4c0e-ae28-3f0456bbe429/image.png)

 1) .csv에서 라인별로 읽어오기
 
 2) 다형성을 적용해서 Parser 만들기 -hospital
 
# 3. Reference

- [https://noahlogs.tistory.com/27](https://noahlogs.tistory.com/27) [인생의 로그캣:티스토리]
- [https://inpa.tistory.com/entry/DB-📚-데이터-모델링-1N-관계-📈-ERD-다이어그램](https://inpa.tistory.com/entry/DB-%F0%9F%93%9A-%EB%8D%B0%EC%9D%B4%ED%84%B0-%EB%AA%A8%EB%8D%B8%EB%A7%81-1N-%EA%B4%80%EA%B3%84-%F0%9F%93%88-ERD-%EB%8B%A4%EC%9D%B4%EC%96%B4%EA%B7%B8%EB%9E%A8)
