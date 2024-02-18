# 테스트 케이스 개수 t 입력받기
t = int(input())

# dp 테이블 초기화
dp = [0] * 101

# dp 수행
for _ in range (t):
    n = int(input())
    for i in range (1, n+1):
        if i == 1 or i == 2 or i == 3:
            dp[i] = 1
        elif i == 4 or i == 5:
            dp[i] = 2
        elif i == 6:
            dp[i] = 3
        elif i == 7:
            dp[i] = 4
        elif i == 8:
            dp[i] = 5
        else:
            dp[i] = dp[i-1] + dp[i-5]
    print(dp[n])

    