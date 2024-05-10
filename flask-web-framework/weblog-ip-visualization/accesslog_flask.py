from flask import Flask, render_template
import re, io, base64
import matplotlib.pyplot as plt
# from matplotlib import font_manager as fm

app = Flask(__name__)

# plt의 한글 깨짐 방지용
# font_path = fm.findSystemFonts(fontpaths=None, fontext='ttf')
# font_prop = fm.FontProperties(fname=font_path[0])

log_file = "apache_logs.txt"
ip_pattern = r"\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}"

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/ip-count')
def ip_count():
    # IP 주소별로 발생 횟수를 카운트하는 딕셔너리 정의
    ip_counts = {}

    # 로그 파일 열기
    with open(log_file, "r") as f:
        # 파일의 각 줄을 반복문으로 처리
        for line in f:
            fields = line.split()

            # IP 주소 필드 가져오기
            ip_address = re.search(ip_pattern, fields[0]).group(0)
            if ip_address in ip_counts:
                ip_counts[ip_address] += 1
            else:
                ip_counts[ip_address] = 1

    # ip_counts의 items()에서 value값(개수)을 기준으로 내림차순 정렬
    sorted_ips = sorted(ip_counts.items(), key=lambda x: x[1], reverse=True)
    top_ips = sorted_ips[:10]

    # IP 횟수를 기준으로 가로 막대 그래프로 출력
    plt.figure(figsize=(12,4))
    plt.barh(range(len(top_ips)), [count for ip, count in top_ips])
    plt.yticks(range(len(top_ips)), [ip for ip, count in top_ips])
    plt.xlabel('IP Address')
    plt.ylabel('IP Count')
    plt.title('Access Rank By IP Address')

    # 막대 그래프를 PNG 이미지로 저장
    buf = io.BytesIO()
    plt.savefig(buf, format="png")
    buf.seek(0)
    bar_ip_image = base64.b64encode(buf.getvalue()).decode('utf-8')
    plt.close()

    # IP 주소 접속 횟수를 파이 차트로 출력
    plt.figure(figsize=(8, 8))  # Set custom size: 8 inches by 8 inches
    plt.pie([count for ip, count in top_ips], labels=[ip for ip, count in top_ips], autopct='%1.1f%%', wedgeprops={'width':0.4, 'edgecolor':'w', 'linewidth': 5})
    plt.title('Access Distribution by IP Address')

    # 파이 차트를 PNG 이미지로 저장
    buf = io.BytesIO()
    plt.savefig(buf, format="png")
    buf.seek(0)
    pie_ip_image = base64.b64encode(buf.getvalue()).decode('utf-8')
    plt.close()

    # 전달할 데이터에 순위 추가
    ranked_ips = [(rank + 1, ip, count) for rank, (ip, count) in enumerate(sorted_ips[:10])]

    # HTML 템플릿을 렌더링하여 IP주소별 접속 랭킹을 테이블과 이미지로 출력
    return render_template('ip_rank.html', ranked_ips=ranked_ips, bar_ip_image=bar_ip_image, pie_ip_image=pie_ip_image)

@app.route('/state-count')
def state_count():
# IP 주소별로 발생 횟수를 카운트하는 딕셔너리 정의
    ip_counts = {}
    status_counts = {}

    # 로그 파일 열기
    with open(log_file, "r") as f:
        # 파일의 각 줄을 반복문으로 처리
        for line in f:
            fields = line.split()

            # IP 주소 필드 가져오기
            ip_address = re.search(ip_pattern, fields[0]).group(0)
            if ip_address in ip_counts:
                ip_counts[ip_address] += 1
            else:
                ip_counts[ip_address] = 1

            # 상태 코드 필드 가져오기
            status_code = fields[8]
            if status_code in status_counts:
                status_counts[status_code] += 1
            else:
                status_counts[status_code] = 1

    # IP 주소 접속 랭킹 데이터 생성
    sorted_ips = sorted(ip_counts.items(), key=lambda x: x[1], reverse=True)
    top_ips = sorted_ips[:10]
    ranked_ips = [(rank + 1, ip, count) for rank, (ip, count) in enumerate(sorted_ips[:10])]

    # 상태 코드 접속 랭킹 데이터 생성
    sorted_statuses = sorted(status_counts.items(), key=lambda x: x[1], reverse=True)

    # IP 횟수를 기준으로 가로 막대 그래프로 출력
    plt.figure(figsize=(10, 6))  # Set custom size: 10 inches wide, 6 inches tall
    plt.bar(range(len(sorted_statuses)), [count for status, count in sorted_statuses])
    plt.xticks(range(len(sorted_statuses)), [status for status, count in sorted_statuses])
    plt.xlabel('Status Code')
    plt.ylabel('Access Count')
    plt.title('Access Rank by Status Code')

    # 막대 그래프를 PNG 이미지로 저장
    buf = io.BytesIO()
    plt.savefig(buf, format="png")
    buf.seek(0)
    status_image_data = base64.b64encode(buf.getvalue()).decode('utf-8')
    plt.close()

    # HTML 템플릿을 렌더링하여 IP주소별 접속 랭킹을 테이블과 이미지로 출력
    return render_template('state_rank.html', ranked_ips=ranked_ips, status_image_data=status_image_data)


if __name__ == "__main__":
    app.run(debug=True)
