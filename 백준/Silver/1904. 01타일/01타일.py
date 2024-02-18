# 수열 크기 n 입력받기
n = int(input())

# dp 테이블 초기화
dp = [0] * 10000001

# dp (bottom up)
dp[1] = 1 % 15746
dp[2] = 2 % 15746
for i in range(3, n+1):
    dp[i] = (dp[i-1] + dp[i-2]) % 15746

print(dp[n])