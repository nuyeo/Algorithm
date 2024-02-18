# x 입력받기
x = int(input())

# DP 테이블 초기화
d = [0] * (10**6 + 1)

# DP 진행 (bottom up)
for i in range(2, x+1):
    # 현재 수에서 1을 빼는 경우
    d[i] = d[i - 1] + 1
    # 현재 수가 2로 나누어 떨어지는 경우
    if i % 2 == 0:
        d[i] = min(d[i], d[i // 2] + 1)
    # 현재 수가 3으로 나누어 떨어지는 경우
    if i % 3 == 0:
        d[i] = min(d[i], d[i // 3] + 1)

print(d[x])