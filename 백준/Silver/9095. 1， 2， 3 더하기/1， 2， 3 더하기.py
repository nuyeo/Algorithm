# 테스트 케이스 개수 입력받기
t = int(input())
   
# DP 테이블 초기화
dp = [0] * 11

# DP (bottom up)
for _ in range (t):
    n = int(input())
    for i in range (1, n+1):
        if i == 1:
            dp[i] = 1
        elif i == 2:
            dp[i] = 2
        elif i == 3:
            dp[i] = 4
        else:
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
    print(dp[n])