import sys

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

result = []
result.append(min(arr))
result.append(max(arr))
print(*result)