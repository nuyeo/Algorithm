import sys

input = sys.stdin.readline

dp = [0, 1, 3]

def tile(x):
    if x > 2:
        for i in range(3, x+1):
            dp.append((dp[i-2] * 2) + dp[i-1])
    result = dp[x] % 10007
    print(result)

n = int(input())
tile(n)