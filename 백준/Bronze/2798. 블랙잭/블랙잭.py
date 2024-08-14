import sys

input = sys.stdin.readline
n, m = map(int, input().split())
card = list(map(int, input().split()))

sum = 0
max = 0

for j in range(n-2):
    for k in range(j+1, n-1):
        for l in range(k+1, n):
            sum = card[j] + card[k] + card[l]
            if max < sum <= m:
                max = sum

print(max)