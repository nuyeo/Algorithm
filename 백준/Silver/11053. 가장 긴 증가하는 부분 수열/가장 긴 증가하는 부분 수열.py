# 수열 a의 크기 n 입력받기
n = int(input())

# 수열 a 입력받기
a = list(map(int, input().split()))

# dp
dp = [1] * n
for i in range(1, n):
    for j in range(i):
        if a[i] > a[j]:
            dp[i] = max(dp[i], dp[j]+1)
            
print(max(dp))
