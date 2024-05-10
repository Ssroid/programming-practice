## 파이썬을 이용한 웹 로그 분석 IP 추출과 시각화(보안프로젝트)

### 자료
- 자료 링크 : [elastic/examples/apache_logs](https://github.com/elastic/examples/blob/master/Common%20Data%20Formats/apache_logs/apache_logs)
- 강의1 : [파이썬을 이용한 웹 로그 분석 IP 추출과 시각화 with chatGPT](https://www.youtube.com/watch?v=tPwVIxUhddM) 
- 강의2 : [파이썬 Flask - 웹 로그 분석의 상위 IP 통계와 데이터 시각화](https://www.youtube.com/watch?v=IZ78wQ-fURM)

### accesslog.py
- 로그 파일에서 IP 부분을 정규표헌식을 활용하여 찾는 것

### accesslog_count.py
- 로그 파일을 전체 읽어서 정규표현식에 매칭되는 부분을 찾고 `ip_counts` 의 집합을 활용하여 IP 개수 세기 
- ip_counts의 items()를 활용하여 value인 1 부분을 기준으로 내림차순으로 정렬하여 상위 20개 출력

### accesslog_count2.py
- accesslog_count.py와 비슷한 방식으로 state_code 를 내림차순으로 정렬하여 matplotlib를 활용하여 막대그래프로 시각화

### accesslog_count3.py
- IP 주소의 개수를 기준으로 내림차순으로 정렬한 다음에 matplotlib를 활용하여 가로 막대그래프로 시각화

### accesslog_flask.py
- accesslog_count3.py 를 이용하여 flask를 통해 웹 브라우저로 내용을 볼 수 있도록 한다.