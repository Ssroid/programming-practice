import re
import matplotlib.pyplot as plt

log_file = "apache_logs.txt"
ip_pattern = r"\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}"

ip_counts = {}

with open(log_file, "r") as f:
    # 파일의 각 줄을 반복문으로 처리
    for line in f:
        fields = line.split()

        # IP 주소 개수 세기
        # ip_address = fields[0]
        ip_address = re.search(ip_pattern, fields[0]).group(0)
        
        if ip_address in ip_counts:
            ip_counts[ip_address] += 1
        else:
            ip_counts[ip_address] = 1

    # ip_counts의 items()에서 value값(개수)을 기준으로 내림차순 정렬 
    sorted_ips = sorted(ip_counts.items(), key=lambda x: x[1], reverse=True)
    top_ips = sorted_ips[:10]
    
    # IP 횟수를 기준으로 가로 막대 그래프로 출력
    print(range(len(top_ips)), [count for ip, count in  top_ips])
    print(range(len(top_ips)), [ip for ip, count in top_ips])
    # plt 보여주는 size 조정
    plt.figure(figsize=(10,4))
    plt.barh(range(len(top_ips)), [count for ip, count in  top_ips])
    plt.yticks(range(len(top_ips)), [ip for ip, count in top_ips])
    plt.xlabel('IP 주소')
    plt.ylabel('접속 횟수')
    plt.title('Access Rank By IP Address')
    plt.show()    

        