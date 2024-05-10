import re

log_file = "apache_logs.txt"

with open(log_file, "r") as f:
    for line in f:
        match = re.search(r"\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}", line)
        if match:
            ip_address = match.group(0)
            print(ip_address)