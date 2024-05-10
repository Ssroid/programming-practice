import re
import matplotlib.pyplot as plt

log_file = "apache_logs.txt"
ip_pattern = r"\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}"

status_counts = {}

with open(log_file, "r") as f:
    # 파일의 각 줄을 반복문으로 처리
    for line in f:
        fields = line.split()

        # IP 주소와 상태 코드 필드를 가져옴
        # ip_address = fields[0]
        ip_address = re.search(ip_pattern, fields[0]).group(0)
        status_code = fields[8]

        if status_code in status_counts:
            status_counts[status_code] += 1
        else:
            status_counts[status_code] = 1
    
    # HTTP 응답 코드 발생 횟수가 많은 순서대로 딕셔너리를 정렬
    sorted_statuses = sorted(status_counts.items(), key=lambda x: x[1], reverse=True)
    
    # 상태 코드별 접근 횟수를 막대 그래프로 출력
    # print(range(len(sorted_statuses)), [count for status, count in sorted_statuses])
    # print(range(len(sorted_statuses)), [status for status, count in sorted_statuses])
    plt.bar(range(len(sorted_statuses)), [count for status, count in sorted_statuses])
    plt.xticks(range(len(sorted_statuses)), [status for status, count in sorted_statuses])
    plt.xlabel('Status Code')
    plt.ylabel('Access Count')
    plt.title('Access Rank by Status Code')
    plt.show()

        