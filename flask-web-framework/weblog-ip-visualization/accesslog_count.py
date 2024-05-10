import re

log_file = "apache_logs.txt"
ip_pattern = r"\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}"

with open('apache_logs.txt', "r") as f:
    # 파일 내용을 문자열로 읽음
    log = f.read()

    ips = re.findall(ip_pattern, log)

    ip_counts = {}
    # 각 IP 주소의 발생 횟수를 계산
    for ip in ips:
        if ip in ip_counts:
            ip_counts[ip] += 1
        else:
            ip_counts[ip] = 1

    # IP 주소의 발생 횟수가 많은 순위로 정렬 (20개 추출)
    print(ip_counts)
    print(ip_counts.items())
    top_ips = sorted(ip_counts.items(), key=lambda x: x[1], reverse=True)[:20]

    for ip, count in top_ips:
        print(f'{count} : {ip}')